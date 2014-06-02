import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ThingRegistry {
	//Class variables
	private static ArrayList<Person> alla = new ArrayList<Person>();
	private static Scanner scan = new Scanner(System.in);
	
	public void addGadget(String ownerName) {
		String gadgetName = readString("Vilken sorts pryl: ");
		int cost = readInt("Vad kostade prylen: ", 1);
		int wear = readInt("I vilket skick (1-10) �r prylen: ", 1, 10);
		Person p = getPerson(ownerName);
		p.addThing(new Gadget(gadgetName, cost, wear));
	}
	
	public void addJewelry(String ownerName) {
		String jewelryName = readString("Vilken sorts smycke: ");
		String gold = readString("�r smycket av guld (Ja/Nej): ");
		if (!(gold.equalsIgnoreCase("ja") || gold.equalsIgnoreCase("nej"))) {
			System.out.println("Felaktigt material.");
			return;
		}
		String material;
		if (gold.equalsIgnoreCase("Ja")) {
			material = "gold";
		}
		else {
			material = "silver";
		}
		int numberOfJewels = readInt("Antal �delstenar: ");
		Person p = getPerson(ownerName);
		p.addThing(new Jewelry(jewelryName, numberOfJewels, material));
	}
	
	/*
	 * Skapa person. En ny person skapas genom att programmet fr�gar efter personens namn.
	 * Om det redan finns en person i registret med det namnet ges ett felmeddelande,
	 * annars skapas personen och l�ggs in i registret.
	*/
	public void addPerson() {
		String name = readString("Skriv in personens namn: ");
		Person p = getPerson(name);
		if (p != null) {
			System.out.println("Personen finns redan i registret.");
		}
		else {
			Person newPerson = new Person(name);
			alla.add(newPerson);
		}
	}
	
	public void addStock(String ownerName) {
		String stockName = readString("Vad heter f�retaget: ");
		int number = readInt("Hur m�nga aktier har du: ", 1);
		int cost = readInt("Vad kostade en aktie? ", 1);
		Person p = getPerson(ownerName);
		p.addThing(new Stock(stockName, number, cost));
	}
	
	public void addThing() {
		String ownerName = readString("Vilken person �ger saken: ");
		if (!isPersonInRegistry(ownerName)) {
			System.out.println("Personen finns inte i registret.");
			return;
		}
		String type = readString("Vilken sorts sak (Smycke, Aktie eller Pryl): ");
		switch (type) {
		case "Smycke": addJewelry(ownerName); break;
		case "Aktie": addStock(ownerName); break;
		case "Pryl": addGadget(ownerName); break;
		default: System.out.println("Felaktigt alternativ angiget");
		}
	}
	
	public Person getPerson(String name) {
		for (Person p : alla) {
			if (p.getName().equalsIgnoreCase(name)) {
				return p;
			}
		}
		return null;
	}
	
	public Person getRichest() {
		Person richest = alla.get(0);
		for (Person p : alla) {
			if (p.getNetWorth() > richest.getNetWorth()) {
				richest = p;
			}
		}
		return richest;
	}
	
	public static boolean isPersonInRegistry(String name) {
		for (Person p : alla) {
			if (p.getName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public static void loadAll() {
		try {
			FileInputStream file = new FileInputStream("Person.obj");
			ObjectInputStream in = new ObjectInputStream(file);
			alla = (ArrayList<Person>) in.readObject();
			in.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("Ingen sparfil hittad, b�rjar med ett tomt register.");
		}
		catch(IOException e) {
			System.out.println("I/O undantag!");
			System.exit(2);
		}
		catch(ClassNotFoundException e) {
			System.out.println("Klass inte hittad!");
			System.exit(3);
		}
	}
	
	public int readInt(String question) {
		for (;;) {
			try {
				System.out.println(question);
				int x = Integer.parseInt(scan.nextLine());
				return x;
			}
			catch (NumberFormatException e) {
				System.out.println("Fel - skall vara numeriskt v�rde");
			}
		}
	}
	
	public int readInt(String question, int min) {
		for (;;) {
			try {
				System.out.println(question);
				int x = Integer.parseInt(scan.nextLine());
				if (x < min) {
					System.out.println("Det inmatade v�rdet �r f�r l�gt.");
				}
				else {
					return x;
				}
			}
			catch (NumberFormatException e) {
				System.out.println("Fel - skall vara numeriskt v�rde");
			}
		}
	}
	
	public int readInt(String question, int min, int max) {
		for (;;) {
			try {
				System.out.println(question);
				int x = Integer.parseInt(scan.nextLine());
				if (x < min) {
					System.out.println("Det inmatade v�rdet �r f�r l�gt.");
				}
				else if (x > max) {
					System.out.println("Det inmatade v�rdet �r f�r h�gt.");
				}
				else {
					return x;
				}
			}
			catch (NumberFormatException e) {
				System.out.println("Fel - skall vara numeriskt v�rde");
			}
		}
	}
	
	public String readString(String question) {
		System.out.println(question);
		String str = scan.nextLine();
		return str;
	}
	
	public void removePerson() {
		String removeName = readString("Ange personens namn: ");
		Person p = getPerson(removeName);
		if (p == null) {
			System.out.println("Det finns ingen med det namnet i registret.");
		}
		else {
			alla.remove(p);
		}
	}
	
	public void removeThing() {
		String removeThingFrom = readString("Vilken person: ");
		Person p = getPerson(removeThingFrom);
		if (p == null) {
			System.out.println("Det finns ingen med det namnet i registret.");
		}
		else {
			ArrayList<Thing> thingCollection = p.getThingCollection();
			int numberOfThings = thingCollection.size();
			if (numberOfThings == 0) {
				System.out.println("Personen har inga saker.");
				return;
			}
			System.out.println(p.getName() + " har f�ljande prylar:");
			for (int i = 0;i < numberOfThings;i++) {
				System.out.println((i + 1) + "\t" + thingCollection.get(i).getName() + "\t" + thingCollection.get(i).getValue());
			}
			int removeItem = readInt("Vilken av prylarna ska tas bort (1-" + numberOfThings + "): ");
			if (removeItem < 1 || removeItem > numberOfThings) {
				System.out.println("Felaktig sak angiven.");
			}
			else {
				p.removeThing(removeItem - 1);
			}
		}
	}
	
	public void saveAll() {
		try {
			FileOutputStream file = new FileOutputStream("Person.obj");
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(alla);
			out.close();
		}
		catch(IOException e) {
			System.exit(1);			
		}
	}
	
	/*
	 *  Visa alla. En lista �ver alla personer i registret skrivs ut.
	 *  F�r varje person skrivs ut personens namn samt det sammanlagda v�rdet av personens prylar ut.
	 *  Detta v�rde ber�knas som summan av personens olika prylars v�rde.
	 *  Listan skulle t.ex. kunna se ut s� h�r:
	 *  I registret finns:
	 *  Sara	12875 
	 *  Kalle	92400
	 *  Nisse	8200
	 *  Karin	48400
	 */
	public void showAll() {
		System.out.println("I registret finns:");
		for(Person p : alla) {
			System.out.println(p);
		}
	}
	
	/*
	 * Visa viss person.
	 * Programmet fr�gar efter namnet p� en person och skriver ut den personen (inklusive personens prylar, som ovan).
	 * Om personen ej finns i registret ges ett felmeddelande.
	 */
	public void showPerson() {
		String showName = readString("Ange personens namn: ");
		Person p = getPerson(showName);
		if (p == null) {
			System.out.println("Det finns ingen med det namnet i registret.");
		}
		else {
			System.out.print(p.toString(p.getThingCollection()));
		}
	}
	
	/*
	 * Visa rikaste.
	 * Namn, sammanlagda v�rdet samt de olika prylarna skrivs ut f�r den person i registret som har h�gst v�rde.
	 * Skulle t.ex. kunna se ut s� h�r:
	 * Rikast �r Kalle som sammanlagt �ger 92400
	 * Ring		3800
     * Plasma-tv	38600
     * Ericsson	43000
     * Stereo		7000
	 */
	public void showRichest() {
		Person p = getRichest();
		System.out.println("Rikast �r " + p.getName() + " som sammanlagt �ger " + p.getNetWorth());
		System.out.print(p.toString(p.getThingCollection()));
	}
	
	/*
	 * B�rskrasch. Alla aktier i hela v�rlden blir v�rdel�sa.
	 * Ert program skall g� igenom alla personers alla prylar.
	 * F�r alla aktie-prylar s�tts priset till 0.
	 * (Obs att detta ej g�ller retroaktivt, utan nya aktier som adderas efter b�rskraschen kan ha pris).
	 */
	public void stockCrash() {
		for (Person p : alla) {
			for (Thing t : p.getThingCollection()) {
				if (t instanceof Stock) {
					t.setCost(0);
				}
			}
		}
	}
	
	//Main
	public static void main(String[] args) {
		ThingRegistry tr = new ThingRegistry();
		System.out.println("Hej och v�lkommen till Sakprogrammet");
		loadAll();
		for (;;) {
			//Display starting menu
			System.out.println("1. Skapa person");
			System.out.println("2. Skapa sak");
			System.out.println("3. Visa alla");
			System.out.println("4. Visa rikaste");
			System.out.println("5. Visa viss person");
			System.out.println("6. B�rscrash");
			System.out.println("7. Ta bort person");
			System.out.println("8. Ta bort sak");
			System.out.println("9. Avsluta");
			int alternative = tr.readInt("Ange ett alternativ (1-9): ");
			switch (alternative) {
			case 1: tr.addPerson(); break; //Skapa person
			case 2: tr.addThing(); break; //Skapa pryl
			case 3: tr.showAll(); break; //Visa alla
			case 4: tr.showRichest(); break; //Visa rikaste
			case 5: tr.showPerson(); break; //Visa viss person.
			case 6: tr.stockCrash(); break; //B�rskrasch
			case 7: tr.removePerson(); break; //Ta bort person
			case 8: tr.removeThing(); break; //Ta bort sak
			case 9: tr.saveAll(); System.out.println("Tack och hej d�!"); System.exit(0);
			default: System.out.println("Felaktigt alternativ angivet."); break;
			}
		} //for;
	} //Main

} //Class
