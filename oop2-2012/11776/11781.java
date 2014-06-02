import java.util.*;
public class MainProgram {

	private static ArrayList<Person> allPeople = new ArrayList<Person>();
	Scanner keyboard = new Scanner(System.in);

	double readDouble(){
		for(;;){
			try{
				double x=Double.parseDouble(keyboard.nextLine());
				return x;
			}
			catch (NumberFormatException e){
				System.out.println("Fel - skall vara numeriskt värde");
			}
		}
	}
	
	int readInt(){
		for(;;){
			try{
				int x=Integer.parseInt(keyboard.nextLine());
				return x;
			}
			catch (NumberFormatException e){
				System.out.println("Fel - skall vara numeriskt värde");
			}
		}
	}

	String readString(String question){
		System.out.print(question);
		String str = keyboard.nextLine();
		return str;
	}

	private static Person getPerson(String name){
		for (Person p : allPeople)
			if (p.getName().equalsIgnoreCase(name))
				return p;

		return null;
	}
	
	private void createPerson(){
		String name = readString("Skriv ett nytt namn: ");
		Person p = getPerson(name);
		if (p!= null)
			System.out.println("Personen finns redan");
		else{
			Person recent = new Person(name);
			allPeople.add(recent);
		}
	}
	
	private void createThing(){
		System.out.print("Vem äger prylen?: ");
		String p1 = keyboard.nextLine();

		Person p = getPerson(p1);

		if (p != null)
		{	
			System.out.print("Vad vill du registera?\n1.Smycke:\n2.Aktie:\n3.Apparat: ");
			int choice = readInt();

			switch(choice){
			case 1: System.out.print("Vilket sorts smycke är det?: ");
			String type = keyboard.nextLine();
			System.out.print("Är smycket guld?: ");
			String metal = keyboard.nextLine();
			System.out.print("Antal ädelstenar?: ");
			int numberOfGems = readInt();

			Jewel j = new Jewel(type,numberOfGems,metal);
			p.addThing(j);
			break;

			case 2: System.out.print("Namnet på aktien?: ");
			String stockName = keyboard.nextLine();
			System.out.print("Hur många aktier?: ");
			int numberOfStock = readInt();
			System.out.print("Pris per aktie?: ");
			double price = readDouble();

			Stock s = new Stock(stockName,numberOfStock,price);
			p.addThing(s);
			break;

			case 3:System.out.print("Vad för apparat är det?: ");
			String deviceName = keyboard.nextLine();
			System.out.print("Vad var inköpspriset?: ");
			double purchasePrice = readDouble();
			System.out.print("Vilket slitage har den? Skala 1-10, där 10 är ny osv: ");
			int wear = readInt();
			while (wear<1 || wear>10){
				System.out.print("Det måste vara ett tal mellan 1-10 ");
				wear = readInt();
			}

			Device d = new Device(deviceName,purchasePrice,wear);
			p.addThing(d);
			break;

			}
		}else{ System.out.print("Personen finns inte");
		}
	}
	
	private void showAll(){
		for (int i=0; i<allPeople.size(); i++){
			Person person = allPeople.get(i);
			System.out.println(person.getName() +" har ett värde på "+ person.getTotalValue());	    	
		}


	}
	
	private void showWelthiest(){
		Person richestPerson = null;

		for(int i = 0; i<allPeople.size(); i++){
			Person person = allPeople.get(i);
			if(richestPerson == null || person.getTotalValue() > richestPerson.getTotalValue()){
				richestPerson = person;
			}
		}
		System.out.println(richestPerson.getName()+" som sammanlagt äger "+ richestPerson.getTotalValue());
		richestPerson.printCollection();

	}

	private void showSpecificPerson(){
		System.out.print("Vilken person söker du?: ");
		String name = keyboard.nextLine();
		Person searchedPerson = null;

		for (int i = 0; i<allPeople.size(); i++){	
			if (allPeople.get(i).getName() .equalsIgnoreCase(name)){
				searchedPerson = allPeople.get(i);
			}
		}

		if (searchedPerson != null){
			System.out.println(searchedPerson.getName()+" "+searchedPerson.getTotalValue());
			searchedPerson.printCollection();

		}else{
			System.out.println("Personen finns inte");
		}
	}

	private void stockMarketCrash(){                                                 
		for (Person i : allPeople){                                             
			i.stockMarketCrash();                                              

		}                                                                      
		System.out.println("Börskrasch! Alla aktier är nu värdelösa!");
	}                                                                      

	public static void main (String [] args){
		MainProgram mp = new MainProgram();
		System.out.println("Hej och välkommen till Prylprogrammet!");
		for(;;){
			System.out.print("\nAnge kommando 1-7:\n1.Skapa person:\n2.Skapa pryl:\n3.Visa alla:" +
					"\n4.Visa rikaste:\n5.Visa viss person:\n6.Börskrasch:\n7.Avsluta:\nAnge kommando: ");
			int choice = mp.readInt();

			switch (choice){
			case 1: mp.createPerson(); break;
			case 2: mp.createThing(); break;
			case 3: mp.showAll(); break;
			case 4: mp.showWelthiest(); break;
			case 5: mp.showSpecificPerson(); break;
			case 6: mp.stockMarketCrash(); break;
			case 7: System.out.println("Tack för den här gången!");
			System.exit(0);
			default: System.out.println("Fel kommando");

			}
		}
	}

}


