

import java.util.*;

public class MainProgram {

	ArrayList<Person> allperson = new ArrayList<Person>();
	Scanner scan = new Scanner(System.in);

	int readInt(String person) {
		for (;;) {
			try {

				System.out.println(person);
				int x = Integer.parseInt(scan.nextLine());
				return x;
			} catch (NumberFormatException e) {
				System.out.println("Wrong command-use numbers ");
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
			if (p.getName().equals(personName)) {
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
		int activity = readInt("which accessorie?\n 1 Device\n 2 Jewellery\n 3 Stock\n 4 cancel");
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

		String person = readString("Who's device");

		String name = readString("The name of the device");

		int tear = readInt("how tear is the device? (1-10)");

		int purchasePrice1 = readInt("what is the giving price?");


		Person p =	getPerson(person);
		if(p==null){

			System.out.println("Person is not located-please register person:");
			createPerson(); 


		}
		else{
			
			Device d = new Device (name, tear, purchasePrice1);
			p.all.add(d);
			
			p.setTotalValue(d.getValue());
			System.out.println("Device is registered");
		}
		System.out.println();
	}

	private void newJewellery() {

		String person = readString("Who's jewellery");

		String name = readString("The name of the jewellery");

		int amountOfGem = readInt("How many gems does the jewellery consist? ");


		String goldOrSilver = readString("Is the jewellery gold or silver? Write \"gold\" or \"silver\"");

		Person p = getPerson(person);

		if (p!=null) {
			Jewellery jew = new Jewellery(name, amountOfGem,goldOrSilver);
			System.out.println("Jewellery is registered");
			p.all.add(jew);
			p.setTotalValue(jew.getValue());
		} else {

			System.out.println("Person is not find!");

		}
		System.out.println();

	}

	private void newStock() {

		String person = readString("Who's Stock? ");

		String name = readString("Name of the Stock? ");

		int price = readInt("What is the giving price? ");

		int amount = readInt("The amout of Stocks? ");

		Person p =getPerson(person);

		if (p!=null) {
			Stock s = new Stock( name, price, amount);
			System.out.println("Stock is register");
			p.all.add(s);
			p.setTotalValue(s.getValue());

		} else {

			System.out.println("Person is not find!");

		}
		System.out.println();
	}

	// case 3
	public void showAll() {
		System.out.println("Show all:");
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
		System.out.println("The richest person is: " + richestPerson);
		System.out.println();
	}

	// case 5
	public void showSomeInOrder() {	
		Person p = getPerson(readString("Show choosen person:"));
		if (p!=null) {
			p.showPerson();
		} else {
		System.out.println("Person is not found!");
	}
	}
	
	// case 6

	public void stockCrash() {
		System.out.println("Sorry, your stock are crashing");
		for (Person p : allperson) {
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
			System.out.println("5-Show choosen person");
			System.out.println("6-Stock crash");
			System.out.println("7-Program ends");


			int choose = mp.readInt("Select commando 1-7");

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
				System.out.println("Thanks,and bye!");
				System.exit(0);

			}
		}
	}

}

