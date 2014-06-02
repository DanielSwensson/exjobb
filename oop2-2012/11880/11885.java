import java.util.*;

public class PossessionMain {

	private static Scanner keyboard = new Scanner(System.in);
	private static ArrayList<Person> allPersons = new ArrayList<Person>();

	public static void printString(String inString) {
		System.out.println(inString);
	}

	public static String readString(String inString) {

		printString(inString);
		String outString = keyboard.nextLine();

		return outString;
	}

	public static int readInt(String inString) {

		int outInt = 0;
		boolean okInt = true;

		do {
			okInt = true;
			printString(inString);

			try {
				outInt = Integer.parseInt(keyboard.nextLine());

			} catch (Exception e) {
				printString("Wrong input. Number expected.");
				okInt = false;
			}

		} while (okInt == false);

		return outInt;
	}

	public static void main(String[] args) {

		int command = 0;

		printString("The following commands are available:\nCreate person:      1 List specific person: 5\nCreate possession: "
				+ " 2 Stock market crash:   6\nList all persons:   3 Quit:                 7\nList richest:       4 \nInput command:");

		for (;;) {

			command = readInt(">");

			switch (command) {

			// Register person:
			case 1:
				boolean okName;
				String peNa;

				do {
					okName = true;
					peNa = readString("Name:");
					for (Person p : allPersons) {
						if (peNa.equals(p.getPersonName())) {
							okName = false;
						}

					}
					if (okName == false) {
						printString(peNa + " already exists in the register.");
					}

				} while (okName == false);

				Person a = new Person(peNa);
				allPersons.add(a);
				printString(peNa + " has been added to the register.");

				break;

			// Register possession:
			case 2:
				boolean ownerExists = false;
				String poNa;
				int poType = 0;

				peNa = readString("Owner:");
				for (Person p : allPersons) {
					if (peNa.equals(p.getPersonName())) {

						ownerExists = true;

						boolean okType = false;

						while (okType == false) {
							poType = readInt("Type of possession:\nItem:     1\nJewelry:  2\nStock:    3");

							if (poType == 1 || poType == 2 || poType == 3) {
								okType = true;
							} else {
								printString("Invalid possession type.");
							}

						}

						if (poType == 1) {

							poNa = readString("Item: ");

							int pur = readInt("Purchase price: ");

							int con = 0;
							boolean okCon = false;

							while (okCon == false) {
								con = readInt("Condition, 1-10: ");

								if ((con >= 0 && con <= 11)) {
									okCon = true;
								} else {
									printString("Invalid condition");
								}

							}

							Item newItem = new Item(poNa, pur, con);
							p.newPossession(newItem);

							printString(poNa + " has been added to " + peNa
									+ "'s possessions.");
						}

						if (poType == 2) {

							int mat = 0;

							poNa = readString("Type of jewelry: ");

							boolean okMat = false;

							while (okMat == false) {
								mat = readInt("Gold or silver:\nGold:   1\nSilver: 2");

								if (mat == 1 || mat == 2) {
									okMat = true;
								} else {
									printString("Invalid material.");
								}

							}

							int jew = readInt("Ammount of jewels: ");

							Jewelry newJewelry = new Jewelry(poNa, mat, jew);
							p.newPossession(newJewelry);

							printString(poNa + " has been added to " + peNa
									+ "'s possessions.");
						}

						if (poType == 3) {

							poNa = readString("Name of stock:");
							int pri = readInt("Stock price:");
							int amm = readInt("Ammount of stock:");

							Stock newStock = new Stock(poNa, pri, amm);
							p.newPossession(newStock);

							printString(poNa + " has been added to " + peNa
									+ "'s possessions.");
						}

					}

				}
				if (ownerExists == false) {
					printString("Owner does not exist in the register.");
				}

				break;

			// List all persons:
			case 3:
				printString("People in register:");
				for (Person p : allPersons) {
					printString(p.getPersonName() + " " + p.getTotalWorth()
							+ "kr");
				}

				break;

			// List richest:
			case 4:
				Person richest = allPersons.get(0);

				for (Person p : allPersons) {
					if (p.getTotalWorth() > richest.getTotalWorth()) {
						richest = p;
					}
				}
				printString(richest.getPersonName()	+ " is the richest person in the register. Total worth is: " + richest.getTotalWorth() + "kr.");
				richest.printPossessions();

				break;

			// List specific person:
			case 5:

				boolean okPerson = false;
				String specPerson = readString("Person:");

				for (Person p : allPersons) {
					if (specPerson.equals(p.getPersonName())) {
						okPerson = true;
						printString(p.getPersonName() + "'s possessions are worth "	+ p.getTotalWorth() + "kr.");
						p.printPossessions();
					}
				}
				if (okPerson == false) {
					printString(specPerson + " does not exist in the register.");
				}

				break;

			// Stock market crash:
			case 6:
				for (Person p : allPersons) {
					p.resetAllStock();
				}
				printString("The stock market has crashed. All stock is now worthless.");

				break;

			// Quit:
			case 7:
				printString("Good bye!");
				System.exit(0);

			default:
				printString("Incorrect command.");
			}
		}
	}

}