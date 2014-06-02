
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Register {

	private static Menu menu = new Menu();

	private ArrayList<Person> persons = new ArrayList<Person>();
	private Scanner sc = new Scanner(System.in);

	private Person p;

	public String readString(String prompt) {
		System.out.print(prompt);
		String str = sc.nextLine();
		return str;
	}

	public int readInt(String prompt) {
		while (true) {
			try {
				System.out.print(prompt);
				int no = sc.nextInt();
				return no;
			}
			catch (InputMismatchException e) {
				System.out.println("'" + sc.next() + "'  is not a numeric value.");
				sc.nextLine();	
			}
		}
	}

	public double readDouble(String prompt) {
		while (true) {
			try {
				System.out.print(prompt);
				double no = sc.nextDouble();
				return no;
			}
			catch (InputMismatchException e) {
				System.out.println("'" + sc.next() + "'  is not a numeric value.");
				sc.nextLine();	
			}
		}
	}

	private Person getPerson(String name) {
		for (Person p : persons) {
			if (p.getName().equalsIgnoreCase(name)) {
				return p;
			}
		}
		return null;
	}

	public void addPerson() {
		while (true) {
			String name = readString("Enter a name to add a person: ");
			p = getPerson(name);
			if (p == null) {
				persons.add(new Person(name));
				System.out.println("'" + name + "'" + " added.");
				break;
			} else {
				System.out.println("'" + name + "'" + " is already added. Enter a different name.");
			}
		}
	}

	public void addJewellery() {
		String type = readString("Type of jewellery: ");
		String material = readString("Gold or silver: ");
		int gemstones = readInt("How many gemstones: ");
		sc.nextLine();
		p.addThing(new Jewellery(type, material, gemstones));
		System.out.println("'" + type + "'" + " added.");
		menu.mainMenu();
	}

	public void addShare() {
		String name = readString("Name of share: ");
		int amount = readInt("How many shares: ");
		double price = readDouble("Price: ");
		sc.nextLine();
		p.addThing(new Share(name, amount, price));
		System.out.println("'" + name + "'" + " added.");
		menu.mainMenu();
	}

	public void addAppliance() {
		String type = readString("Type of appliance: ");
		double price = readDouble("Price: ");
		while (true) {
			int wear = readInt("Appliance wear. Enter a number between 0-10." +
					"\n(0 = damaged beyond repair and 10 = new): ");
			if (wear >= 0 && wear <= 10) {
				sc.nextLine();
				p.addThing(new Appliance(type, price, wear));
				System.out.println("'" + type + "'" + " added.");
				menu.mainMenu();
			} else {
				System.out.println("Error. Enter a number between 0-10.");
			}
		}
	}

	public void addThing() {
		while (true) {
			if (persons.size() == 0) {
				System.out.println("Error. List is empty.");
				break;
			} else {
				System.out.println("Added persons:");
				for (Person p : persons) {
					System.out.println(p.getName());
				}
				String name = readString("Who do you want to add a thing to: ");
				p = getPerson(name);
				if (p != null) {
					menu.addThingMenu();
				} else {
					System.out.println("'" + name + "'" + " does not exist. Enter a different name.");
				}
			}
		}
	}

	public void showAllPersons() {
		if (persons.size() == 0) {
			System.out.println("Error. List is empty.");
		} else {
			System.out.println("Showing all persons:");
			for (Person p : persons) {
				System.out.println(p);
			}
		}
	}

	public void showRichestPerson() {
		double wealth = 0;
		String richestPerson = null;
		String allThings = null;

		for (Person p : persons) {
			if (p.getWealth() > wealth) {
				wealth = p.getWealth();
				richestPerson = p.getName();
				allThings = p.getThings();
			}
		} 
		try {
			if (wealth > 0) {
				System.out.println(richestPerson + " is richest with " + wealth + "\n" + allThings);
			} else {
				System.out.println("Error. Everyone is broke.");
			}
		} catch (NullPointerException e) {
			System.out.println("Error. List is empty.");
		}
	}

	public void showPerson() {
		if (persons.size() > 0) {
			while (true) {
				System.out.println("Added persons:");
				for (Person p : persons) {
					System.out.println(p.getName());
				}
				String name = readString("Show person: ");
				p = getPerson(name);
				if (p != null) {
					try {
						System.out.println(p + "\n" + p.getThings());
						break;
					} catch (Exception e) {
						System.out.println("Error. List is empty.");
					}
				} else {
					System.out.println("'" + name + "'" + " does not exist. Enter a different name.");
				}
			}
		} else {
			System.out.println("Error. List is empty.");
		}
	}

	public void startStockMarketCrash() {
		for (Person p : persons) {
			p.stockMarketCrash();
		}
		System.out.println("The stock market just crashed. Your shares are now worth nothing.");
	}

}