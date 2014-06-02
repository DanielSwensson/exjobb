import java.util.*;

public class Main {

	private static Scanner sc = new Scanner(System.in);

	public static void showAllPeople() {

		System.out.println("\n");

		for (Class_People p : Class_People.getList()) {
			System.out.println(p.getName() + " " + p.getTotalWealth());
		}

		System.out.println("\n");
	}

	public static void showPerson(int id) {

		if (id == -1) {
			System.out.print("\nEnter persons name: ");
			String name = sc.nextLine();
			id = Class_People.getPersonId(name);
		}

		if (id == -1) {
			System.out.println("\nNo such person in register\n");
		} else {

			System.out.println("\n" + Class_People.getPersonName(id) + " owns following items:");

			for (Class_Stuff o : Class_Stuff.getStuff())
				if (o.getOwnerId() == id) {
					System.out.println(o.getName() + " " + o.getValue());
				}

			System.out.println();
		}
	}

	public static void stockMarketCrash() {

		for (Class_Stuff o : Class_Stuff.getStuff())
			if (o.getClass().equals(Class_Stock.class))
				((Class_Stock) o).crashValue();

		System.out.print("\nThe market crashed. All stocks set to zero\n");
	}

	public static void showWealthiest() {

		int wealth = 0;
		Class_People wealthiestPerson = null;

		for (Class_People p : Class_People.getList()) {
			if (p.getTotalWealth() > wealth) {
				wealthiestPerson = p;
				wealth = p.getTotalWealth();
			}
		}

		if (wealthiestPerson == null) {
			System.out.println("\nThere are no wealthy persons in the register\n");
		} else {
			System.out.print("\nThe wealthiest person is " + wealthiestPerson.getName() + "\n");
			showPerson(wealthiestPerson.getId());
		}
	}

	public static void registerPerson() {

		String str;

		try {

			System.out.print("\nEnter persons name: ");
			str = sc.nextLine().trim();

			
			if (str.isEmpty()) {
				System.out.print("\nThe person must have a name!\n\n");
			} else
			if (Class_People.getPersonId(str) == -1) {
				Class_People.addPerson(str);
				System.out.print("\nPerson was added to the register\n\n");
			} else
				System.out.print("\nPerson already exists!\n\n");

		} catch (Exception e) {
			System.out.print("\n\nSyntax Error!\n\n");
		}

	}

	public static void registerJewelry(int ownerId) {

		String type;
		Class_Jewelry.enumMaterial material;
		int gems;

		try {
			System.out.print("Type of jewelry: ");
			type = sc.nextLine().trim();

			System.out.print("Gold or silver: ");
			material = Class_Jewelry.enumMaterial.valueOf(sc.nextLine().trim().toLowerCase());

			System.out.print("Amount of gems: ");
			gems = sc.nextInt();
			sc.nextLine();

			Class_Stuff.addStuff(new Class_Jewelry(ownerId, type, material, gems));
		} catch (Exception e) {
			System.out.print("\n\nSyntax Error!\n\n");
		}
	}

	public static void registerStock(int ownerId) {

		String name;
		int amountOfStocks;
		int valueOfSingleStock;

		try {

			System.out.print("Name of stock: ");
			name = sc.nextLine().trim();

			System.out.print("Price of one stock: ");
			valueOfSingleStock = sc.nextInt();
			sc.nextLine();

			System.out.print("Amount of stocks: ");
			amountOfStocks = sc.nextInt();
			sc.nextLine();

			Class_Stuff.addStuff(new Class_Stock(ownerId, name, amountOfStocks, valueOfSingleStock));
		} catch (Exception e) {
			System.out.print("\n\nSyntax Error!\n\n");
		}
	}

	public static void registerGadget(int ownerId) {

		String name;
		int condition, value;

		try {

			System.out.print("Name of gadget: ");
			name = sc.nextLine().trim();

			System.out.print("Gadget value: ");
			value = sc.nextInt();
			sc.nextLine();

			do {
				System.out.print("Gadget condition (1-10): ");
				condition = sc.nextInt();
				sc.nextLine();

				if (condition < 10 && condition > 0)
					break;

				System.out.println("\nMust be between 1 and 10. Try again\n");
			} while (true);

			Class_Stuff.addStuff(new Class_Gadget(ownerId, name, condition, value));
		} catch (Exception e) {
			System.out.print("\n\nSyntax Error!\n\n");
		}
	}

	public static void registerStuff() {

		int ownerId;

		System.out.print("\nName of the owner: ");
		ownerId = Class_People.getPersonId(sc.nextLine());
		if (ownerId == -1) {
			System.out.print("\n\nNo such person in register. Create person and try again.\n\n");
			return;
		}

		System.out.print("\nType of item:\n1. Jewelry\n2. Stock\n3. Gadget\n\n");

		switch (sc.nextInt()) {

		case 1:
			sc.nextLine();
			registerJewelry(ownerId);
			break;

		case 2:
			sc.nextLine();
			registerStock(ownerId);
			break;

		case 3:
			sc.nextLine();
			registerGadget(ownerId);
			break;

		default:
			if (sc.hasNext())
				sc.nextLine();
			break;
		}
	}

	public static void main(String[] args) {

		do {

			System.out.print("\n1. Create person\n2. Create item\n3. Show all\n4. Show wealthiest\n5. Show person\n6. Crash\n7. Quit\n\n");

			try {

				switch (sc.nextInt()) {

				case 1:
					sc.nextLine();
					registerPerson();
					break;
				case 2:
					sc.nextLine();
					registerStuff();
					break;
				case 3:
					sc.nextLine();
					showAllPeople();
					break;
				case 4:
					showWealthiest();
					break;
				case 5:
					sc.nextLine();
					showPerson(-1);
					break;
				case 6:
					stockMarketCrash();
					break;
				case 7:
					return;
				}

			} catch (Exception e) {

				System.out.print("\nSyntax error\n\n");
				if (sc.hasNext())
					sc.nextLine();

			}

		} while (true);

	}

}
