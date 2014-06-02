import java.util.Scanner;

public class CommandLineInterface {
	private static Register r;
	private static Scanner keyboard;

	public static void main(String[] args) {
		r = new Register();
		keyboard = new Scanner(System.in);

		menu();
	}

	public static void menu() {

		while (true) {
			int selection = readInt(("1. Create person\n" + "2. Create item\n"
					+ "3. Show all persons \n" + "4. Show richest person \n"
					+ "5. Show certain person \n" + "6. Stock crash \n"
					+ "7. Quit\n"));

			switch (selection) {
			case 1:
				createPerson();
				break;
			case 2:
				createItem();
				break;
			case 3:
				showPersons();
				break;
			case 4:
				showRichest();
				break;
			case 5:
				showCertainPerson();
				break;
			case 6:
				startStockCrash();
				break;
			case 7:
				return;
			default:
				System.out.println("No such number, please try again!");
			}
		}
	}

	public static void startStockCrash() {
		r.affectByStockcrash();
		System.out.println("All stocks crashed!");
	}

	public static void createItem() {
		int selection = readInt(("1. Jewelery\n" + "2. Stock\n" + "3. Gadget\n"));

		switch (selection) {
		case 1:
			createJewlery();
			break;
		case 2:
			createStock();
			break;
		case 3:
			createGadget();
			break;
		}
	}

	public static String readString(String prompt) {
		System.out.print(prompt + ": ");
		return keyboard.nextLine();
	}

	public static int readInt(String prompt) {
		String s = readString(prompt);
		try {
			return Integer.parseInt(s);
		} catch (NumberFormatException ex) {
			System.out.println("Invalid integer");
			return readInt(prompt);
		}
	}

	public static void createJewlery() {
		String name = readString("Enter name");
		boolean isGold = readString("Is gold (Y/N)").equalsIgnoreCase("y");
		int stones = readInt("Enter the number of gemstones");

		Jewelry j = new Jewelry(name, isGold, stones);

		String personName = readString("Enter owner");

		Person p = r.findPerson(personName);

		if (p != null) {
			p.addItem(j);
		} else {
			System.out.println("That person does not exist!");
		}
	}

	public static void createStock() {
		String name = readString("Enter name of stock");
		int price = readInt("Enter price");
		int number = readInt("Enter number of shares");

		Stock s = new Stock(name, price, number);

		String personName = readString("Enter owner");

		Person p = r.findPerson(personName);

		if (p != null) {
			p.addItem(s);
		} else {
			System.out.println("That person does not exist!");
		}

	}

	public static void createGadget() {
		String name = readString("Enter name of item");
		int condition = readInt("Enter the condition of the item (1-10)");
		int price = readInt("Enter purchase price");

		Gadget g = new Gadget(name, condition, price);

		String personName = readString("Enter owner");

		Person p = r.findPerson(personName);

		if (p != null) {
			p.addItem(g);
		} else {
			System.out.println("That person does not exist!");
		}
	}

	public static void createPerson() {
		System.out.print("Enter name: ");
		String name = keyboard.nextLine();

		Person p = new Person(name);
		r.addPerson(p);

		System.out.println("Person created");
	}

	public static void showPersons() {
		for (Person p : r.getPersons()) {
			System.out.println(p);
		}
	}

	public static void showRichest() {
		Person richest = r.findRichest();

		if (richest != null) {
			System.out.println("The richest person is " + richest.getName());
			printPerson(richest);
		} else {
			System.out.println("Person not found!");
		}
	}

	public static void showCertainPerson() {
		System.out.print("Enter name: ");
		findPersonAndPrint(keyboard.nextLine());
	}

	public static void findPersonAndPrint(String name) {
		Person p = r.findPerson(name);
		if (p != null) {
			printPerson(p);
		} else {
			System.out.println("Person not found!");
		}
	}

	public static void printPerson(Person x) {
		System.out.println(x + "\n");
		for (Item z : x.getItems()) {
			System.out.println(z);
		}
	}
}
