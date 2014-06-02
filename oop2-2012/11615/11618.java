package valuables;

import java.util.InputMismatchException;
import java.util.Scanner;

import valuables.Jewelry.Material;

public class Main {

	private static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {
		Register register = new Register();

		Integer option = -1;
		while (true) {
			printMenu();
			option = readInt("");
			try {
				switch (option) {
				case 1:
					addPerson(register);
					break;
				case 2:
					addValuable(register);
					break;
				case 3:
					showAll(register);
					break;
				case 4:
					showRichestPerson(register);
					break;
				case 5:
					showPerson(register);
					break;
				case 6:
					stockMarketCrash(register);
					break;
				case 7:
					System.exit(0);
				default:
					System.out
							.println("Felaktigt värde! Välj ett alternativ mellan 1-7:");
					break;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private static void showPerson(Register r) throws Exception {
		String name = readLine("Ange personens namn:");
		Person p = r.findPerson(name);
		showPersonValuables(p);
	}

	private static void showPersonValuables(Person p) {
		System.out.println(p.getName()
				+ " har följande värdesaker registrerade:");
		for (Valuable v : p.getValuables()) {
			System.out.println(v.getName() + "   " + v.getValue());
			System.out.println();
		}
	}

	private static void addValuable(Register r) throws Exception {
		String name = readLine("Ange personens namn:");
		Person person = r.findPerson(name);

		Valuable v = null;
		int type = readInt("Ange typ: \n 1. Smycke \n 2. Apparat \n 3. Aktie",
				1, 3);
		switch (type) {
		case 1:
			v = addJewelry();
			break;
		case 2:
			v = addAppliance();
			break;
		case 3:
			v = addStock();
			break;
		default:

		}

		if (v != null) {
			person.addValuable(v);
		}
	}

	private static Jewelry addJewelry() {
		String name = readLine("Vilken sorts smycke:");
		boolean sort = readBoolean("Är smycket av guld?(Ja/Nej)");

		int gems = readInt("Hur många ädelstenar har smycket?", 1,
				Integer.MAX_VALUE);

		Jewelry jewel = new Jewelry(name, gems, sort ? Material.GOLD
				: Material.SILVER);
		return jewel;
	}

	private static Stock addStock() {
		String name = readLine("Ange aktiens namn:");
		int price = readInt("Ange pris:", 1, Integer.MAX_VALUE);
		int quantity = readInt("Ange orderantal:", 1, Integer.MAX_VALUE);
		Stock stock = new Stock(name, price, quantity);
		return stock;
	}

	private static Appliance addAppliance() throws Exception {
		String name = readLine("Vilken sorts apparat:");

		int condition = readInt("Ange slitage (1-10):", 1, 10);
		int price = readInt("Ange inköpspris:", 1, Integer.MAX_VALUE);
		Appliance app = new Appliance(name, condition, price);
		return app;
	}

	private static void addPerson(Register r) throws Exception {
		String name = readLine("Ange personens namn");
		r.addPerson(name);
	}

	private static void showAll(Register r) {
		if (r.getAllPersons().size() == 0) {
			System.out.println("Det finns inga personer registrerade.");
		} else {
			System.out.println("Följande personer finns i registret:");
			for (Person p : r.getAllPersons()) {

				System.out.println(p.getName() + " " + p.getValue());
			}
		}
		System.out.println();
	}

	private static void showRichestPerson(Register r) {
		Person tmp = null;
		for (Person p : r.getAllPersons()) {
			if (tmp == null || p.getValue() > tmp.getValue()) {
				tmp = p;
			}
		}
		if (tmp == null) {
			System.out.println("Det finns inga personer registrerade.");
		} else {
			System.out.println("Rikast är " + tmp.getName()
					+ " som sammanlagt äger föremål till ett värde av "
					+ tmp.getValue() + " kr.");
			showPersonValuables(tmp);
		}
		System.out.println();
	}

	private static void stockMarketCrash(Register r) {
		r.setStockMarketCrash();
		System.out
				.println("En börskrasch har registrerats! Värdet på samtliga aktier har satts till 0.");
		System.out.println();
	}

	private static void printMenu() {
		System.out.println("1. Skapa person");
		System.out.println("2. Skapa värdesak");
		System.out.println("3. Visa alla");
		System.out.println("4. Visa rikaste person");
		System.out.println("5. Visa viss person");
		System.out.println("6. Börskrasch");
		System.out.println("7. Avsluta");
	}

	private static String readLine(String prompt) {
		System.out.println(prompt);
		String personName = keyboard.nextLine();
		return personName;
	}

	private static boolean readBoolean(String prompt) {
		String tmp = null;
		do {
			tmp = readLine(prompt);
			if (tmp.equalsIgnoreCase("ja")) {
				return true;
			}
			if (tmp.equalsIgnoreCase("nej")) {
				return false;
			}
		} while (!tmp.equalsIgnoreCase("ja") && !tmp.equalsIgnoreCase("nej"));
		return false;
	}

	private static Integer readInt(String prompt) {
		System.out.println(prompt);
		Integer number = null;
		try {
			number = keyboard.nextInt();
		} catch (InputMismatchException e) {
		}
		keyboard.nextLine();

		return number;
	}

	private static int readInt(String prompt, int min, int max) {
		Integer resp = null;
		do {
			resp = readInt(prompt);
			if (resp == null || resp < min || resp > max) {
				if (min == 1 && max == Integer.MAX_VALUE) {
					System.out
							.println("Ogiltigt värde, ange ett positivt heltal");
				} else {
					System.out.println("Ogiltigt värde, ange ett värde mellan "
							+ min + " och " + max);
				}
			}

		} while (resp == null || resp < min || resp > max);
		return resp;
	}
}
