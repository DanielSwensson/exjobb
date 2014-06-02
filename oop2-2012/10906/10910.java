import java.util.ArrayList;
import java.util.Scanner;

public class Register {

	private Scanner keyboard = new Scanner(System.in);

	private ArrayList<Person> persons = new ArrayList<Person>();

	private boolean runProgram = true;

	public static void main(String[] args) {
		new Register();
	}

	public Register() {

		System.out.println("Välj ett av nedanstående alternativ:");

		while (runProgram == true) {
			System.out.println("1. Skapa person");
			System.out.println("2. Skapa pryl");
			System.out.println("3. Visa alla");
			System.out.println("4. Visa rikaste");
			System.out.println("5. Visa viss person");
			System.out.println("6. Börskrasch");
			System.out.println("7. Avsluta");
			int choice = getNextInt();

			switch (choice) {
			case 1:
				createPerson();
				break;

			case 2:
				createThing();
				break;

			case 3:
				showAll();
				break;

			case 4:
				showRichest();
				break;

			case 5:
				showPerson();
				break;

			case 6:
				stockCrash();
				break;

			case 7:
				exit();
				break;

			default:
				System.out.println("Fel kommando, välj ett av nedanstående alternativ:");
			}
		}
	}

	private Person findPerson(String name) {
		for (Person person : persons) {
			if (name.equalsIgnoreCase(person.getName())) {
				return person;
			}
		}
		return null;
	}

	private void createPerson() {
		System.out.println("Vad heter Personen?");
		String name = keyboard.nextLine();

		if (findPerson(name) == null) {
			Person person = new Person(name);
			persons.add(person);
			System.out.println(name + " är skapad");
		}
		else {
			System.out.println("Personen finns redan i systemet");
		}
	}

	private void createThing() {
		System.out.println("Vilken person äger prylen?");
		String personName = keyboard.nextLine();

		Person foundPerson = null;
		foundPerson = findPerson(personName);

		if (foundPerson == null) {
			System.out.println("Personen finns inte i systemet");
			return;
		}

		System.out.println("Vilket sorts pryl är det? Smycke? Aktie? Apparat?");
		String thingName = keyboard.nextLine();

		if (thingName.equalsIgnoreCase("smycke")) {
			createJewelry(foundPerson);
		}
		else if (thingName.equalsIgnoreCase("aktie")) {
			createShare(foundPerson);
		}
		else if (thingName.equalsIgnoreCase("apparat")) {
			createDevice(foundPerson);
		}
		else {
			System.out.println("Finns ingen pryl med det angivna namnet");
		}

	}

	private void createJewelry(Person person) {
		System.out.println("Vilket sorts smycke är det?");
		String jewelType = keyboard.nextLine();
		System.out.println("Är smycket gjort av guld?");
		boolean gold = getNextBoolean();
		System.out.println("Hur många ädelstenar har smycket?");
		int gemstones = getNextInt();

		Jewelry jewelry = new Jewelry(jewelType, gemstones, gold);
		person.addThing(jewelry);
	}

	private void createShare(Person person) {
		System.out.println("Vad heter aktien?");
		String name = keyboard.nextLine();
		System.out.println("Hur många aktier?");
		int amount = getNextInt();
		System.out.println("Vad kostar aktien?");
		double price = getNextDouble();

		Share share = new Share(name, amount, price);
		person.addThing(share);
	}

	private void createDevice(Person person) {
		System.out.println("Vad heter apparaten?");
		String name = keyboard.nextLine();
		System.out.println("Vad kostade apparaten??");
		double cost = getNextDouble();

		System.out.println("slitage? 10 = ny, 1 = mycket sliten");
		int wear = getNextInt();
		while (wear > 10 || wear < 1) {
			System.out.println("Vänligen skriv en siffra mellan 1 och 10");
			wear = getNextInt();
		}

		Device device = new Device(name, cost, wear);
		person.addThing(device);
	}

	private void showAll() {
		if (persons.isEmpty()) {
			System.out.println("Det finns inga personer i registret");
		}
		else {
			System.out.println("I registret finns:");
			for (Person person : persons) {
				System.out.println(person.getName() + " äger prylar till ett värde av " + person.getTotalValue() + " kr");
			}
		}
	}

	private void showRichest() {
		if (persons.isEmpty()) {
			System.out.println("Det finns ingen person i registret");
		}
		else {
			Person richest = persons.get(0);

			for (Person person : persons) {
				if (person.getTotalValue() > richest.getTotalValue()) {
					richest = person;
				}
			}
			System.out.println("Rikast i registret är " + richest.getName() + " med prylar till ett värde av " + richest.getTotalValue()
					+ " kr");
			System.out.println(richest.getAllThings());
		}
	}

	private void showPerson() {
		System.out.println("Vad heter Personen?");
		String personName = keyboard.nextLine();
		Person foundPerson = null;

		foundPerson = findPerson(personName);

		if (foundPerson == null) {
			System.out.println("Personen finns inte i systemet");
			return;
		}
		System.out.println(foundPerson.getName() + " äger saker till ett värde av " + foundPerson.getTotalValue() + " kr");
		System.out.println(foundPerson.getAllThings());
	}

	private void stockCrash() {
		for (Person person : persons) {
			person.stockCrash();
		}
		System.out.println("Börskrasch godkänd, alla aktier värda 0");
	}

	private int getNextInt() {
		int number = 0;

		boolean validNumber = false;

		while (validNumber == false) {

			try {
				number = Integer.parseInt(keyboard.nextLine());
				validNumber = true;
			}
			catch (NumberFormatException exception) {
				System.out.println("Vänligen skriv i en siffra");
			}
		}
		return number;
	}

	private double getNextDouble() {
		double number = 0;

		boolean validNumber = false;

		while (validNumber == false) {

			try {
				number = Double.parseDouble(keyboard.nextLine());
				validNumber = true;
			}
			catch (NumberFormatException exception) {
				System.out.println("Vänligen skriv i ett decimaltal");
			}
		}
		return number;
	}

	private boolean getNextBoolean() {

		while (true) {
			String answer = keyboard.nextLine();

			if (answer.equalsIgnoreCase("ja")) {
				return true;
			}

			if (answer.equalsIgnoreCase("nej")) {
				return false;
			}
			System.out.println("vänligen skriv ja eller nej");
		}
	}

	private void exit() {
		runProgram = false;
		keyboard.close();
		System.out.println("Programmet har avslutats");
	}

}
