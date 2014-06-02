package Inlupp2;

import java.util.Scanner;
import java.util.ArrayList; 

public class ValueRegister { 
	ArrayList <Person> personregister = new ArrayList <Person> ();
	Scanner keyboard = new Scanner (System.in);

	int readInt (String question) {
		for(;;) {
			try {
				System.out.print(question); 
				int x=Integer.parseInt(keyboard.nextLine()); 
				return x; 
			}
			catch (NumberFormatException e) {
				System.out.println("Fel - skall vara numeriskt värde"); 
			}
		}	
	}

	String readString (String question) {
		System.out.println (question); 
		String str = keyboard.nextLine(); 
		return str; 
	}

	Person getPerson(String name) {
		for (Person p : personregister)
			if (p.getName().equalsIgnoreCase(name))
				return p; 
		return null; 
	}

	void createPerson() {

		System.out.println("Skriv in namnet på personen du vill lägga till: "); 
		String name = keyboard.nextLine(); 
		Person p = getPerson(name);
		if (p!=null)
			System.out.println("Den personen finns redan"); 
		else {
			Person pr = new Person (name); 
			personregister.add(pr); 

		}

	}

	void createItem() { 

		System.out.println("Lägg till pryl"); 
		System.out.println(""); 

		String ownerName = readString("Vilken person äger prylen: "); 
		Person p = getPerson(ownerName);
		
		if (p == null) { 
			System.out.println("Personen finns inte"); 
		}
		
		if(p != null){
				
			System.out.println("Vilken sorts pryl vill du lägga till? (Aktie, Smycke eller Apparat): ");
				String appliances = keyboard.nextLine(); 

				if(appliances.equals("smycke")) {
				
					int goldMaterial = 0; 
					
					String typeOfJewelery = readString("Vilken sorts smycke: "); 

					String material = readString("Är smycket av guld (Ja eller Nej): "); 
					
					if (material.equalsIgnoreCase("ja")) {
						goldMaterial = 2000;  
					} else {
						goldMaterial = 700; 
					} 
					
					int amountOfStones = readInt("Antal ädelstenar: ");

					Item i = new Jewelery (typeOfJewelery, goldMaterial, amountOfStones); 
					p.addItem(i); 
					
				} else if (appliances.equals("aktie")) {

					String stockName = readString("Vad heter aktien?"); 
 
					int stockValue = readInt("Vad är värdet på din aktie?"); 

					int amountOfStocks = readInt("Ange hur många aktier du har:"); 

					Shares s = new Shares (stockName, amountOfStocks, stockValue); 
					p.addItem(s); 
					
				} else if (appliances.equals("apparat")){
					
					String applianceName = readString("Vad är det för appart du vill lägga till? (TV, Dator etc)"); 
					
					int applianceValue = readInt("Ange inköpspris för din apparat:"); 

					int wear = readInt("Ange på en skala 1/10 slitaget på din apparat. 10 är som ny, 1 är väldigt dålig kondition."); 

					Appliances a = new Appliances (applianceName, applianceValue, wear); 
					p.addItem(a); 
				}	
			}	
		}

	


	void showAll () { 
		  
			for(Person p : personregister) {
				System.out.println(p.getName() + " " + p.totalItemValue()); 
			}
	}

	void showRichest() { 
		
		boolean found = false; 
		Person p = new Person("x"); 
		for(int sr = 0; sr < personregister.size(); sr++) {
			if (personregister.get(sr).totalItemValue() > p.totalItemValue()) {
				p = personregister.get(sr); 
			}
		}
		System.out.println("Rikast är " + p.getName() + " som samanlagt äger \n" + p.listItemValue()); 
		System.out.println();  
	}

	void showSpecialPerson() { 
		
		String showName = readString("Vilken person vill du visa?");
		
		boolean found = false; 
		for (int sp = 0; sp < personregister.size(); sp++) {
			if (personregister.get(sp).getName().equals(showName)) {
				
				found = true; 
				
				System.out.println(personregister.get(sp).getName() + " " + personregister.get(sp).getItemList() + " Totala värdet på samtliga prylar: " + personregister.get(sp).totalItemValue()); 
			}
			
			System.out.println(""); 
			if (!found) {
				System.out.println("Personen du angav finns inte i systemet."); 
			}
				
		}
	}

	void stockMarketCrash() {  

		for (Person p : personregister) {
			ArrayList<Item> appliancesreg = p.getItemList(); 
			for (Item i : appliancesreg) { 
				if (i instanceof Shares)
				
				((Shares) i).stockValue(0);
			}
		}
	}


	public static void main (String[] args) {
		ValueRegister mp = new ValueRegister ();
		System.out.println("VŠlkommen till Prylprogramet!"); 
		for(;;) {

			System.out.println("Skriv in siffra mellan 1-7 utefter vad du vill gšra:"); 
			System.out.println(""); 
			System.out.println(1+": Skapa person"); 
			System.out.println(2+": Skapa pryl");  
			System.out.println(3+": Visa alla");  
			System.out.println(4+": Visa rikaste");  
			System.out.println(5+": Visa viss person");  
			System.out.println(6+": Börskrasch");  
			System.out.println(7+": Avsluta");  

			int choice = mp.readInt(""); 

			switch (choice) { 

			case 1: 
				mp.createPerson(); 
				break; 

			case 2: 
				mp.createItem();  
				break;

			case 3: 
				mp.showAll();  
				break;

			case 4: 
				mp.showRichest();  
				break;

			case 5: 
				mp.showSpecialPerson();  
				break;

			case 6: 
				mp.stockMarketCrash();  
				break;

			case 7: System.out.println("Hejdå! ");  
			System.exit(0); 

			default: System.out.println("Fel kommando"); 

			}
		}
	}

}
