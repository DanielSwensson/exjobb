import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Main things = new Main();
		things.main();
	}
	private ArrayList<Person> all = new ArrayList<Person>();
	Scanner sc = new Scanner(System.in);
	
	public int readInt(String question){
		
		for(;;){
			try{;
				boolean done = false;
				while(!done){
					System.out.println(question);
					int x=Integer.parseInt(sc.nextLine());
					if (x<0){
						System.out.println("Skriv ett tal st�rre �n 0.");
					}else{
						done = true;
						return x;
					}
				}
			}
			catch (NumberFormatException e){
				System.out.println("Du m�ste anv�nda dig utav siffror.");
			}
		}
	}

	public String readString (String question){
	
		System.out.println(question);
		String str=sc.nextLine();
		return str;
	}

	private Person getPerson (String name){ 
		
		for (Person p : all){
			if (p.getName().equalsIgnoreCase(name)){
				return p;
			}
		}
		return null;
		
			
	}

	public Person setRichest(){
		
		int highestValue = 0;
		Person richest = null;
		for(Person p : all){
				
			if(p.getPersonValue() > highestValue){
				highestValue = p.getPersonValue();
				richest = p;
			}
		}return richest;
		
	}
	
	private void createPerson(){
	
		String name = readString("Personens namn: ");
		Person p = getPerson(name);
		if (p!=null)
			System.out.println("Personen finns redan.");
		else{
			Person newPerson = new Person(name);
			all.add(newPerson);
		}
	}
	
	private void jewelryToPerson(String who){

		String name = readString("Vad �r det f�r sorts smycke?"); 
		
		boolean gold;
		for(;;){
			String svar = readString("�r det av guld eller silver?");
			if (svar.equalsIgnoreCase("guld")){
				gold = true;
				break;
			}else if(svar.equalsIgnoreCase("silver")){
				gold = false;
				break;
			}else{
				System.out.println("\nGuld eller silver!\n");
			}
		}
		int gemstones = readInt("Hur m�nga �delstenar?");
		
		getPerson(who).addThing(new Jewelry(name, gold, gemstones));  
		
	}
	private void shareToPerson(String who){
		
		String name = readString("Vad heter aktien? ");		
		int price = readInt("Styckpris p� aktien?");
		int amountShares = readInt("Hur m�nga aktier?");
		
		getPerson(who).addThing(new Shares(name, price, amountShares)); 
		
	}
	private void applianceToPerson(String who){
		
		String name = readString("Vilken sorts apparat?");
		int price = readInt("Ink�pspris?");
		int wear;
		do{
			wear = readInt("Slitage? (Ange siffra mellan 1-10, d�r 1 betyder extremt sliten och 10 betyder nyskick)");
			if(wear <1 || wear >10){
				System.out.println("Ange ett tal mellan 1 och 10.");				
			}
		}while(wear <1 || wear >10);
		
		getPerson(who).addThing(new Appliances(name, price, wear));
		
	}
	
	private void createThing(){
		
		String who;
		for(;;){
			who = readString("Vem ska f� prylen?");
			if (getPerson(who) != null){break;}
			else{
				System.out.println("Det finns ingen med det namnet i databasen. F�rs�k igen.");
				}
		}
		for(;;){

			
			int thingType = 0;
			thingType = readInt("Vilken typ av pryl �r det? \n1: Smycke \n2: Aktie \n3: Apparat.");
			
			if (thingType==1){
				jewelryToPerson(who); 
				break;
			}else if (thingType==2){
				shareToPerson(who); 
				break;
			}else if (thingType==3){
				applianceToPerson(who); 
				break;
			}else{
			System.out.println("Du m�ste v�lja alternativ 1, 2 eller 3.");
			}
		}
	}
	
	private void showAll(){
		System.out.println("Lista p� alla:");
		for (Person p : all){
			p.personAndValue();
		}
	}

	private void showRichest(){
		
		try{
			Person richest = setRichest();
			System.out.println(richest.getName() + " �r rikast p� listan som sammanlagt �ger prylar v�rda " + richest.getPersonValue() + " kr." );
			richest.personThings(richest);
		}catch(NullPointerException e){
			System.out.println("Ingen person �ger n�got av v�rde.");}
	}
	private void showCertain(){
		
		try{
			boolean test = false;
			while(test == false){
				String who = readString("Skriv personens namn.");
				if (getPerson(who) != null){
					getPerson(who).personThings(getPerson(who));
					test = true;
				}else{
					System.out.println("Det finns inte en person med det namnet i listan. F�rs�k igen. ");
				}
			}
		}catch(NullPointerException e){
			System.err.println("Fel - NullPointerException");
		}
	}

	private void smCrash(){	
	
		for(Person p : all){
		p.smCrashPerson();
		}
	}
	
	private void main() {
		
		System.out.println("Personers prylar");
		for(;;){
			int option = readInt("\n1: Skapa person\n2: Skapa Pryl\n3: Visa alla\n4: Visa rikaste\n5: Visa viss\n6: B�rskrasch" +
								"\n7: Avsluta\n\nV�lj 1-7: ");
			switch (option){
			case 1: createPerson(); break;
			case 2: createThing(); break;
			case 3: showAll(); break;
			case 4: showRichest(); break;
			case 5: showCertain(); break;
			case 6: smCrash(); break;
			case 7: System.out.println("P� �terseende!");
					System.exit(0); break;
			default: System.out.println("Fel\n"); break;
			}
			
			
		}
		
	}
	
	



}

