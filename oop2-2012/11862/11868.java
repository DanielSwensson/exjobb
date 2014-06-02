import java.util.Scanner;
import java.util.ArrayList;

public class PersonalValuablesRegister {

	public static Scanner scan = new Scanner(System.in);
	private static ArrayList<Person> personList = new ArrayList<Person>();

	public static int readInt(String question) {
		while (true) {
			try {
				System.out.print(question);
				int x = Integer.parseInt(scan.nextLine());
				return x;
			} catch (NumberFormatException e) {
				System.out.println("Error - Must be a number of type int.");
			}
		}
	}

	public static String readString(String question) {		
		
		System.out.print(question);
		String str = scan.nextLine();
		while(str.trim().equals("")){
			System.out.println("Error - Empty input not accepted.");
			System.out.print(question);
			str = scan.nextLine();
		}
		return str;
	}

	public static int checkIntInterval(String question, int lowest, int highest) {

		int number = readInt(question);
		while (number < lowest || number > highest) {
			System.out.println("Number must be " + lowest + "-" + highest + ".");
			number = readInt(question);
		}
		return number;
	}

	public static Person getPerson(String name) {
		if (!personList.isEmpty()) {
			for (Person temp : personList) {
				if (temp.getName().equalsIgnoreCase(name)) {
					return temp;
				}
			}
		}

		return null;
	}

	public static void registerPerson() {

		String name = readString("Name: ");
		Person temp = getPerson(name);
		if (temp != null) {
			System.out.println("Person already exists.");
		} else {
			temp = new Person(name);
			personList.add(temp);
			System.out.println(name + " has been registered.");
		}
	}

	public static void registerItem() {

		if (personList.isEmpty()) {
			System.out.println("No persons registered.");
		} else {
			String name = readString("Owner of the item: ");

			Person temp = getPerson(name);
			if (temp == null) {
				System.out.println(name + " not found.");
			} else {

				ArrayList<Item> itemList = temp.getItemList();

				System.out.println("Possible item types: ");
				System.out.println("\n1 = Jewelery");
				System.out.println("2 = Stock");
				System.out.println("3 = Device");

				int itemType = checkIntInterval("Enter item type: ", 1, 3);

				String itemName = readString("Enter item name: ");

				Item item = temp.getItem(itemName);

				while (item != null) {

					if (item != null && item instanceof Stock) {
						int quantity = checkIntInterval("Stock quantity: ", 1, 100);
						int unitPrice = checkIntInterval("Stock unit price: ", 0, 500);
						((Stock) item).setValue(quantity, unitPrice);
						System.out.println(itemName	+ " stock quantity and unit price updated.");
						return;
					} else if (item != null) {
						System.out.println("Item already registered, choose a new name.");
						itemName = readString("Enter item name: ");
						item = temp.getItem(itemName);
					}
				}

				switch (itemType) {

				case 1:
					int golden = checkIntInterval("Is it golden(1 = true, 2 = false): ", 1, 2);
					int totalGemstones = checkIntInterval("Number of gemstones: ", 0, 100);
					itemList.add(new Jewelery(itemName, golden, totalGemstones));
					System.out.println(itemName + " has been registered.");
					break;
				case 2:
					int quantity = checkIntInterval("Stock quantity: ", 1, 100);
					int unitPrice = checkIntInterval("Stock unit price: ", 0, 500);
					itemList.add(new Stock(itemName, quantity, unitPrice));
					System.out.println(itemName + " has been registered.");
					break;
				case 3:
					int purchasePrice = checkIntInterval("Purchase price: ", 0, 100000);
					int wear = checkIntInterval("Wear on the device(10-1 where 10 is brand new): ",	1, 10);
					itemList.add(new Device(itemName, purchasePrice, wear));
					System.out.println(itemName + " has been registered.");
					break;
				}
			}
		}
	}

	public static void listEveryone() {
		if (personList.isEmpty()) {
			System.out.println("No persons registered.");
		} else {
			System.out.println("Registered persons: ");
			for (Person temp : personList) {
				System.out.println(temp);
			}
		}

	}

	public static void listRichest() {

		if (personList.isEmpty()) {
			System.out.println("No persons registered.");
		} else {

			double value = 0;
			ArrayList<Person> richList = new ArrayList<Person>();
			Person richest = null;

			for (Person temp : personList) {
				if (temp.totalValue() > value && temp.totalValue() != 0) {
					value = temp.totalValue();					
					richest = temp;
				}				
				
			}
			richList.add(richest);
			
			if(richest !=null){
				for (Person temp : personList) {					
					if (temp.totalValue() == value && !(temp.getName().equalsIgnoreCase(richest.getName()))) {
						richList.add(temp);							
					}
				} if (richList.size() > 1) {
						System.out.println("The richest persons are: ");
						for (Person temp : richList) {
							System.out.println(temp.getName()+ " with a total of: " + temp.totalValue());
							temp.listItems();
							System.out.print("\n");
						}
					} else {
						System.out.println("The richest person is "+ richest.getName() + " with a total of: "+ richest.totalValue());
						richest.listItems();
					}
				
			}else {
				System.out.println("Nobody owns anything of value.");
			}
		}
	}

	public static void listPerson() {
		if (personList.isEmpty()) {
			System.out.println("No persons registered.");
		} else {
			String name = readString("Name: ");
			Person temp = getPerson(name);
			if (temp != null) {
				System.out.println(temp);
				temp.listItems();
			} else if (temp == null) {
				System.out.println(name + " not found.");
			}
		}
	}

	public static void stockMarketCrash() {
		for (Person temp : personList) {
			temp.crashStocks();
		}
		System.out.println("Stock market crash complete.");
	}

	public static void main(String[] args) {

		System.out.println("Personal valuables register 1.0");

		while (true) {

			System.out.println("\n*********************************");
			System.out.println("            Commands:");
			System.out.println("*********************************");
			System.out.println("\n1 = Register person");
			System.out.println("2 = Register item");
			System.out.println("3 = List every person");
			System.out.println("4 = List richest person");
			System.out.println("5 = List specified person");
			System.out.println("6 = Crash the stock market");
			System.out.println("7 = Exit");
			System.out.println("\n*********************************");

			int command = readInt("\nCommand> ");

			switch (command) {

			case 1:
				registerPerson();
				break;
			case 2:
				registerItem();
				break;
			case 3:
				listEveryone();
				break;
			case 4:
				listRichest();
				break;
			case 5:
				listPerson();
				break;
			case 6:
				stockMarketCrash();
				break;
			case 7:
				System.out.println("Goodbye!");
				System.exit(0);
			default:
				System.out.println("Error - Unknown command");

			}
		}
	}
}
