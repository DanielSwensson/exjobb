import java.util.*;

public class Register {

	ArrayList<Person> allPeople = new ArrayList<Person>();
	Scanner scan = new Scanner(System.in);

	// metod för korrekt inläsning av intar
	int readInt(String question) {
		while (true) {
			try {
				System.out.println(question);
				int x = Integer.parseInt(scan.nextLine());
				return x;
			}

			catch (NumberFormatException e) {
				System.out.println("Fel - ska vara av numeriskt värde");
			}

		}
	}

	// metod för korrekt inläsning av strängar
	String readString(String question) {
		System.out.println(question);
		String str = scan.nextLine();
		return str;
	}

	// metod för att hitta en person identifierad med namnet
	Person getPerson(String name) {
		for (Person p : allPeople)
			if (p.getName().equalsIgnoreCase(name))
				return p;
		return null;
	}

	// metod för att registrera person
	void registerPerson() {
		String name = readString("Personens namn:");
		Person p = getPerson(name);
		if (p != null) {
			System.out.println("Den personen finns redan registrerad");
		} else {
			Person newPerson = new Person(name);
			allPeople.add(newPerson);
			System.out.println(name + " har registrerats.");
		}
	}

	// metod för att skapa ny pryl
	void registerItem() {
		String whichOwner = readString("Ägare: ");
		boolean found = false;
		Person p = null;

		for (int i = 0; i < allPeople.size(); i++) {
			if (allPeople.get(i).getName().equalsIgnoreCase(whichOwner)) {
				found = true;
				p = allPeople.get(i);
			}
		}

		if (!found) {
			System.out.println(whichOwner
					+ " finns inte registrerad sen tidigare");
		}

		if (found) {

			String itemType = readString("Vilken sorts pryl (Smycke, aktie eller apparat): ");

			if (itemType.equalsIgnoreCase("smycke")) {
				String itemName = readString("Vilken typ av smycke: ");
				String goldTrue = readString("Är smycket av guld(Ja eller Nej): ");

				boolean gold = false;
				if (goldTrue.equalsIgnoreCase("ja")) {
					gold = true;

					if (goldTrue.equalsIgnoreCase("nej")) {
						gold = false;

					}

				}
				int stoneAmount = readInt("Antal ädelstenar: ");
				Jewelery newJewelery = new Jewelery(itemName, stoneAmount, gold);
				p.addBelongings(newJewelery);

			} else if (itemType.equalsIgnoreCase("aktie")) {
				String itemName = readString("Aktienamn: ");
				int stockPrice = readInt("Pris: ");
				int stockAmount = readInt("Antal: ");
				Stock newStock = new Stock(itemName, stockAmount, stockPrice);
				p.addBelongings(newStock);
			} else if (itemType.equalsIgnoreCase("apparat")) {
				String itemName = readString("Vilken typ av apparat: ");
				int purchasePrice = readInt("Inköpspris: ");
				int condition = readInt("Slitage(1-10): ");
				Gadget newGadget = new Gadget(itemName, purchasePrice,
						condition);
				p.addBelongings(newGadget);
			} else {
				System.out.println("Denna typ av pryl finns inte");

			}
		}
	}

	// lista alla
	void listingAll() {
		for (int i = 0; i < allPeople.size(); i++) {
			System.out.println(allPeople.get(i).getName() + " "
					+ allPeople.get(i).getWorth());

		}
	}

	// visa rikaste
	void showTheRichest() {
		Person richest = null;
		if (!allPeople.isEmpty()) {
			richest = allPeople.get(0);
		}
		for (int i = 0; i < allPeople.size(); i++) {
			allPeople.get(i).getWorth();
			if (allPeople.get(i).getWorth() > richest.getWorth())
				richest = allPeople.get(i);

		}
		System.out.print(richest.getName() + " är rikast och äger \n"
				+ richest.listAllBelongings());
	}

	// lista viss person
	void showCertainPerson() {
		String findPerson = readString("Vem vill du visa?: ");
		boolean found = false;
		for (int x = 0; x < allPeople.size(); x++)

			if (allPeople.get(x).getName().equals(findPerson)) {
				found = true;
				System.out.println(allPeople.get(x).getName() + "\n "
						+ allPeople.get(x).listAllBelongings() + "\n");
			}

		if (found == false) {
			System.out.println(findPerson + " finns inte");
			found = false;

		}
	}

	// Skapa börskrasch
	void stockMarketCrash() {
		for (int i = 0; i < allPeople.size(); i++) {
			allPeople.get(i).getStockMarketCrash();
		}
		System.out.println("Alla aktier på marknaden har kraschat.");
	}

	// Avsluta programmet
	void exitProgram() {
		System.out.println("Programmet är nu avslutat.");
		System.exit(0);
	}

	// Main metoden
	public static void main(String[] args) {

		Register r = new Register();

		while (true) {
			int choice = r
					.readInt("Välj en siffra mellan 1-7: \n 1. Registrera person \n "
							+ "2. Skapa pryl \n 3. Lista alla \n 4. Visa rikaste personen \n "
							+ "5. Visa viss person \n 6. Börskrasch \n 7. Stäng programmet ");
			switch (choice) {
			case 1:
				r.registerPerson();
				break;

			case 2:
				r.registerItem();
				break;

			case 3:
				r.listingAll();
				break;

			case 4:
				r.showTheRichest();
				break;

			case 5:
				r.showCertainPerson();
				break;

			case 6:
				r.stockMarketCrash();
				break;

			case 7:
				r.exitProgram();

			default:
				System.out.println("Du har angivit fel kommando.");
			}
		}

	}
}