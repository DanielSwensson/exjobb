import java.util.ArrayList;
import java.util.Scanner;

public class Program {

	private static ArrayList<Person> allPersons = new ArrayList<Person>();

	private static boolean runProgram = true;

	private static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {

		while (runProgram == true) {
			System.out.println("Ange en siffra 1-7 f�r vad du vill g�ra:");
			System.out.println("1. Skapa person");
			System.out.println("2. Skapa pryl");
			System.out.println("3. Visa alla");
			System.out.println("4. Visa rikaste");
			System.out.println("5. Visa viss person");
			System.out.println("6. B�rskrasch");
			System.out.println("7. Avsluta");
			int command = tC();

			switch (command) {
			case 1:
				addPerson();
				break;
			case 2:
				addThing();
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
				stockCrasch();
				break;
			case 7:
				System.exit(0);
				break;
			default:
				System.out.println("Felaktigt kommando, ange en siffra 1-7");
			}
		}
	}

	public static void addPerson() {
		String name = "";
		System.out.println("Vad heter personen?");
		name = keyboard.nextLine();

		allPersons.add(new Person(name));

		System.out.println("Personen �r registrerad.");

	}

	public static void addThing() {
		System.out.print("Vem �ger prylen?");
		String owner = keyboard.nextLine();
		boolean found = false;
		ArrayList<Thing> thingList = new ArrayList<Thing>();
		Person owners = null;
		for (int x = 0; x < allPersons.size(); x++) {
			Person thisPerson = allPersons.get(x);
			if (thisPerson.getName().equalsIgnoreCase(owner)) {
				found = true;
				owners = thisPerson;
				thingList = allPersons.get(x).getAllThings();
			}
		}
		if (found == false) {
			System.out
					.println("�garen finns ej inlagd i Registret. F�rs�k igen");
			return;
		}

		System.out.println("Vilken sorts pryl �r det? Ange siffra:");
		System.out.println("1. Smycke");
		System.out.println("2. Aktie");
		System.out.println("3. Apparat");
		int sort = tC();

		switch (sort) {
		case 1:
			System.out.println("Vilken sorts smycke �r det?");
			String thingName = keyboard.nextLine();
			System.out.println("�r smycket av guld?");
			boolean gold = getTrue();
			System.out.println("Antal �delstenar:");
			int numberOfStones = tC();

			double value = Jewelery.getJeweleryValue(gold, numberOfStones);
			thingList.add(new Jewelery(owner, sort, thingName, value, gold, numberOfStones));

			owners.setAllThings(thingList);
			System.out.println("Prylen �r registrerad.");
			break;

		case 2:
			System.out.println("Vad �r aktiepostens namn?");
			thingName = keyboard.nextLine();
			System.out.println("Hur m�nga aktier finns i det namnet?");
			int number = tC();
			System.out.println("Vad �r aktien v�rd?");
			int price = tC();

			value = Stock.getStockValue(number, price);
			thingList.add(new Stock(owner, sort, thingName, value, number, price));

			owners.setAllThings(thingList);
			System.out.println("Prylen �r registrerad.");

			break;
		case 3:
			System.out.println("Vilken sorts apparat �r det?");
			thingName = keyboard.nextLine();
			System.out.println("Vad var ink�pspriset?");
			double cost = tC();
			System.out.println("Vilket slitage har apparaten? Ange en siffra 1-10 (10 f�r ny och 1 f�r mycket sliten):");
			double wear = tC();
			if (wear > 10 || wear < 1) {
				System.out.println("Fel, m�ste vara ett tal mellan 1 och 10.");
			}

			else {
			value = cost * (wear / 10.0);
			thingList.add(new Device(owner, sort, thingName, value, cost, wear));

			owners.setAllThings(thingList);
			System.out.println("Prylen �r registrerad.");
			}
			break;

		default:
			break;

		}
	}

	public static void showAll() {
		if (allPersons.size() == 0){
			System.out.println("Det finns inga personer i listan, l�gg till personer och f�rs�k igen.");
		}
		
		else {
		System.out.println("I registret finns:");
		for (Person p : allPersons) {
			System.out.println(p);
		}
	}
}

	public static void showRichest() { 
		if (allPersons.size() == 0){
			System.out.println("Det finns inga personer i listan, l�gg till personer och f�rs�k igen.");
		}
		
		else {
		double biggestValue = 0;
		Person richest = null;
		for (Person per : allPersons) {
			if (per.getTotal() == 0){
				System.out.println("Det finns inga prylar inlagda �n.");
			}
			else if (per.getTotal() > biggestValue){
				biggestValue = per.getTotal();
				richest = per;

		System.out.println("Rikaste personen �r " + richest);
		Person rich = richest;
		ArrayList<Thing> allThings = rich.getAllThings();
		for (Thing th : allThings) {
		System.out.println(th); 
		}
			}
		}
		
		} 
	}

	public static void showPerson() { 
		if (allPersons.size() == 0){
			System.out.println("Det finns inga personer i listan, l�gg till personer och f�rs�k igen.");
		}
		
		else {
		
			System.out.print("Vilken person vill du visa?");
			String name = keyboard.nextLine();
			boolean found = false;
			Person person = null;
			for (int x = 0; x < allPersons.size(); x++) {
				Person thisPerson = allPersons.get(x);
				if (thisPerson.getName().equalsIgnoreCase(name)) {
					found = true;
					person = thisPerson;

					System.out.println(name + " �ger totalt " + person.getTotal() + " kr som utg�rs av dessa prylar:");
					Person pers = person; 
					ArrayList<Thing> allThings = pers.getAllThings();
					for (Thing pr : allThings) {
						System.out.println(pr);
					}
				}
		
			if (found == false){
				System.out
						.println("�garen finns ej inlagd i Registret. F�rs�k igen"); // tv� g�nger??
			}
		}
	}
}

	public static void stockCrasch() {
		for (Person p : allPersons) {
		p.stockCrasch();
	}

		System.out.println("B�rskrasch! Alla aktier �r nu v�rda 0 kr.");
	}


	private static int tC() {
		int digit = 0;
		boolean rightDigit = false;
		while (rightDigit == false) {

			try {
				digit = Integer.parseInt(keyboard.nextLine());
				rightDigit = true;

			}

			catch (NumberFormatException e) {
				System.out.println("FEL, m�ste vara ett numeriskt v�rde, prova igen:");

			}
		}

		return digit;

	}

	public static Boolean getTrue() {
		while (true) {
			String answer = keyboard.nextLine();

			if (answer.equalsIgnoreCase("ja")) {
				return true;

			}
			if (answer.equalsIgnoreCase("nej")) {
				return false;

			}
			System.out.println("Fel, skriv in ja eller nej.");
		}

	}
}
