import java.util.*;

class Register {
	
	static ArrayList<Person> persons = new ArrayList<Person>();
	ArrayList<Person> richestPersons=new ArrayList<Person>(); 
	
	 
	static Scanner in = new Scanner(System.in);
	
	Person newPerson = new Person(); 
	Person person = null; 
	
	
 
	public static void main(String args[]) {
		while(true) {
			printMenu();
		}
	}
 
	public static void printMenu() {
		System.out.print("Meny:\n\n");
 
		System.out.println("1.\tSkapa person");
		System.out.println("2.\tSkapa pryl");
		System.out.println("3.\tVisa alla");
		System.out.println("4.\tVisa rikaste");
		System.out.println("5.\tVisa viss person");
		System.out.println("6.\tBörskrasch");
		System.out.println("0.\tAvsluta");
 
		registerChoice();
	}

// Menu samt vad som ska finnas dÃ¤r och att systemet ska registrera valen man gÃ¶r 

	public static void registerChoice() {		
		int command = 0;
		boolean ok;
 
		do {
			ok = true;
			try {
				System.out.print("Val: ");
				command = Integer.parseInt(in.nextLine());
			}
			catch (NumberFormatException e) {
				System.out.println("Fel - Val måste vara ett nummer");
				ok = false;
			}
		} while(!ok);
 
 
		switch(command) {
			case 0:
				// Exit program
				System.exit(0);
				break;
			case 1:
				// Register person
				registerPerson();
				break;
			case 2:
				// Register varden
				registerVarden();
				break;
			case 3:
				// Show all
				showAll();
				break;
			case 4:
				// Show richest
				showRichest();
				break;
			case 5:
				// Show certain person
				showPerson();
				break;
			case 6:
				// Lager market crash
				marketCrash();
				break;
		}
 
	}
 
	/*****
	Register person
	******/
	
	public static void registerPerson() {		
		System.out.print("Ange namn: ");
 
		String name = in.nextLine();
		Boolean exists = false;
 
		for(int i = 0; i < persons.size(); i++) {
			if(persons.get(i).getName().equalsIgnoreCase(name)) {
				System.out.println("En person med det namnet finns redan");
				exists = true;
			} else {
				exists = false;
			}
		}

		if(!exists) {
			Person newPerson = new Person();
			newPerson.setName(name);
			persons.add(newPerson);
		}
 
	}
	/*****
	Register varden
	******/
	public static void registerVarden() {		
		System.out.print("Vilken person Äger prylen: ");
 
		Person person = null;
		Boolean exists = false;
		String name = in.nextLine();
 
		for(int i = 0; i < persons.size(); i++) {
			if(persons.get(i).getName().equalsIgnoreCase(name)) {
				exists = true;
				person = persons.get(i);
				break;
			} else {
				exists = false;
			}
		}
 
		if(!exists) {
			System.out.println("Personen du angett finns inte i systemet");
			return;
		}
 
		System.out.print("Vilken sorts pryl: ");
		String varden = in.nextLine();
		 
		if(varden.equalsIgnoreCase("Smycke")) {
			System.out.print("Vilket sorts smycke: ");
 
			String SmyckeType = in.nextLine();
 
			System.out.print("Är smycket av guld (Ja/Nej): ");
 
			String gold = in.nextLine();
			int gemstones = 0;
			Boolean ok;
 
			do {
				ok = true;
				try {
					System.out.print("Antal Ädelstenar: ");
 
					gemstones = Integer.parseInt(in.nextLine());
				}
				catch (NumberFormatException e) {
					System.out.println("Fel - Ädelstenar måste vara ett tal");
					ok = false;
				}
			} while(!ok);
 
			Varden Smycke = new Smycke(SmyckeType, gemstones, gold.equalsIgnoreCase("Ja") ? true : false);
 
			person.addVarden(Smycke);
 
			return;
		} // If Smycke
 
		if(varden.equalsIgnoreCase("Aktie")) {
			System.out.print("Aktiens namn: ");
 
			String Aktiename = in.nextLine();
 
			int price = 0, number = 0;
			boolean ok;
 
			do {
			ok = true;

			try {
				System.out.print("Anskaffnings-kurs: ");
				price = Integer.parseInt(in.nextLine());
			}
			catch (NumberFormatException e) {
				System.out.println("Fel - Anskaffnings-kurs måste vara ett tal");
				ok = false;
			}
		} while(!ok);

		do {
		ok = true;
			try {
				System.out.print("Antal: ");
				number = Integer.parseInt(in.nextLine());
			}
			catch (NumberFormatException e) {
				System.out.println("Fel - Antal måste vara ett tal");
				ok = false;
			}
		} while(!ok);

		Varden Aktie = new Aktie(Aktiename, number, price);

		person.addVarden(Aktie);

		return;
	} // If Aktie

	if(varden.equalsIgnoreCase("Apparat")) {
		System.out.print("Apparatens namn: ");

		String sakname = in.nextLine();

		int price = 0, wear = 0;
		boolean ok;

		do {
			ok = true;
			try {
				System.out.print("Inköpspris: ");
				price = Integer.parseInt(in.nextLine());
			}
			catch (NumberFormatException e) {
				System.out.println("Fel - Inköpspris måste vara ett tal");
				ok = false;
			}
		} while(!ok);

		do {
			ok = true;
			try {
				System.out.print("Slitage (0-10): ");
				wear = Integer.parseInt(in.nextLine());
			}
			catch (NumberFormatException e) {
				System.out.println("Fel - Slitage måste vara ett tal");
				ok = false;
			}
		} while(!ok);

		Varden sak = new Sak(sakname, price, wear);

		person.addVarden(sak);

	} // If apparat
}

public static void showAll() {
	System.out.println("I registret finns:");

	for(int i = 0; i < persons.size(); i++) {
		System.out.println(persons.get(i).getName() + "\t" + persons.get(i).getTotalWelth());
	}
}

public static void showRichest(){
ArrayList<Person> richestPersons=new ArrayList<Person>();

richestPersons.addAll(persons);

Collections.sort(richestPersons);


System.out.println(richestPersons.get(0));
}
	


public static void showPerson() {
	
	System.out.print("Ange namn: ");
	boolean exists = false;

	String name = in.nextLine();

	for(int i = 0; i < persons.size(); i++) {
		if(persons.get(i).getName().equalsIgnoreCase(name)){
			System.out.println(persons.get(i).getInfo());
			exists = true;
			break;
		}
	
	}
	

	if(!exists)
		System.out.println("Personen du angett finns inte i systemet");
}

public static void marketCrash() {
	for(int i = 0; i < persons.size(); i++) {
		Person person = persons.get(i);

		for(int j = 0; j < person.getValuables().size(); j++) {
			Varden Varden = person.getValuables().get(j);

			if(Varden instanceof Aktie)
				Varden.setValue(0);
		}
	}
}



			
		}

