import java.util.Scanner;
import java.util.ArrayList;

public class ValuesOfPerson {

	ArrayList<Person> everyPerson = new ArrayList<Person>();
	Scanner keyboard = new Scanner(System.in);

	public int readInt(String question) {
		for (;;) {
			try {
				System.out.print(question);
				int i = Integer.parseInt(keyboard.nextLine());
				return i;
			} catch (NumberFormatException e) {
				System.out.println("Felaktig inmatning, ange en siffra!");
			}
		}
	}

	public String readString(String question) {
		System.out.print(question);
		String s = keyboard.nextLine();
		return s;
	}

	public Person getPerson(String personName) {
		for (Person p : everyPerson)
			if (p.getPersonName().equalsIgnoreCase(personName))
				return p;
		return null;
	}

	public void createPerson() {
		String personName = readString("Namn: ");
		Person p = getPerson(personName);
		if (p != null)
			System.out.println("Personen finns redan i registret.");
		else {
			Person P = new Person(personName);
			everyPerson.add(P);

			System.out.println("Registrerad!");
		}
	}

	public void createValuable() {
		String owner = readString("Person:");
		Person p = getPerson(owner);

		if (p != null) {
			String commando = readString("Vill du registrera smycke, aktie eller apparat? : ");
			switch (commando) {
			case "smycke":
				createJewelery(p);
				break;
			case "aktie":
				createShareholding(p);
				break;
			case "apparat":
				createDevice(p);
				break;
			default:
				System.out.println("Felaktigt. Prylen ska anges som smycke/aktie/apparat.");
				System.out.println("Ange ett kommando!");
			}
		} else {
			System.out.println("Personen kan ej hittas :( ");
		}
	}

	public void createJewelery(Person p) {
		String name = readString("Vilket slags smycke? :");
		String metal = readString("Är smycket guld eller silver? :");
		int jewels = readInt("Antal ädelstenar: ");
		Valuable v = new Jewelery(name, metal, jewels);
		p.valuableToPerson(v);
	}

	public void createShareholding(Person p) {
		String name = readString("Namn på aktien: ");
		int amount = readInt("Antal:");
		int price = readInt("Aktiepris:");
		Valuable v = new Shareholding(name, amount, price);
		p.valuableToPerson(v);
	}

	public void createDevice(Person p) {
		String name = readString("Vilken slags apparat?: ");
		int wear = readInt("Slitage, 1-10 (10= nyskick): ");
		
		if (0<wear && wear<11) {
			int purchasePrice = readInt("Inköpspris: ");
			Valuable v = new Device(name, wear, purchasePrice);
			p.valuableToPerson(v);
		
		} else {
			System.out.println("Felaktigt slitagevärde, prylen är ej registrerad.");
			System.out.println("Ange ett kommando!");
		}
	}
	

	public void showAllPersons() {
		System.out.println("I registret hittas: ");
		System.out.println();
		for (Person p : everyPerson) {
			System.out.println(p.toString());
		}
	}

	public void showPerson() {
		String owner = readString("Vilken person vill du se?: ");
		Person p = getPerson(owner);

		if (p != null) {
			System.out.println(p.toString());
			p.showAllValuables();
		} else {
			System.out.println("Personen kan ej hittas.");
		}
	}

	public void showRichest() {
		System.out.print("Rikast: ");

		Person rich = null;

		for (Person p : everyPerson) {
			if (rich == null || rich.totalValue() < p.totalValue())
				rich = p;
		}

		if (rich != null) {
			System.out.println(rich.toString());
			rich.showAllValuables();
		} else {
			System.out.println(" ingen, registret är tomt!");
		}
	}

	public void stockMarketCrash() {

		for (Person p : everyPerson) {
			p.shareholdingToZero();
		}
		System.out.println("Börskrasch! :( ");
	}

	public static void main(String[] args) {	

		ValuesOfPerson vop = new ValuesOfPerson();

		System.out
				.println("Hjärtligt välkommen till ett rent fantastiskt prylregister!");
		System.out.println();
		System.out.println("1 : Registrera person");
		System.out.println("2 : Lägg till pryl");
		System.out
				.println("3 : Lista alla personer och värdet av deras prylar");
		System.out.println("4 : Visa person och dennes prylar");
		System.out.println("5 : Visa rikaste person och dennes prylar");
		System.out.println("6 : Börskrasch");
		System.out.println("7 : Avsluta programmet");
		System.out.println();
		System.out.println("  Ange ett av ovanstående kommandon, är du gullig! ");

		for (;;) {
			int commando = vop.readInt(">");
			switch (commando) {
			case 1:
				vop.createPerson();
				break;
			case 2:
				vop.createValuable();
				break;
			case 3:
				vop.showAllPersons();
				break;
			case 4:
				vop.showPerson();
				break;
			case 5:
				vop.showRichest();
				break;
			case 6:
				vop.stockMarketCrash();
				break;
			case 7:
				System.out.println("Hasta la vista, baby!");
				System.exit(0);
			default:
				System.out.println("Felaktigt kommando");
			}

		}
	}

}