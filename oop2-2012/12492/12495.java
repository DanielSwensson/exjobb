package Inlupp2;

import java.util.*;

public class Main {

	static	ArrayList <Person> allPersons = new ArrayList<Person>();
	Scanner keyboard = new Scanner (System.in);

	int readInt (String question) {
		for (;;){
			try{
				System.out.print(question);
				int x=Integer.parseInt(keyboard.nextLine());
				return x;
			}
			catch (NumberFormatException e ){
				System.out.println("Fel - skall vara numeriskt värde");
			}
		}
	}
	double readDouble (String question) {
		for (;;){
			try{
				System.out.print(question);
				double x=Double.parseDouble(keyboard.nextLine());
				return x;
			}
			catch (NumberFormatException e ){
				System.out.println("Fel - skall vara numeriskt värde");
			}
		}
	}
	String readString (String question){
		System.out.print(question);
		String str=keyboard.nextLine();
		return str;
	}
	Person getPerson (String name){
		for (Person p : allPersons)
			if (p.getName().equalsIgnoreCase(name))
				return p;
		return null;
	}

	void createPerson() {
		String name = readString ("Nya personens namn: ");
		Person p = getPerson (name);
		if (p!=null)
			System.out.println("Den personen finns redan");
		else{
			Person newP = new Person (name);
			allPersons.add (newP);

		}
	}


	void createValuable() {

		String p1 = readString("Ange namn på personen som ska ha värdesaken: ");
		Person pp1 = getPerson (p1); 

		if (pp1== null){
			System.out.print("Personen finns inte");
		}
		else {

			int kom=readInt ("\n1-Registrera apparat\n2-Registrera smycke\n"+
					"3-Registrera aktie\nAnge Kommando: ");
			switch (kom){

			case 1:
				String deviceName = readString ("Namn på apparat: ");

				int price = readInt("Ange priset på apparaten: ");

				int wear = readInt("Ange hur sliten apparaten är (skala 0-10): ");

				Device newDevice  = new Device (deviceName, wear, price);

				pp1.addThing (newDevice);

				break;

			case 2:  
				String jewelryType = readString("Ange typ av smycke: ");

				String metal = readString("Är smycket av guld? (Ja/Nej)");

				System.out.print("Ange antal ädelstenar: ");
				int gemstone = Integer.parseInt(keyboard.nextLine());

				Jewelry	newJewelry  = new Jewelry (jewelryType, metal, gemstone);
				pp1.addThing (newJewelry);


				break;
			case 3:  
				String stockName = readString("Ange namn på aktieposten: ");

				int quantity = readInt("Ange hur många aktier som ska tilldelas: ");

				double stockPrice = readDouble("Ange pris på aktie: ");

				Stock	newStock  = new Stock (stockName, quantity, stockPrice);
				pp1.addThing (newStock);

				break;
			}
		}
	}

	void showAll() {
		for (Person p : allPersons)
			System.out.println(p.toString() +" " + p.getTotalWorth());

	}

	void showRichest() {
		double richest = 0;
		for (Person p: allPersons){
			if(p.getTotalWorth()>richest)
				richest=p.getTotalWorth();
		}
		for (Person p: allPersons){
		
			if (p.getTotalWorth() == richest){
				System.out.println(p.toString() +" äger sammanlagt "+ p.getTotalWorth());
				p.getAllValuables();
			}


		}

	}

	void showCertainPerson () {
		String p1 = readString("Ange namn på den person du söker: ");
		Person pp1 = getPerson (p1); 
		if (pp1== null){
			System.out.print("Personen finns inte");
		}
		for (Person p : allPersons)
		{
			if (p.getName() .equalsIgnoreCase (p1)) {
				System.out.println("\n"+p.toString()+" äger sammanlagt "+ p.getTotalWorth());
				p.getAllValuables();

			}
		}	
	}

	void createStockMarketCrash() {
		for (Person p : allPersons){
			p.stockMarketCrash();
		}
		System.out.println("Alla nuvarande aktier har blivit värdelösa");
	}

	void terminateProgram() {
		System.exit(0);
	}

	public static void main(String[] args) {

		Main mp = new Main();
		System.out.println("Hej och välkommen till Prylprogrammet");
		for(;;){
			int choice=mp.readInt("\nAnge kommando 1-7:\n1.Registrera person\n2.Registrera värdesak\n3.Visa alla\n4.Visa rikaste\n5.Visa viss person\n6.Starta börskrasch\n7.Avsluta ");
			switch (choice){
			case 1: mp.createPerson(); break;
			case 2: mp.createValuable(); break;
			case 3: mp.showAll(); break;
			case 4: mp.showRichest(); break;
			case 5: mp.showCertainPerson(); break;
			case 6:	mp.createStockMarketCrash(); break;
			case 7: mp.terminateProgram(); break;

			}
		}

	}
}
