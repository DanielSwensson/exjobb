import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	
	Scanner keyboard = new Scanner(System.in);
	
	private ArrayList<Person> allPersons = new ArrayList<Person>();
	
	// Main
	public static void main(String[] args) {
		Main m = new Main();
		m.mainMethod();
	}
		
	// Main-metod
	private void mainMethod() {
		System.out.print("1 - Skapa person\n2 - Skapa v�rdesak\n3 - Visa alla personer\n4 - Visa rikaste person\n5 - Visa viss person\n6 - Inled b�rskrash\n7 - Avsluta program");

		// Kommandotolk
		while (true) {
			System.out.print("\n> ");
			int command = readInt("");

			switch (command) {
			case 0:
				System.out.print("1 - Skapa person\n2 - Skapa v�rdesak\n3 - Visa alla personer\n4 - Visa rikaste person\n5 - Visa viss person\n6 - Inled b�rskrash\n7 - Avsluta program");
				break;
			case 1:
				// Skapa person
				System.out.print(createPerson(readString("Ange namnet p� personen du vill registrera: ")));
				break;
			case 2:
				// L�gg till v�rdesak
				addValuable();
				break;
			case 3:
				// Visa alla
				if (allPersons.isEmpty()) {
					System.out.print("Inga personer finns registrerade!");
				} else {
					System.out.print(getAllPersons());
				}
				break;
			case 4:
				// Visa rikaste
				if (allPersons.isEmpty()) {
					System.out.print("Inga personer finns registrerade!");
				} else {
					System.out.print("Den rikaste personen �r " + getRichest().printPerson());
				}
				break;
			case 5:
				// Visa person
				if (allPersons.isEmpty()) {
					System.out.print("Inga personer finns registrerade!");
				} else {
					Person person = getPerson(readString("Vem vill du visa? "));
					if (person != null) {
						System.out.print("Du har valt att visa " + person.printPerson());
					} else {
						System.out.print("Personen finns inte registrerad.");
					}
				}
				break;
			case 6:
				// B�rskrash
				System.out.print(crashAllStocks());
				break;
			case 7:
				// Avsluta
				keyboard.close();
				System.out.print("Programmet har avslutats.");
				System.exit(0);
				break;
			default:
				System.out.print("Felaktigt kommando, skriv 0 f�r att lista giltiga kommandon (1-7).");
			}
		}
	}
	
	
	// Kontrollerar om en person finns i arrayen eller inte
	private boolean personPresentInArray(String name) {
		for (int indexPos = 0; indexPos < allPersons.size(); indexPos++) {
			if ((allPersons.get(indexPos).getName().equalsIgnoreCase(name))) {
				return true;
				}
		}
		return false;
	}
	
	
	// L�gger till en ny person i registret
	private String createPerson(String name) {
		if (personPresentInArray(name) == false) {
			allPersons.add(new Person(name));
			return name + " har lagts till i registret.";
		} else {
			return name + " finns redan i registret!";
		}
	}
	
	
	// Metod f�r att assistera i skapandet av v�rdesak
	private void addValuable() {
		String ownerName = readString("Vilken person �ger v�rdesaken? ");
		if (personPresentInArray(ownerName) == false) {
			System.out.print(ownerName + " finns inte i registret.");
		} else {
			String itemType = readString("Vilken typ av v�rdesak �r det (smycke/apparat/aktie)? ").toUpperCase();
			
			Person owner = getPerson(ownerName);
			switch (itemType) {
			case "SMYCKE":
				addJewelry(owner);
				break;
			case "APPARAT":
				addDevice(owner);
				break;
			case "AKTIE":
				addStock(owner);
				break;
			default:
				System.out.print(itemType + " �r inte en giltig v�rdesak.");
			}
		}
	}
	
	// L�gger till smycke
	private void addJewelry(Person owner) {
		boolean gold;
		
		String itemName = readString("Vilken typ av smycke �r det? ");
		String isGold = readString("�r smycket gjort av guld (ja/nej)? ");
		if (isGold.equalsIgnoreCase("JA") || isGold.equalsIgnoreCase("J")) {
			gold = true;
		} else {
			gold = false;
		}
		int gemstones = readInt("Hur m�nga �delstenar inneh�ller smycket? ");
		owner.addValuable(new Jewelry (itemName, gold, gemstones));
		
		System.out.print(itemName + " har lagts till i registret.");
	}
		
	// L�gger till apparat
	private void addDevice(Person owner) {
		String itemName = readString("Vilken typ av apparat �r det? ");
		int purchasePrice = readInt("Vad hade apparaten f�r ink�pspris? ");
		int wear = readInt("I hur bra skick �r apparaten (1-10 d�r 10 �r nyskick)? ");
		while (wear < 1 || wear > 10) {
			wear = readInt("Ogiltig siffra. Skriv in en ny mellan 1-10: ");
		}
		owner.addValuable(new Device (itemName, purchasePrice, wear));
		
		System.out.print(itemName + " har lagts till i registret.");
	}
	
	// L�gger till aktie
	private void addStock(Person owner) {
		String itemName = readString("Vilken typ av aktie �r det (vilket f�retag g�ller den f�r)? ");
		int amountOfShares = readInt("Hur m�nga aktier �r det? ");
		int pricePerShare = readInt("Hur mycket �r varje aktie v�rd? ");
		owner.addValuable(new StockShare (itemName, amountOfShares, pricePerShare));
		
		System.out.print(itemName + " aktierna har lagts till i registret.");
	}
	
	// Kraschar b�rsen
	private String crashAllStocks () {
		for (int indexPos = 0; indexPos < allPersons.size(); indexPos++) {
			allPersons.get(indexPos).stockCrash();
		}
		return "B�rsen har kraschat! Alla nuvarande aktier �r v�rdel�sa!";
	}
	
	
	// H�mtar och skriver ut alla personer i registret
	private String getAllPersons() {
		String allPeople = "";
		for (int indexPos = 0; indexPos < allPersons.size(); indexPos++) {
			allPeople += "\n" + allPersons.get(indexPos).toString() + "		" + allPersons.get(indexPos).getTotalValue();
		}
		return "I registret finns " + allPeople;
	}
	
	
	// Letar reda p� och skickar vidare den rikaste personen i registret
	private Person getRichest() {
		Person richestPerson = allPersons.get(0);
		for (int indexPos = 0; indexPos < allPersons.size(); indexPos++) {
			if (richestPerson.getTotalValue() < allPersons.get(indexPos).getTotalValue()) {
				richestPerson = allPersons.get(indexPos);
			}
		}
		return richestPerson;
	}
	
	
	// H�mtar vald person som ett objekt
	private Person getPerson(String name) {
		for (int indexPos = 0; indexPos < allPersons.size(); indexPos++) {
			if ((allPersons.get(indexPos).getName().equalsIgnoreCase(name))) {				
				return (allPersons.get(indexPos));
			}
		}
		return null;
	}
	
	
	
	// Metod f�r att l�sa in numeriska heltal
	public int readInt(String userRequest) {
		while(true) {
			try {
				System.out.print(userRequest);
				int input = Integer.parseInt(keyboard.nextLine());
				return input;
			}
			catch (NumberFormatException e) {
				System.out.print("Du m�ste skriva in ett numeriskt heltal! F�rs�k igen.\n");
			}
		}
	}
	
	// Metod f�r att l�sa in text
	public String readString(String userRequest) {
				System.out.print(userRequest);
				String input = keyboard.nextLine();
				return input;
	}
	
}
