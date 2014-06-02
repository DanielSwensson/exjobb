import java.util.*;

public class Program {
	private static List<Person> persons = new ArrayList<Person>();

	public static void main(String[] args) {
		String menue = "\n 1.Lägg till person \n 2. Skapa ägodel \n 3. Visa alla personer"
				+ "\n 4. Visa den rikaste personen \n 5. Visa en specifik person \n 6. Börskrash \n 7. Avsluta \n";

		System.out.println("I detta register kan du temporärt spara information om specifika personers ägodelar. \n"
				+ "\n Sju olika kommandon kan ges:");

		while (true) {
			int menuechoice = readInputInt(menue + "Skriv ditt menyval här:");
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
				System.out.println("Ange en siffra som hör till ett av de sju menyvalen.");
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
		String inputName = readInputString("\nDe personer som finns i registret visas ovan. Ange vilken av dem som ska få en ny ägodel:");
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
				+ " har ägodelar till ett värde av "
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
				+ " har ägodelar till ett värde av "
				+ existingPerson.calculateValueOfBelongings());
		for (Item item : existingPerson.getItems()) {
			System.out.println(item);
		}
	}

	private static Item readItem() {
		while (true) {
			int menuechoice = readInputInt("Vilken typ av ägodel vill du lägga till?\n1. Elektronik \n2. Smycke \n3. Aktie");
			switch (menuechoice) {
			case 1:
				return readElectronics();
			case 2:
				return readJewelry();
			case 3:
				return readStock();
			default:
				System.out.println("Ange en siffra som hör till ett av de tre menyvalen.");
			}
		}
	}

	private static Electronics readElectronics() {
		String name = readInputString("Vad heter produkten?");
		int price = readInputInt("Vad är priset på produkten?");
		int condition = readInputInt("I vilket skick befinnner sig produkten? Skriv en siffra mellan 1(Sliten) och 10(Ny):");
		return new Electronics(name, price, condition);
	}

	private static Jewelry readJewelry() {
		while (true) {
			int material = readInputInt("Skriv 1 om smycket är av guld, eller 2 om det är av silver:");
			if (material == 1 || material == 2) {
				int numberOfGemstones = readInputInt("Hur många ädelstenar har smycket?");
				String name = readInputString("Vad är det för slags smycke?");
				return new Jewelry(material, numberOfGemstones, name);
			} else
				System.out.println("Måste vara 1 eller 2");
		}
	}

	private static Stock readStock() {
		int amount = 0;
		int price = 0;
		String name = null;
		Scanner keyboard = new Scanner(System.in);
		name = readInputString("Till vilket företag hör aktierna?");
		while (true) {
			amount = readInputInt("Hur många aktier vill du lägga till?");
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
