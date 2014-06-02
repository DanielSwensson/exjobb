package inlupp2;

import java.util.*;

public class MainBank {

	/* ----------- Field & Attributes----------- */
	ArrayList<Person> personer = new ArrayList<Person>();
	Scanner keyboard = new Scanner(System.in);

	/* ---------- Main method ---------- */
	public static void main(String[] args) {
		MainBank mb = new MainBank();		

		for (;;) {
			System.out.print("1) Skapa en person \n" + 
					"2) Skapa en pryl\n" + 
					"3) Lista specifik person\n" + 
					"4) Visa vem som är rikast\n" + 
					"5) Lista alla personer\n" + 
					"6) Börskrasch\n" + 
					"7) Avsluta\n");

			int options = mb.readInt("Välj ett alternativ: ");
			switch (options) {
			case 1:
				mb.createPerson(); break;
			case 2:
				mb.createThing(); break;
			case 3:
				mb.showPerson(); break;
			case 4:
				mb.showRichest(); break;
			case 5:
				mb.showAll(); break;
			case 6:
				mb.marketCrash(); break;
			case 7: 
				System.exit(0);
			default:
				break;
			}
		}
	}

	
	/* ---------- Methods to the switch ---------- */
	public void createPerson() {
		String name = readString("Personens namn: ");

		boolean duplicatePerson = false;
		for (Person p : personer)
			if (name.equalsIgnoreCase(p.getName()))
				duplicatePerson = true;
		{
			if (duplicatePerson) {
				System.out.println("Den personen finns redan.\n");
			} else {
				Person newPerson = new Person(name);
				personer.add(newPerson);
				System.out.print("Personen " + name + " skapades.\n");
				System.out.println();
			}
		}
	}

	public void createThing() {
		String name = readString("Vilken person äger prylen: ");
		Person p = getPerson(name);

		if (p == null)
			System.out.println("Tyvärr finns inte den personen.\n");
		else {
			String prylType;
			for (;;) {
				prylType = readString("Vilken typ av pryl? (Aktie, Apparat eller Smycke) ");
				if (prylType.equalsIgnoreCase("aktie") || prylType.equalsIgnoreCase("apparat") || prylType.equalsIgnoreCase("smycke"))
					break;
				else
					System.out.print("Fel, svara med Aktie, Apparat eller Smycke\n");
			}
			if (prylType.equalsIgnoreCase("Aktie")) {
				createShare(p);
			} else if (prylType.equalsIgnoreCase("Apparat")) {
				createDevice(p);
			} else if (prylType.equalsIgnoreCase("Smycke")) {
				createJewelery(p);
			}
		}
	}

	public void showPerson() {
		String name = readString("Personens namn: ");
		Person p = getPerson(name);
		if (p != null) {
			System.out.print(name + "'s prylar är värda " + p.getTotalValue() + " kronor.\n" + p.showPrylar());
			System.out.println();
		} else
			System.out.println("Den personen finns inte\n");
	}
	
	public void showRichest() {
		try {
			Person richest = personer.get(0);
			for (Person p : personer) {
				if (p.getTotalValue() > richest.getTotalValue()) {
					richest = p;
				}
			}
			System.out.print(richest.toString() + " är rikast med en förmögenhet på: " + richest.getTotalValue());
			System.out.println();
			System.out.print(richest.showPrylar());
			System.out.println();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Tyvärr finns inga personer.\n");
		}
	}
	
	public void showAll() {
		try {
			for (Person p : personer)
				System.out.print(p.toString() + " äger prylar för " + p.getTotalValue() + " kronor.\n");
			System.out.println();

		} catch (NullPointerException e) {
			System.out.println("Tyvärr finns inga personer.\n");
		}
	}

	public void marketCrash() {
		for (Person p : personer) {
			for (Pryl pr : p.getPrylar()) {
				if (pr instanceof Aktie) {
					System.out.println("Alla nuvarade aktier är värdelösa\n");
					((Aktie) pr).marketCrash();
				}
			}
		}
	}

	

	/* ---------- Methods for createing things ---------- */
	void createShare(Person share) {
		String name = readString("Vilken aktie? ");
		int price = readInt("Vad kostade den per styck? ");
		int amount = readInt("Antal aktier: ");
		// fixa så att man inte kan skriva text utan bara siffror på antal aktier
		share.addPryl(new Aktie(name, price, amount));
		System.out.println();
	}

	void createDevice(Person device) {
		String name = readString("Vilken sorts apparat? ");
		int price = readInt("Vad kostade den? ");
		int abrasion = readInt("Hur sliten är den (1 - 10)? ");
		device.addPryl(new Apparat(name, price, abrasion));
		System.out.println();
	}

	void createJewelery(Person jewe) {
		String name = readString("Vilket sorts smycke? ");
		int amount = readInt("Hur många ädelstenar? ");
		String material;
		for (;;) {
			material = readString("Är smycket av guld?: ");
			if (material.equalsIgnoreCase("ja") || material.equalsIgnoreCase("nej")) {
				break;
			} else
				System.out.print("Svara med Ja eller Nej.\n");
		}
		jewe.addPryl(new Smycke(name, amount, material));
		System.out.println();
	}


	/* ---------- Assisting methods ---------- */
	// metoder för att "spara kodrader", man slipper t.ex. skriva raderna:
	// System.out.print("enFråga"); _och sen_ String attrubut = keyboard.nextLine();
	// utan kan istället skriva: String attribut = readString("enFråga");

	String readString(String question) {
		System.out.print(question);
		String str = keyboard.nextLine();
		return str;
	}

	int readInt(String question) {
		for (;;) {
			try {
				System.out.print(question);
				int value = Integer.parseInt(keyboard.nextLine());
				return value;
			} catch (NumberFormatException ex) {
				System.out.println("Fel, försök igen (1 - 7).");
			}
		}
	}

	Person getPerson(String name) { 
		if (personer.size() > 0) {
			for (Person p : personer) {
				if (p.getName().equalsIgnoreCase(name))
					return p;
			}
		}
		return null;
	}

}