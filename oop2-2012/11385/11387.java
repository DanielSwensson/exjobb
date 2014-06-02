import java.util.Scanner;
import java.util.ArrayList;

public class ValuesRegister {

	public ArrayList<Person> personRegister = new ArrayList<Person>();
	public Scanner keyboard = new Scanner(System.in);
	
	public Person checkPerson(String name) {
		for (Person p : personRegister) {
			if (p.getName().equalsIgnoreCase(name)) {
				return p;
			}
		}
		return null;
	}

	int readIntIntervall(String question, int min, int max) {
		for (;;) {
			try {
				System.out.print(question);
				int integer = Integer.parseInt(keyboard.nextLine());
				if (integer >= min && integer <= max) {
					return integer;
				} else {
					System.out.println("Must be between " + min + " - " + max);
				}
			} catch (NumberFormatException e) {
				System.out.println("Must be integer! Try again");
			}
		}
	}
	
	double readDoubleIntervallMin(String question, int min) {
		for (;;) {
			try {
				System.out.print(question);
				double checkDouble = Double.parseDouble(keyboard.nextLine());
				if (checkDouble >= min) {
					return checkDouble;
				} else {
					System.out.println("Cant set lower value then: " + min);
				}
			} catch (NumberFormatException e) {
				System.out.println("Must be double! Try again");
			}
		}
	}

	int readIntIntervallMin(String question, int min) {
		for (;;) {
			try {
				System.out.print(question);
				int integer = Integer.parseInt(keyboard.nextLine());
				if (integer >= min) {
					return integer;
				} else {
					System.out.println("Cant set lower value then: " + min);
				}
			} catch (NumberFormatException e) {
				System.out.println("Must be integer! Try again");
			}
		}
	}

	int readInt(String question) {
		for (;;) {
			try {
				System.out.print(question);
				int integer = Integer.parseInt(keyboard.nextLine());
				return integer;
			} catch (NumberFormatException e) {
				System.out.println("Must be integer! Try again");
			}
		}
	}

	String readString(String question) {
		System.out.print(question);
		String str = keyboard.nextLine();
		return str;
	}

	void newPerson() {
		String name = readString("Name of new person: ");
		Person p = checkPerson(name);
		if (p != null) {
			System.out.println("This person already exist!");
			System.out.println();
		} else {
			Person newPerson = new Person(name);
			personRegister.add(newPerson);
		}
	}

	void newItem() {
		if (personRegister.isEmpty() == false) {
			String owner = readString("Name of owner: ");
			Person p = checkPerson(owner);
			if (p != null) {
				ArrayList<Item> itemList = p.getItemList();
				int item = readIntIntervall("What kind of item (1 - jewelry / 2 - stock / 3 - device)? ", 1, 3);
				if (item == 1) {
					int jewelryType = 0;
					String itemName = readString("What kind of jewelry? ");
					int goldJewelry = readIntIntervall("Made of gold? (1 - yes / 2 - no)", 1, 2);
					if (goldJewelry == (1)) {
						jewelryType += 2000;
					} else {
						jewelryType += 700;
					}
					int gemstonesAmount = readIntIntervallMin("Amount of gemstones: ", 0);
					int gemstones = (gemstonesAmount * 500);
					itemList.add(new Jewelry(itemName, jewelryType, gemstones));
				}
				if (item == 2) {
					String itemName = readString("Stock name: ");
					for(Item i : itemList){
						if(itemName.equalsIgnoreCase(i.getItemName()) && i instanceof Stock){
							System.out.println("Add more stocks");
							int stockAmount = readIntIntervallMin("Amount: ", 1);
							System.out.println("Change value of stock");
							double stockValue = readIntIntervallMin("Value of stock: ", 0);
							((Stock)i).setStockAmount(stockAmount);
							((Stock)i).setStockValue(stockValue);
							System.out.println("Amount and/or value have been changed");
							return;
						}
					}
					int stockAmount = readIntIntervallMin("Amount: ", 1);
					double stockValue = readDoubleIntervallMin("Value of stock: ", 1);
					itemList.add(new Stock(itemName, stockValue, stockAmount));
				}

				if (item == 3) {
					String itemName = readString("Device name: ");					
					int newPrice = readIntIntervallMin("Price: ", 0);
					double wear = readIntIntervall("Wear (1-10 where 1 is alot of wear): ", 1, 10);
					wear = (wear / 10);
					itemList.add(new Device(itemName, newPrice, wear));
				}
			} else {
				System.out.println("This person does not exist!");
			}
		} else {
			System.out.println("No person is registred yet");
		}
	}

	void showAll() {
		if (personRegister.isEmpty() == false) {
			System.out.println("List of all persons in register: " + "\n");
			for (Person p : personRegister) {
				System.out.println(p);
			}
		} else {
			System.out.println("No person is registred yet");
		}
	}

	void showRichest() {
		if (personRegister.isEmpty() == false) {
			Person[] richestList;
			richestList = new Person[personRegister.size()];
			int index = 0;
			double maxValue = 0;
			Person richestPerson = null;
			for (Person p : personRegister) {
				if (p.getTotalValue() > maxValue) {
					maxValue = p.getTotalValue();
					richestPerson = p;
					richestList[index] = richestPerson;
				}
			}
			if (maxValue != 0) {
				for (Person p : personRegister) {
					if (p.getTotalValue() == richestPerson.getTotalValue() && !(p.getName().equalsIgnoreCase(richestPerson.getName()))) {
						index++;
						richestList[index] = p;
					}
				}
				for (int i = 0; i <= index; i++) {
					System.out.print("Richest person is " + richestList[i]);
					richestList[i].listItems();
					System.out.println();
				}
			} else {
				System.out.println("No person got anything of value");
			}
		} else {
			System.out.println("No person is registred yet");
		}
	}

	void showPerson() {
		if (personRegister.isEmpty() == false) {
			String name = readString("Name of person: ");
			Person p = checkPerson(name);
				if(p != null){
					System.out.print(p);
					p.listItems();
					System.out.println();
				} else {
					System.out.println("This person does not exist!");
				}
		} else {
			System.out.println("No person is registred yet");
		}
	}

	void stockMarketCrash() {
		for (Person p : personRegister) {
			ArrayList<Item> itemList = p.getItemList();
			for (Item tempItem : itemList) {
				if (tempItem instanceof Stock) {
					((Stock) tempItem).setStockValue(0);
				}
			}
		}
		System.out.println("Stock market crash - Success!");
	}

	public static void main(String[] args) {

		ValuesRegister vr = new ValuesRegister();

		System.out.println("Welcome to ValueRegister");

		for (;;) {
			System.out.println("1 - New person");
			System.out.println("2 - New item to person");
			System.out.println("3 - Show all persons");
			System.out.println("4 - Show ritchest person");
			System.out.println("5 - Show certain person");
			System.out.println("6 - Stock market crash");
			System.out.println("7 - Exit");
			System.out.println();
			int command = vr.readIntIntervall("Choose option: ", 1, 7);

			switch (command) {

			case 1:
				vr.newPerson();
				break;
			case 2:
				vr.newItem();
				break;
			case 3:
				vr.showAll();
				break;
			case 4:
				vr.showRichest();
				break;
			case 5:
				vr.showPerson();
				break;
			case 6:
				vr.stockMarketCrash();
				break;
			case 7:
				System.out.println("Closed");
				System.exit(0);
			default:
				System.out.println("Wrong command");
			}
			System.out.println();
		}
	}
}