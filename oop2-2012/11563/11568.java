import java.util.ArrayList;
import java.util.Scanner;

public class Registry {

	private static Scanner sc = new Scanner(System.in);
	private static ArrayList<Person> persons = new ArrayList<Person>();

	public static void main(String[] args) {

		String command = new String();

		System.out
				.println("Välkommen! För en lista på tillgängliga kommandon skriv 'hjälp'");

		while (!command.equals("avsluta")) {

			command = readString(">").toLowerCase();
			switch (command) {
			case "ny person":
				addPerson();
				break;
			case "ny sak":
				addProperty();
				break;
			case "visa alla":
				printAll();
				break;
			case "visa rikaste":
				printRichest();
				break;
			case "visa person":
				printPerson();
				break;
			case "börskrasch":
				stockCrash();
				break;
			case "avsluta":
				System.out.println("På återseende!");
				break;
			case "hjälp":
				System.out
						.println("Tillgängliga kommandon \n\nny person\nny sak\nvisa alla\nvisa rikaste\nvisa person\nbörskrasch\navsluta\n");
				break;
			default:
				System.out
						.println("Felaktigt kommando, skriv 'Hjälp' för en lista på tillgängliga kommandon");
				;
				break;
			}
		}
	}

	private static void printAll() {

		if (!persons.isEmpty()) {
			System.out.println("Dessa personer finns i registret:");
			for (Person p : persons) {
				System.out.println(p);
			}
		} else {
			System.out.println("Registret är tomt");
		}
	}

	private static void addPerson() {
		String name = capitalize(readString("Namn: "));
		Person newPerson = getPerson(name);
		if (newPerson != null) {
			System.out.println("Person med det namnet finns redan i registret");
		} else {
			persons.add(new Person(name));
		}

	}

	private static void addProperty() {

		String name = readString("Vem äger prylen: ");
		Person owner = getPerson(name);
		if (owner != null) {

			String kindOfProperty = new String();
			do {
				kindOfProperty = readString(
						"Vilken sorts ägodel (Smycke/Aktie/Apparat eller välj avbryt: ")
						.toLowerCase();

				switch (kindOfProperty) {

				case "smycke":
					addJewelry(name);
					kindOfProperty = "Avbryt";
					break;
				case "aktie":
					addStock(name);
					kindOfProperty = "Avbryt";
					break;
				case "apparat":
					addMachine(name);
					kindOfProperty = "Avbryt";
					break;
				case "avbryt":
					break;
				default:
					System.out.println("Felaktigt val");
					break;
				}
			} while (!kindOfProperty.equalsIgnoreCase("Avbryt"));
		} else {
			System.out.println("Person med det namnet finns ej i registret!");
		}
	}

	private static void addJewelry(String name) {

		String typeOfJewelry = capitalize(readString("Vilken typ av smycke: "));

		int metal = -1;

		do {
			String answer = readString("Guld eller silver: ");
			if (answer.equalsIgnoreCase("Guld")) {
				metal = 0;
			} else if (answer.equalsIgnoreCase("Silver")) {
				metal = 1;
			} else {
				System.out.println("Felaktigt svar:");
			}
		} while (metal < 0);

		int gems = readInt("Hur många ädelstenar: ");

		getPerson(name).addProperty(new Jewelry(typeOfJewelry, metal, gems));
	}

	private static void addMachine(String name) {

		String type = capitalize(readString("Vilken sorts apparat: "));

		int condition = readInt("Skick på apparaten(1-10): ");

		int purchasePrice = readInt("Inköpspris: ");

		getPerson(name)
				.addProperty(new Machine(type, condition, purchasePrice));
	}

	private static void addStock(String name) {

		String nameOfCompany = capitalize(readString("Vilket företag: "));
		int noOfPosts = readInt("Hur många poster: ");
		int price = readInt("Pris per post: ");
		getPerson(name).addProperty(new Stock(nameOfCompany, noOfPosts, price));
	}

	private static void printPerson() {

		String name = readString("Vilken person: ");
		Person p = getPerson(name);
		if (p != null) {
			System.out.println(p);
			p.printProperty();
		} else {
			System.out
					.println("Kunde inte hitta person med det namnet i registret");
		}
	}

	private static void printRichest() {

		int sumOfRichest = 0;
		String nameOfRichest = null;

		for (Person p : persons) {
			if (p.sumOfProperty() > sumOfRichest) {
				sumOfRichest = p.sumOfProperty();
				nameOfRichest = p.getName();
			}
		}

		if (nameOfRichest != null) {
			System.out.println(nameOfRichest
					+ " är rikast med ett totalt värde av " + sumOfRichest);
			getPerson(nameOfRichest).printProperty();
		} else {
			System.out
					.println("Finns inga personer i registret som innehar några värdesaker");
		}
	}

	private static Person getPerson(String name) {
		for (Person p : persons) {
			if (p.getName().equalsIgnoreCase(name)) {
				return p;
			}
		}
		return null;
	}

	private static void stockCrash() {
		for (Person p : persons) {
			p.stockCrash();
		}
	}

	private static int readInt(String question) {
		for (;;) {
			try {
				System.out.print(question);
				int a = Integer.parseInt(sc.nextLine());
				return a;
			} catch (NumberFormatException e) {
				System.out.println("Fel - ange ett numeriskt värde");
			}
		}
	}

	private static String readString(String question) {
		System.out.print(question);
		String str = sc.nextLine();
		return str;

	}

	private static String capitalize(String str) {
		for (;;) {
			try {
				String capitalizedString = str.substring(0, 1).toUpperCase()
						+ str.substring(1).toLowerCase();
				return capitalizedString;
			} catch (StringIndexOutOfBoundsException e) {
				System.out.println("Namnet måste innehålla minst ett tecken");
			}
		}
	}
}
