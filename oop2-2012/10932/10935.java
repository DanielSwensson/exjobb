import java.util.*;

public class Program {
	private static List<Person> persons = new ArrayList<Person>();

	public static void main(String[] args) {
		String menue = "\n 1.L�gg till person \n 2. Skapa �godel \n 3. Visa alla personer"
				+ "\n 4. Visa den rikaste personen \n 5. Visa en specifik person \n 6. B�rskrash \n 7. Avsluta \n";

		System.out.println("I detta register kan du tempor�rt spara information om specifika personers �godelar. \n"
				+ "\n Sju olika kommandon kan ges:");

		while (true) {
			int menuechoice = readInputInt(menue + "Skriv ditt menyval h�r:");
			switch (menuechoice) {
			case 1:
				addPerson();
				break;
			case 2:
				addItemToPerson();
				break;
			case 3:
				printAllPersonsAndWealth();
				break;
			case 4:
				printWealthiestPersonAndBelongings();
				break;
			case 5:
				printSpecificPersonAndBelongings();
				break;
			case 6:
				crashTheStockMarket();
				break;
			case 7:
				System.exit(0);
			default:
				System.out.println("Ange en siffra som h�r till ett av de sju menyvalen.");
			}
		}
	}

	private static void addPerson() {
		String inputName = readInputString("Vad heter personen?");
		Person newPerson = new Person(inputName);
		if (persons.contains(newPerson)) {
			System.out.println("Det finns redan en person med samma namn.");
			return;
		}
		persons.add(newPerson);
	}

	private static void crashTheStockMarket() {
		for (Person person : persons) {
			person.stockMarketCrash();
		}
	}

	private static String readInputString(String textToPrint) {
		System.out.println(textToPrint);
		Scanner keyboard = new Scanner(System.in);
		return keyboard.nextLine();
	}

	private static int readInputInt(String textToPrint) {
		System.out.println(textToPrint);
		Scanner keyboard = new Scanner(System.in);
		try {
			int inputInt = keyboard.nextInt();
			keyboard.nextLine();
			return inputInt;
		} catch (Exception e) {
			return 0;
		}
	}

	private static void addItemToPerson() {
		printAllPersonsAndWealth();
		String inputName = readInputString("\nDe personer som finns i registret visas ovan. Ange vilken av dem som ska f� en ny �godel:");
		Person personToSearchFor = new Person(inputName);
		if (!persons.contains(personToSearchFor)) {
			System.out.println("Person med namnet " + inputName
					+ " finns inte.");
			return;
		}

		int personIndex = persons.indexOf(personToSearchFor);
		Person existingPerson = persons.get(personIndex);
		Item newitem = readItem();
		existingPerson.addItem(newitem);
	}

	private static void printAllPersonsAndWealth() {
		for (Person person : persons) {
			System.out.println(person);
		}
	}

	private static void printWealthiestPersonAndBelongings() {
		Person wealthiestPerson = new Person("personNotFound");
		for (Person person : persons) {
			if (wealthiestPerson.calculateValueOfBelongings() < person.calculateValueOfBelongings())
				wealthiestPerson = person;
		}
		System.out.println(wealthiestPerson.getName()
				+ " har �godelar till ett v�rde av "
				+ wealthiestPerson.calculateValueOfBelongings());
		for (Item item : wealthiestPerson.getItems()) {
			System.out.println(item);
		}

	}

	private static void printSpecificPersonAndBelongings() {
		printAllPersonsAndWealth();
		String inputName = readInputString("\nDe personer som finns i registret visas ovan. Ange vilken person du vill visa:");
		Person personToSearchFor = new Person(inputName);
		if (!persons.contains(personToSearchFor)) {
			System.out.println("Person med namnet " + inputName
					+ " finns inte.");
			return;
		}

		int personIndex = persons.indexOf(personToSearchFor);
		Person existingPerson = persons.get(personIndex);
		System.out.println(existingPerson.getName()
				+ " har �godelar till ett v�rde av "
				+ existingPerson.calculateValueOfBelongings());
		for (Item item : existingPerson.getItems()) {
			System.out.println(item);
		}
	}

	private static Item readItem() {
		while (true) {
			int menuechoice = readInputInt("Vilken typ av �godel vill du l�gga till?\n1. Elektronik \n2. Smycke \n3. Aktie");
			switch (menuechoice) {
			case 1:
				return readElectronics();
			case 2:
				return readJewelry();
			case 3:
				return readStock();
			default:
				System.out.println("Ange en siffra som h�r till ett av de tre menyvalen.");
			}
		}
	}

	private static Electronics readElectronics() {
		String name = readInputString("Vad heter produkten?");
		int price = readInputInt("Vad �r priset p� produkten?");
		int condition = readInputInt("I vilket skick befinnner sig produkten? Skriv en siffra mellan 1(Sliten) och 10(Ny):");
		return new Electronics(name, price, condition);
	}

	private static Jewelry readJewelry() {
		while (true) {
			int material = readInputInt("Skriv 1 om smycket �r av guld, eller 2 om det �r av silver:");
			if (material == 1 || material == 2) {
				int numberOfGemstones = readInputInt("Hur m�nga �delstenar har smycket?");
				String name = readInputString("Vad �r det f�r slags smycke?");
				return new Jewelry(material, numberOfGemstones, name);
			} else
				System.out.println("M�ste vara 1 eller 2");
		}
	}

	private static Stock readStock() {
		int amount = 0;
		int price = 0;
		String name = null;
		Scanner keyboard = new Scanner(System.in);
		name = readInputString("Till vilket f�retag h�r aktierna?");
		while (true) {
			amount = readInputInt("Hur m�nga aktier vill du l�gga till?");
			if (amount != 0)
				break;
		}
		while (true) {
			price = readInputInt("Hur mycket kostar aktien?");
			if (price != 0)
				break;
		}
		return new Stock(name, amount, price);
	}
}
