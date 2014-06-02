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
		System.out.print("1 - Skapa person\n2 - Skapa värdesak\n3 - Visa alla personer\n4 - Visa rikaste person\n5 - Visa viss person\n6 - Inled börskrash\n7 - Avsluta program");

		// Kommandotolk
		while (true) {
			System.out.print("\n> ");
			int command = readInt("");

			switch (command) {
			case 0:
				System.out.print("1 - Skapa person\n2 - Skapa värdesak\n3 - Visa alla personer\n4 - Visa rikaste person\n5 - Visa viss person\n6 - Inled börskrash\n7 - Avsluta program");
				break;
			case 1:
				// Skapa person
				System.out.print(createPerson(readString("Ange namnet på personen du vill registrera: ")));
				break;
			case 2:
				// Lägg till värdesak
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
					System.out.print("Den rikaste personen är " + getRichest().printPerson());
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
				// Börskrash
				System.out.print(crashAllStocks());
				break;
			case 7:
				// Avsluta
				keyboard.close();
				System.out.print("Programmet har avslutats.");
				System.exit(0);
				break;
			default:
				System.out.print("Felaktigt kommando, skriv 0 för att lista giltiga kommandon (1-7).");
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
	
	
	// Lägger till en ny person i registret
	private String createPerson(String name) {
		if (personPresentInArray(name) == false) {
			allPersons.add(new Person(name));
			return name + " har lagts till i registret.";
		} else {
			return name + " finns redan i registret!";
		}
	}
	
	
	// Metod för att assistera i skapandet av värdesak
	private void addValuable() {
		String ownerName = readString("Vilken person äger värdesaken? ");
		if (personPresentInArray(ownerName) == false) {
			System.out.print(ownerName + " finns inte i registret.");
		} else {
			String itemType = readString("Vilken typ av värdesak är det (smycke/apparat/aktie)? ").toUpperCase();
			
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
				System.out.print(itemType + " är inte en giltig värdesak.");
			}
		}
	}
	
	// Lägger till smycke
	private void addJewelry(Person owner) {
		boolean gold;
		
		String itemName = readString("Vilken typ av smycke är det? ");
		String isGold = readString("Är smycket gjort av guld (ja/nej)? ");
		if (isGold.equalsIgnoreCase("JA") || isGold.equalsIgnoreCase("J")) {
			gold = true;
		} else {
			gold = false;
		}
		int gemstones = readInt("Hur många ädelstenar innehåller smycket? ");
		owner.addValuable(new Jewelry (itemName, gold, gemstones));
		
		System.out.print(itemName + " har lagts till i registret.");
	}
		
	// Lägger till apparat
	private void addDevice(Person owner) {
		String itemName = readString("Vilken typ av apparat är det? ");
		int purchasePrice = readInt("Vad hade apparaten för inköpspris? ");
		int wear = readInt("I hur bra skick är apparaten (1-10 där 10 är nyskick)? ");
		while (wear < 1 || wear > 10) {
			wear = readInt("Ogiltig siffra. Skriv in en ny mellan 1-10: ");
		}
		owner.addValuable(new Device (itemName, purchasePrice, wear));
		
		System.out.print(itemName + " har lagts till i registret.");
	}
	
	// Lägger till aktie
	private void addStock(Person owner) {
		String itemName = readString("Vilken typ av aktie är det (vilket företag gäller den för)? ");
		int amountOfShares = readInt("Hur många aktier är det? ");
		int pricePerShare = readInt("Hur mycket är varje aktie värd? ");
		owner.addValuable(new StockShare (itemName, amountOfShares, pricePerShare));
		
		System.out.print(itemName + " aktierna har lagts till i registret.");
	}
	
	// Kraschar börsen
	private String crashAllStocks () {
		for (int indexPos = 0; indexPos < allPersons.size(); indexPos++) {
			allPersons.get(indexPos).stockCrash();
		}
		return "Börsen har kraschat! Alla nuvarande aktier är värdelösa!";
	}
	
	
	// Hämtar och skriver ut alla personer i registret
	private String getAllPersons() {
		String allPeople = "";
		for (int indexPos = 0; indexPos < allPersons.size(); indexPos++) {
			allPeople += "\n" + allPersons.get(indexPos).toString() + "		" + allPersons.get(indexPos).getTotalValue();
		}
		return "I registret finns " + allPeople;
	}
	
	
	// Letar reda på och skickar vidare den rikaste personen i registret
	private Person getRichest() {
		Person richestPerson = allPersons.get(0);
		for (int indexPos = 0; indexPos < allPersons.size(); indexPos++) {
			if (richestPerson.getTotalValue() < allPersons.get(indexPos).getTotalValue()) {
				richestPerson = allPersons.get(indexPos);
			}
		}
		return richestPerson;
	}
	
	
	// Hämtar vald person som ett objekt
	private Person getPerson(String name) {
		for (int indexPos = 0; indexPos < allPersons.size(); indexPos++) {
			if ((allPersons.get(indexPos).getName().equalsIgnoreCase(name))) {				
				return (allPersons.get(indexPos));
			}
		}
		return null;
	}
	
	
	
	// Metod för att läsa in numeriska heltal
	public int readInt(String userRequest) {
		while(true) {
			try {
				System.out.print(userRequest);
				int input = Integer.parseInt(keyboard.nextLine());
				return input;
			}
			catch (NumberFormatException e) {
				System.out.print("Du måste skriva in ett numeriskt heltal! Försök igen.\n");
			}
		}
	}
	
	// Metod för att läsa in text
	public String readString(String userRequest) {
				System.out.print(userRequest);
				String input = keyboard.nextLine();
				return input;
	}
	
}
