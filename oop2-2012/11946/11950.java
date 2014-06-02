import java.util.*;

public class MainProgram {

	private static ArrayList<Person> allperson = new ArrayList<Person>();
	private static Scanner scan = new Scanner(System.in);

	int readInt(String person) {
		for (;;) {
			try {

				System.out.println(person);
				int x = Integer.parseInt(scan.nextLine());
				return x;
			} catch (NumberFormatException e) {
				System.out.println(" Wrong command-use numbers ");
			}

		}
	}

	String readString(String question) {
		System.out.print(question);
		String str = scan.nextLine();

		return str;

	}

	Person getPerson(String name) {
		for (Person p : allperson) {
			if (p.getName().equalsIgnoreCase(name)) {
				return p;
			}
		}
		return null;

	}

	// case 1
	void createPerson() {

		String personName = readString("New persons name:");

		boolean exist = false;

		for (Person p : allperson) {
			if (p.getName().equalsIgnoreCase(personName)) {
				System.out.println(personName + " is already exist");

				exist = true;

			}

		}

		if (exist == false) {

			Person ny = new Person(personName);
			allperson.add(ny);
		}
	}

	// case 2

	public void newAccessorie() {
		int activity = readInt(" Which accessorie?\n 1 Device\n 2 Jewellery\n 3 Stock\n 4 cancel");
		;
		switch (activity) {
		case 1:
			newDevice();
			return;
		case 2:
			newJewellery();
			return;
		case 3:
			newStock();
			return;
		case 4:
			return;
		default:

		}
	}

	private void newDevice() {

		String person = readString(" Who's device");

		String name = readString(" The name of the device");

		int tear = readInt(" How tear is the device? (1-10)");

		int purchasePrice1 = readInt(" What is the giving price?");

		Person p = getPerson(person);
		if (p == null) {

			System.out.println(" Person is not located-please register person:");
			createPerson();

		} else {

			Device d = new Device(name, tear, purchasePrice1);
			p.addItem(d);

			System.out.println(" Device is registered");
		}
		System.out.println();
	}

	private void newJewellery() {

		String person = readString(" Who's jewellery");

		String name = readString(" The name of the jewellery");

		int amountOfGem = readInt(" How many gems does the jewellery consist? ");

		String goldOrSilver = readString(" Is the jewellery gold or silver? Write \"gold\" or \"silver\"");

		Person p = getPerson(person);

		if (p != null) {
			Jewellery jew = new Jewellery(name, amountOfGem, goldOrSilver);
			System.out.println(" Jewellery is registered");
			p.addItem(jew);

		} else {

			System.out.println(" Person is not find!");

		}
		System.out.println();

	}

	private void newStock() {

		String person = readString(" Who's Stock? ");

		String name = readString(" Name of the Stock? ");

		int price = readInt(" What is the giving price? ");

		int amount = readInt(" The amout of Stocks? ");

		Person p = getPerson(person);

		if (p != null) {
			Stock s = new Stock(name, price, amount);
			System.out.println(" Stock is register");
			p.addItem(s);

		} else {

			System.out.println(" Person is not find!");

		}
		System.out.println();
	}

	// case 3
	public void showAll() {
		System.out.println(" Show all:");
		for (Person p : allperson) {

			System.out.println(p.getName() + " " + p.getTotalValue());

		}
		System.out.println();
	}

	// case 4

	public void showRichestAmong() {
		String richestPerson = null;
		double maximumValue = 0;

		double value;

		for (Person p : allperson) {
			String n = p.getName();
			value = p.getTotalValue();
			if (value > maximumValue) {
				maximumValue = value;
				richestPerson = n;
			}

		}
		System.out.println(" The richest person is: " + richestPerson);
		System.out.println();
	}

	// case 5
	public void showSomeInOrder() {

		Person p = getPerson(readString(" Show choosen person:"));
		p.showPerson();

	}

	// case 6

	public void stockCrash() {

		for (Person p : allperson) {

			System.out.print(" ");

			p.stockCrash();

		}

	}

	public static void main(String[] args) {
		MainProgram mp = new MainProgram();

		for (;;) {
			System.out.println("Choose your option among these categories");
			System.out.println("1-Register a person");
			System.out.println("2-Register accessories");
			System.out.println("3-Show all");
			System.out.println("4-Show the richest person");
			System.out.println("5-show some in order");
			System.out.println("6-Stock crash");
			System.out.println("7-Program ends");

			int choose = mp.readInt(" Select commando 1-7");

			switch (choose) {
			case 1:
				mp.createPerson();
				break;
			case 2:
				mp.newAccessorie();
				break;
			case 3:
				mp.showAll();
				break;
			case 4:
				mp.showRichestAmong();
				break;
			case 5:
				mp.showSomeInOrder();
				break;
			case 6:
				mp.stockCrash();
				break;
			case 7:
				System.out.println(" Thanks,and bye!");
				System.exit(0);

			}
		}
	}

}
