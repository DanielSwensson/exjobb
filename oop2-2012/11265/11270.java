import java.util.*;

public class prylregister {

	static Scanner scan = new Scanner(System.in);
	static ArrayList<person> personList = new ArrayList<person>();
//	main metod
	public static void main(String[] args) {
		System.out.println("Välkommen till Prylregisterprogrammet!");

		while (true) {
			System.out.println("Vad vill du utföra? ");
			System.out.println("1. Registrera Person ");
			System.out.println("2. Registrera Pryl ");
			System.out.println("3. Visa alla ");
			System.out.println("4. Visa rikaste ");
			System.out.println("5. Visa en person ");
			System.out.println("6. Börskrasch ");
			System.out.println("7. Avsluta");
			System.out.println("Välj nummer efter passande ändamål ");
			int x = scan.nextInt();
			scan.nextLine();

			switch (x) {
			case 1:
				registerPerson();
				break;
			case 2:
				registerPryl();
				break;
			case 3:
				showAll();
				break;
			case 4:
				showWelthiest();
				break;
			case 5:
				showPerson();
				break;
			case 6:
				stockCrash();
				break;
			case 7:
				exitProgram();
				break;
			default:
				System.out.println("");
				System.out.println("Operationen du valt finns inte: ");
				System.out.println("");
			}
		}

	}
//	hjälpmetoder
	public static person getPersonByName(String s) {
		for (person p : personList) {
			if (p.getName().equalsIgnoreCase(s)) {
				return p;
			}

		}
		return null;
	}

	public static boolean existingPerson(String s) {
		return getPersonByName(s) != null;
	}
//	huvudmetoder
	public static void registerPerson() {
		System.out.println("Personens namn: ");
		String person = scan.nextLine();
		Boolean add = existingPerson(person);

		if (!add) {
			person temp = new person(person);
			personList.add(temp);
		} else if (add) {
			System.out.println("Den här personen finns redan registrerad!");
		}
	}

	public static void registerPryl() {
		System.out.println("Vilken person äger prylen: ");
		String owner = scan.nextLine();
		person p = getPersonByName(owner);

		if (p != null) {
			System.out.println("Vilken typ av pryl: ");
			String typ = scan.nextLine();

			if (typ.equalsIgnoreCase("Smycke")) {
				System.out.println("Vilken sorts smycke: ");
				String type = scan.nextLine();
				System.out.println("Är smycket av guld? ");
				String gold = scan.nextLine();
				System.out.println("Antal ädelstenar: ");
				int stone = scan.nextInt();

				if (gold.equalsIgnoreCase("ja")) {
					Smycke s = new Smycke(type, true, stone);
					p.addPryl(s);
				} else {
					Smycke s = new Smycke(type, false, stone);
					p.addPryl(s);
				}

			} else if (typ.equalsIgnoreCase("Aktie")) {
				System.out.println("Aktiens namn: ");
				String name = scan.nextLine();
				System.out.println("Pris på aktien: ");
				int price = scan.nextInt();
				System.out.println("Antal aktier: ");
				int numberOf = scan.nextInt();

				Aktie a = new Aktie(name, price, numberOf);
				p.addPryl(a);
			} else if (typ.equalsIgnoreCase("Apparat")) {
				System.out.println("Vilken typ av apparat: ");
				String apparatus = scan.nextLine();
				System.out.println("Pris på apparaten: ");
				double aPrice = scan.nextInt();
				System.out.println("Slitage(10-1)");
				double damage = scan.nextInt();

				Apparat ap = new Apparat(apparatus, aPrice, damage);
				p.addPryl(ap);
			} else {
				System.out
						.println("Denna typ av pryl går inte att registrera!");
			}
		} else {
			System.out.println("Den här personen finns inte i registret");
		}
	}

	public static void showAll() {

		int index = 0;
		while (index < personList.size()) {
			System.out.println(personList.get(index));
			index++;
		}
	}

	public static void showWelthiest() {

		person richest = personList.get(0);
		for (person x : personList) {
			if (x.getTotalValue() > richest.getTotalValue()) {
				richest = x;
			}
		}
		System.out.println("Rikast är " + richest + "\n");
		richest.getBelongings();

	}

	public static void showPerson() {

		System.out.println("Vilken person vill du se: ");
		String person = scan.nextLine();
		for (person i : personList) {
			if (i.getName().equals(person)) {
				System.out.println(i + "\n");
				i.getBelongings();
			} else if (!i.getName().equals(person)) {
				System.out.println("Personen finns inte i registret");
			}
		}
	}

	public static void stockCrash() {
		for (person p : personList) {
			p.stockCrash();
		}
		System.out.println("Börskrasch!");
	}

	public static void exitProgram() {
		System.out.println("Avslutat!");
		System.exit(0);
	}
}
