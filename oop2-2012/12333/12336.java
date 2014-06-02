import java.util.*;

public class MainProgram {
	
	static Scanner keyboard = new Scanner(System.in);
	static ArrayList<Person> person = new ArrayList<Person>();
	
	static Person richest = null;
	
	int readInt(String question){
		for(;;){
			try{
				System.out.print(question);
				int x = Integer.parseInt(keyboard.nextLine());
				if(x < 0){
					System.out.println("\nSiffran får ej vara negativ!");
				}
				else if(x >= 0){
					return x;
				}
			}
			catch (NumberFormatException e){
				System.out.println("\nFel, kommandot ska vara en siffra");
			}
		}
	}
	
	double readDouble(String question){
		for(;;){
			try{
				System.out.print(question);
				double y = Double.parseDouble(keyboard.nextLine());
				if(y < 0){
					System.out.println("\nSiffran får ej vara negativ!");
				}
				else if(y >= 0){
					return y;
				}
			}
			catch (NumberFormatException e){
				System.out.println("\nFel, kommandot ska vara en siffra");
			}
		}
	}

	Person getPersonByName(String name){
		for(Person p: person){
			if(p.getName().equalsIgnoreCase(name)){
				return p;	
				
			}
			
		}
		
		return null;
	}
	
	void createJewelry(Person p){
		
		int metal = 0;
		
		System.out.print("\nVilken sorts smycke?: ");
		String kind = keyboard.nextLine();
		int stones = readInt("\nHur många ädelstenar har den?: ");
		

		
		for(;;){
			System.out.print("\nÄr smycket av guld?Ja/Nej: ");
			String answer = keyboard.nextLine();
			
			if(answer.equalsIgnoreCase("ja")){
				metal = 2000;
				break;
				
			}if(answer.equalsIgnoreCase("nej")){
				metal = 700;
				break;
				
			}else{
				System.out.println("\nFel svar, försök igen!");
			}
		}
		 
		Thing t = new Jewelry(kind , stones, metal);
		
		p.addThing(t);
		
		System.out.println("\nSmycke tillagt");
		
	}
	
	void createStock(Person p){
		
		System.out.print("\nVad är namnet på aktien du vill köpa?: ");
		String name = keyboard.nextLine();
		
		double worthPerStock = readDouble("\nVad är värdet per aktie?: ");
		
		int amount = readInt("\nHur många vill du köpa?: ");

		Thing s = new Stock(name, worthPerStock, amount);
		
		p.addThing(s);
		
		System.out.println("\nAktie tillagd!");
		
	}
	
	void createDevice(Person p){
		
		int wear = 0;
		
		System.out.print("\nVilken sorts apparat?: ");
		String kind = keyboard.nextLine();
		double price = readDouble("\nVad är inköpsvärdet på apparaten?: ");
		
		for(;;){
			try{
				System.out.print("\nVad är slitagevärdet på apparaten mellan 1-10?: ");
				int initialWear = Integer.parseInt(keyboard.nextLine());
			
				if(initialWear>=1 && initialWear<=10){
					wear = initialWear;
					break;
				}else{
					System.out.println("\nFelaktig siffra, försök igen!");
				}
			}catch (NumberFormatException e){
				System.out.println("\nFel, kommandot ska vara en siffra\n");
			}
		}

		
		Thing d = new Device(kind, price, wear);
		
		p.addThing(d);
		
		System.out.println("\nApparat tillagd!");
		
	}
	
	void createPerson(){
		
		System.out.print("\nSkriv in personens namn: ");
		String name = keyboard.nextLine();
		
		int count = 0;
		for(int n = 0 ; n < person.size(); n++){
			if (person.get(n).getName().equalsIgnoreCase(name)){
				System.out.println("Det finns redan en person med det namnet.\n");
				count++;
			}
			
		}
		if(count==0){				
		
			Person p = new Person (name);
			
			person.add(p);
			
			System.out.println("\nPersonen är tillagd i systemet!\n");
			
		}
	}
	
	void createThing(){
		
		System.out.print("\nVilken person ska äga prylen?: ");
		String owner = keyboard.nextLine();
		
		Person p = getPersonByName(owner);
		
		int type=0;
		if(p!=null){
			do{
				type = readInt("\nVilken sorts pryl?\n\n1 Smycke\n2 Aktie\n3 Apparat\n4 Gå till huvudmenyn\n\n- ");
				switch (type){
				case 1: createJewelry(p);
					break;
				case 2: createStock(p);
					break;
				case 3: createDevice(p);
					break;
				case 4:System.out.println();
					break;
				default: System.out.println("\nFel kommando\n");
				}
			}while(type!=4);
			
			if(richest == null){
				richest = p;
			}else if(p.getTotalValue() > richest.getTotalValue()){
				richest = p;
			}
			
		}else{
			System.out.println("\nDet finns ingen person med det namnet!\n");
		}
					
	}
	
	void showAll(){
		
		Person q;
		
		for(int n = 0 ; n < person.size() ; n++){
			q = person.get(n);
			System.out.println(q.getName() + "     " + q.getTotalValue());
		}
		
		System.out.println();
		
	}
	
	void showRichest(){
		
		if(richest != null){
			System.out.println("\nDen person som är rikast är " + richest.toStringRichest());
		}
		else{
			System.out.println("\nDet finns ingen person som har några värdesaker. \n");
		}
		
	}
	
	void showCertainPerson(){
		
		System.out.print("\nVilken person vill du visa?:");
		String specPerson = keyboard.nextLine();
		
		for(int n = 0 ; n < person.size() ; n++){
			if(person.get(n).getName().equalsIgnoreCase(specPerson)){
				System.out.print(person.get(n).getPerson() + "\n");
				return;
			}
		}
		System.out.println("\nDet finns ingen person med det namnet\n");
		
	}
	
	void marketCrash(){
		
		for(Person r : person){
			r.marketCrash();
			for(Person y : person){
				if( y.getTotalValue() > richest.getTotalValue()){
					richest = y;
				}
			}
		}
		System.out.println("\nMarknaden har kraschat och nollställt alla befintliga aktier!\n");
		
	}

	public static void main(String[] args) {
		
		MainProgram mp = new MainProgram();
		System.out.println("Hej och välkommen till prylprogrammet!\n");
		for(;;){
			int choice = mp.readInt("Vad vill du göra?\n\n1 Skapa person\n2 Skapa pryl\n3 Visa alla\n4 Visa rikaste\n5 Visa en viss person\n6 Börskrasch\n7 Avsluta\n\n- ");
			switch (choice){
			case 1: mp.createPerson();
				break;
			case 2: mp.createThing();
				break;
			case 3: mp.showAll();
				break;
			case 4: mp.showRichest();
				break;
			case 5: mp.showCertainPerson();
				break;
			case 6: mp.marketCrash();
				break;
			case 7: System.exit(0);
			
			default: System.out.println("Fel kommando, försök igen!");
			
			
			}
		}

	}

}
