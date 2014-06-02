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
					"4) Visa vem som �r rikast\n" + 
					"5) Lista alla personer\n" + 
					"6) B�rskrasch\n" + 
					"7) Avsluta\n");

			int options = mb.readInt("V�lj ett alternativ: ");
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
		String name = readString("Vilken person �ger prylen: ");
		Person p = getPerson(name);

		if (p == null)
			System.out.println("Tyv�rr finns inte den personen.\n");
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
			System.out.print(name + "'s prylar �r v�rda " + p.getTotalValue() + " kronor.\n" + p.showPrylar());
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
			System.out.print(richest.toString() + " �r rikast med en f�rm�genhet p�: " + richest.getTotalValue());
			System.out.println();
			System.out.print(richest.showPrylar());
			System.out.println();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Tyv�rr finns inga personer.\n");
		}
	}
	
	public void showAll() {
		try {
			for (Person p : personer)
				System.out.print(p.toString() + " �ger prylar f�r " + p.getTotalValue() + " kronor.\n");
			System.out.println();

		} catch (NullPointerException e) {
			System.out.println("Tyv�rr finns inga personer.\n");
		}
	}

	public void marketCrash() {
		for (Person p : personer) {
			for (Pryl pr : p.getPrylar()) {
				if (pr instanceof Aktie) {
					System.out.println("Alla nuvarade aktier �r v�rdel�sa\n");
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
		// fixa s� att man inte kan skriva text utan bara siffror p� antal aktier
		share.addPryl(new Aktie(name, price, amount));
		System.out.println();
	}

	void createDevice(Person device) {
		String name = readString("Vilken sorts apparat? ");
		int price = readInt("Vad kostade den? ");
		int abrasion = readInt("Hur sliten �r den (1 - 10)? ");
		device.addPryl(new Apparat(name, price, abrasion));
		System.out.println();
	}

	void createJewelery(Person jewe) {
		String name = readString("Vilket sorts smycke? ");
		int amount = readInt("Hur m�nga �delstenar? ");
		String material;
		for (;;) {
			material = readString("�r smycket av guld?: ");
			if (material.equalsIgnoreCase("ja") || material.equalsIgnoreCase("nej")) {
				break;
			} else
				System.out.print("Svara med Ja eller Nej.\n");
		}
		jewe.addPryl(new Smycke(name, amount, material));
		System.out.println();
	}


	/* ---------- Assisting methods ---------- */
	// metoder f�r att "spara kodrader", man slipper t.ex. skriva raderna:
	// System.out.print("enFr�ga"); _och sen_ String attrubut = keyboard.nextLine();
	// utan kan ist�llet skriva: String attribut = readString("enFr�ga");

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
				System.out.println("Fel, f�rs�k igen (1 - 7).");
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