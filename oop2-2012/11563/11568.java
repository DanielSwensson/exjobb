import java.util.ArrayList;
import java.util.Scanner;

public class Registry {

	private static Scanner sc = new Scanner(System.in);
	private static ArrayList<Person> persons = new ArrayList<Person>();

	public static void main(String[] args) {

		String command = new String();

		System.out
				.println("V�lkommen! F�r en lista p� tillg�ngliga kommandon skriv 'hj�lp'");

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
			case "b�rskrasch":
				stockCrash();
				break;
			case "avsluta":
				System.out.println("P� �terseende!");
				break;
			case "hj�lp":
				System.out
						.println("Tillg�ngliga kommandon \n\nny person\nny sak\nvisa alla\nvisa rikaste\nvisa person\nb�rskrasch\navsluta\n");
				break;
			default:
				System.out
						.println("Felaktigt kommando, skriv 'Hj�lp' f�r en lista p� tillg�ngliga kommandon");
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
			System.out.println("Registret �r tomt");
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

		String name = readString("Vem �ger prylen: ");
		Person owner = getPerson(name);
		if (owner != null) {

			String kindOfProperty = new String();
			do {
				kindOfProperty = readString(
						"Vilken sorts �godel (Smycke/Aktie/Apparat eller v�lj avbryt: ")
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

		int gems = readInt("Hur m�nga �delstenar: ");

		getPerson(name).addProperty(new Jewelry(typeOfJewelry, metal, gems));
	}

	private static void addMachine(String name) {

		String type = capitalize(readString("Vilken sorts apparat: "));

		int condition = readInt("Skick p� apparaten(1-10): ");

		int purchasePrice = readInt("Ink�pspris: ");

		getPerson(name)
				.addProperty(new Machine(type, condition, purchasePrice));
	}

	private static void addStock(String name) {

		String nameOfCompany = capitalize(readString("Vilket f�retag: "));
		int noOfPosts = readInt("Hur m�nga poster: ");
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
					+ " �r rikast med ett totalt v�rde av " + sumOfRichest);
			getPerson(nameOfRichest).printProperty();
		} else {
			System.out
					.println("Finns inga personer i registret som innehar n�gra v�rdesaker");
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
				System.out.println("Fel - ange ett numeriskt v�rde");
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
				System.out.println("Namnet m�ste inneh�lla minst ett tecken");
			}
		}
	}
}
