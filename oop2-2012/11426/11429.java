import java.util.ArrayList;
import java.util.Scanner;

public class MainProgram {

	private static Scanner keyboard = new Scanner(System.in);
	private static ArrayList<Person> allPersons = new ArrayList<Person>();

	/* Main block */
	public static void main(String[] args) {

		for (;;) {
			String typeOfAction = readString("What do you want to do?\n1 - Create person\n2 - Create valuable\n3 - Display all persons and their total values\n4 - Display richest person\n5 - Display person and all his/her valuables\n6 - Create stock market crash\n7 - Quit");

			switch (typeOfAction) {
			case "1" /* Create person */:
				createPerson();
				break;
			case "2" /* Create valuable */:
				createValuable();
				break;
			case "3" /* Display persons and their total values */:
				displayAll();
				break;
			case "4"/* Display richest person */:
				displayRichest();
				break;
			case "5"/* Display person and all his/her valuables */:
				displayPerson();
				break;
			case "6" /* Create stock market crash */:
				createStockMarketCrash();
				break;
			case "7" /* Quit */:
				System.out.println("Thank you and goodbye!");
				System.exit(0);
			default:
				System.out.println("Incorrect command, try again.");
			}// switch
		}// for
	}// main

	/* Method for input checks */
	private static int readInt(String question) {
		for (;;) {
			try {
				System.out.println(question);
				int x = Integer.parseInt(keyboard.nextLine());
				return x;
			}// try
			catch (NumberFormatException e) {
				System.out.println("Incorrect input, must be a numeric value.");
			}// catch
		}// for
	}// readInt

	/* Method for input checks */
	private static double readDouble(String question) {
		for (;;) {
			try {
				System.out.println(question);
				double x = Double.parseDouble(keyboard.nextLine());
				return x;
			}// try
			catch (NumberFormatException e) {
				System.out.println("Incorrect input, must be a numeric value.");
			}// catch
		}// for
	}// readDouble

	/* Method for input checks */
	private static String readString(String question) {
		System.out.println(question);
		String str = keyboard.nextLine();
		return str;
	}

	private static Person getPerson(String name) {
		for (Person p : allPersons) {
			if (p.getName().equalsIgnoreCase(name)) {
				return p;
			}// if
		}// for
		return null;
	}

	private static void createPerson() {
		String name = readString("Enter name of person: ");
		Person p = getPerson(name);
		if (p != null) {
			System.out.println("This person already exists.");
		} else {
			Person newPerson = new Person(name);
			allPersons.add(newPerson);
		}
		// System.out.println(newPerson);
	}

	private static void createValuable() {

		String name = readString("Who will own the valuable you create? ");
		Person p = getPerson(name);
		if (p == null) {
			System.out.println("This person does not exist.");
		} else {
			outerloop: for (;;) {
				String typeOfValuable = readString("What do you want to add?\n1 - Jewelry\n2 - Stock\n3 - Appliance\n4 - Exit to main menu");

				switch (typeOfValuable) {
				case "1" /* Jewelry */:
					createJewelry(p);
					break;
				case "2" /* Stock */:
					createStock(p);
					break;
				case "3" /* Appliance */:
					createAppliance(p);
					break;
				case "4" /* Exit to main menu */:
					break;
				default:
					System.out.println("Incorrect command, try again.");
				}// switch
				break outerloop;
			}// for
		}// else
	}// createValuable

	private static void createJewelry(Person p) {

		String typeOfValuable = "Jewelry";
		String material = null;

		String name = readString("What kind of jewelry is it? (eg. ring, necklace)");

		boolean correctMaterial = false;
		while (correctMaterial == false) {
			material = readString("Is the material gold or silver?");
			if (material.equalsIgnoreCase("gold")
					|| material.equalsIgnoreCase("silver")) {
				correctMaterial = true;
			} else {
				correctMaterial = false;
			}// else
		}// while

		int noOfStones = readInt("Enter number of stones: ");

		Jewelry j = new Jewelry(typeOfValuable, name, noOfStones, material);
		p.addValuable(j);
		System.out.println(name + " created succesfully. ");
		System.out.println();

	}// createJewelry

	private static void createStock(Person p) {
		String typeOfValuable = "Stock";

		String name = readString("What is the name of the stock?");

		int quantity = readInt("How many " + name
				+ " stock(s) have you purchased?");

		double pricePerQuantity = readDouble("What was the price per " + name
				+ " stock?");

		Stock s = new Stock(typeOfValuable, name, quantity, pricePerQuantity);
		// System.out.print(s);
		p.addValuable(s);
		System.out.println(name + " created succesfully. ");
		System.out.println();
	}// createStock

	private static void createAppliance(Person p) {
		String typeOfValuable = "Appliance";

		String name = readString("What kind of appliance is it? (eg TV, radio)");

		double purchasePrice = readDouble("What was the purchase price of the "
				+ name + " ?");

		int wear = readInt("On a scale where 1 = Very bad condition and 10 = Like new, what is the condition of the appliance?");

		Appliance a = new Appliance(typeOfValuable, name, purchasePrice, wear);
		p.addValuable(a);
		System.out.println(name + " created succesfully. ");
		System.out.println();
	}// createAppliance

	private static void displayAll() {
		System.out.println("These are the persons in the register:");
		for (Person p : allPersons) {
			System.out.println(p.getName() + "\t" + p.getTotalValue());
		}
	}

	private static void displayRichest() {


		if (allPersons.isEmpty()) {
			System.out.println("No persons exist in the register.");
		} else {
			Person richestPerson = allPersons.get(0);
			for (Person p : allPersons) {
				double personsValue = p.getTotalValue();
				if (personsValue > richestPerson.getTotalValue()) {
					richestPerson = p;
				}// if
			}// for
			System.out.println("The richest person in the register is "
					+ richestPerson.getName() + " who owns valubles for "
					+ richestPerson.getTotalValue() + " SEK.");
			System.out.println(richestPerson.getValuableInfo());
		}// else
	}

	private static void displayPerson() {
		Person p;
		do {
			String name = readString("Which person do you want to display?");
			p = getPerson(name);
			if (p == null) {
				System.out.println("This person does not exist.");
			}// if
		}// do
		while (p == null);
		System.out.println(p.getName() + " owns the following valuables.\n"
				+ p.getValuableInfo());
		System.out.println();
	}// displayPerson

	private static void createStockMarketCrash() {

		for (Person p : allPersons) {
			p.stockMarketCrash();
		}
		System.out.println("All current stocks are now worthless.");
	}

}// class
