import java.util.Scanner;
import java.util.ArrayList;

public class VardeRegister {
	
	private	static Scanner keyboard = new Scanner(System.in);
	private static ArrayList<User> allUsers = new ArrayList<User>();
	private	static String[] itemType = {"smycke","aktie","apparat"};
	
	public	static void main(String[] args) {
		
		int in;
		
		for (;;){
			
			System.out.println("Kommandon:\n 1: Skapa person.\n 2: Skapa pryl.\n 3: Visa alla.\n 4: Visa rikaste.\n 5: Visa viss person.\n 6: Börs krasch.\n 7: Avsluta.");
			
			System.out.print("> ");
			try {
				in = Integer.parseInt(keyboard.nextLine());
			} catch(NumberFormatException e) {
				in = 0;
			}
			
			
			switch (in) {
			
				case 1:
					createUser();
					break;
				
				case 2:
					createItem();
					break;
					
				case 3:
					showAll();
					break;
					
				case 4:
					showRichest();
					break;
					
				case 5:
					showUser();
					break;
					
				case 6:
					stockExchangeCrash();
					break;
					
				case 7: keyboard.close(); System.exit(0);
				
				default: System.out.println("Felaktigt kommando.");
			}
			if (in >= 0 && in <= 7) waitUntilInput();
		}
	}
	
	private static void createUser() {
		boolean vacantName = false;
		String name = "";
		
		do {
			
			System.out.print("Ange namn: ");
			name = keyboard.nextLine();
			if (findUser(name) == null) {
				vacantName = true;
			} else {
				System.out.println("Det namnet är upptaget");
			}
		
		} while (!vacantName);
		
		User u = new User(name);
		allUsers.add(u);
		System.out.println("Operationen har lyckats!");
	}
	
	private static void createItem() {
		User targetUser = null;
		while (targetUser == null) {
			System.out.print("Vilken person äger prylen? ");
			targetUser = findUser(keyboard.nextLine());
			if (targetUser == null) {
				System.out.println("Hittar ingen med det namnet.");
			}
		}

		String type = "";
		boolean tmp = false;		// Get item type.
		while (tmp == false) {
			System.out.print("Vilken sorts pryl? ");
			type = keyboard.nextLine();
			for (int i=0; i<itemType.length; i++) {
				if (itemType[i].equals(type)) {
					tmp = true;
					break;
				}
			}
			if (!tmp) System.out.println("Detta program stödjer inte den prylen, försök med: "+itemType[0]+", "+itemType[1]+" eller "+itemType[2]);
		}
		
		System.out.print("Vad för sorts "+type+"? ");
		String n = keyboard.nextLine();
		
		switch (type) {
			case "smycke":
				String temp = "";
				boolean gold = false;
				while (!temp.equals("guld") || !temp.equals("silver")) {
					System.out.print("Är det guld eller silver? ");
					temp = keyboard.nextLine();
					if (temp.equals("guld")) { gold = true; break; }
					else if (temp.equals("silver")) { gold = false; break; }
					else System.out.println("Fel, skriv 'guld' eller 'silver'");
				}
				
				int gem = -1;
				while (gem < 0) {
					gem = askInt("Hur många ädelstenar? ","Du måste välja ett positivt heltal.");
				}
				targetUser.addItem(new Jewelry(n,gold,gem));
				break;
				
			case "aktie":
				double v = -1;
				while (v < 0) {
					try {
						System.out.print("Hur mycket är en aktie värd? ");
						v = Double.parseDouble(keyboard.nextLine());
					} catch (NumberFormatException e) {
						System.out.println("Du måste välja ett positivt tal.");
					}
					if (v < 0) System.out.println("Talet måste vara noll eller högre.");
				}
				int a = -1;
				while (a < 0) {
					a = askInt("Hur många aktier? ","Du måste välja ett positivt heltal.");
				}
				targetUser.addItem(new Share(n,v,a));
				break;
				
			case "apparat":
				System.out.print("Vad var inköpspriset? ");
				double value = -1;
				while (value < 0) {
					try {
						value = Double.parseDouble(keyboard.nextLine());
					} catch (NumberFormatException e) {
						System.out.println("Du måste skriva ett positivt tal.");
					}
					if (value < 0) System.out.println("Talet måste vara positivt.");
				}
				
				
				int w = -1;
				while (w < 0) {
					w = askInt("Hur sliten är den? (1 = jätte sliten, 10 = ny) ","Du måste välja ett positivt heltal.");
				}
				targetUser.addItem(new Device(n,value,w));
				break;
				
			}

		System.out.println("Operationen har lyckats!");
	}
	
	private static void showAll() {
		for (User u : allUsers) {
			System.out.println(u.getName()+"\t"+u.getValue()+" kr.");
		}
	}
	
	private static void showRichest() {
		if (allUsers.size() > 0) {
			User richest = null;
			Double value = 0.0;
			for (User u : allUsers) {
				if (u.getValue() > value) {
					richest = u;
					value = u.getValue();
				}
			}
			if (richest != null) System.out.println(richest.toString());
			else System.out.println("Ingen person äger något än.");
		}
		else System.out.println("Du måste skapa en person först.");
	}
	
	private static void showUser() {
		System.out.println("Vem vill du se? ");
		String name = keyboard.nextLine();
		User target = findUser(name);
		if (target == null) System.out.println("Hittar ingen användare med det namnet.");
		else System.out.println(target.toString());
	}
	
	private static void stockExchangeCrash() {
		for (User u : allUsers) {
			u.stockExchangeCrash();
		}
		System.out.println("Operationen har lyckats!");
	}

	
	private	static User findUser(String name) {

		
		for (User u : allUsers) {
			if (u.getName().equals(name)) {
				return u;
			}
		}
		return null;
	}
	
	private static int askInt(String question, String errorMessage) {
		int in = -1;
		try {
			System.out.print(question);
			in = Integer.parseInt(keyboard.nextLine());
		} catch (NumberFormatException e) {}
		if (in < 0) System.out.println(errorMessage);
		return in;
	}
	
	private static void waitUntilInput() {
		System.out.println("Tryck enter för att fortsätta.");
		keyboard.nextLine();
	}
	
}
