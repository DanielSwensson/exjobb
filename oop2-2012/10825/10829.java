
//	OOP Inl�mningsuppgift 2
//	Prylregister
//	Jonas Ask , 760818-0035
	

import java.io.*;	
import java.util.*;

public class RegistryOfValueables {
	ArrayList<Person> allPersons = new ArrayList<Person>();
	private static Scanner keyboard = new Scanner(System.in);
	
	private static int readInt(String str){
		for(;;){
			try{
				System.out.print(str);
				int num = Integer.parseInt(keyboard.nextLine());
				return num;
			}
			catch(NumberFormatException e){
				System.out.println(" Du m�ste mata in ett heltal!");
			}
		}

	}

	private static double readDouble(String str){
		for(;;){
			try{
				System.out.print(str);
				double num = Double.parseDouble(keyboard.nextLine());
				return num;
			}
			catch(NumberFormatException e){
				System.out.println(" Du m�ste mata in ett tal!");
			}
		}

	}
	
	private static String readString(String str){
		System.out.print(str);
		String strx = keyboard.nextLine();
		return strx ;
	}

	private void getSavedFile(){
		try{
			FileInputStream fil = new FileInputStream("prylar.obj");
			ObjectInputStream in = new ObjectInputStream(fil);
			allPersons = (ArrayList<Person>) in.readObject();
			}
			catch(FileNotFoundException e) {}
			catch(IOException e) {System.exit(1);}
			catch(ClassNotFoundException e) {System.exit(2);}
	}
	
	private void addPerson(){ //L�gg till snubbe i registret	OK
		boolean found;
		String name;
		do{
			found = false;
			name = readString(" Ange personens namn : ");
			for(Person p : allPersons){
				if(p.getName().equalsIgnoreCase(name)){
					System.out.println(" Det finns redan en person med det namnet");
					found = true;
					break;								
				}
			}
			if(!found){
				Person newp = new Person(name);
				allPersons.add(newp);
				addStuffToPerson(newp);
			}
		}while(found);	
	}
	

	private void deletePerson(){ //Radera snubbe fr�n registret	Ok

		if(allPersons.isEmpty()){
			System.out.println(" Registret inneh�ller f�r n�rvarande inga personer");
		} else {
			for(Person p : allPersons){
				System.out.println(" "+(1+allPersons.indexOf(p)) + " = " + p.getName());
			}
			boolean ok = false;
			do{
				int who = readInt(" Ange numret f�r den person du vill radera : ");
					if(who > 1 && who <= allPersons.size() ){
						ok = true;
						allPersons.remove(who-1);
			}else
						System.out.println(" Var v�nlig och skriv in en siffra mellan 1 och " + allPersons.size());
			}while(!ok);
			
		}		
	}
	
	private void addStuff(){	//L�gg till pryl till snubbe	OK
		boolean found = false;
		if(allPersons.isEmpty()){
			System.out.println(" Registret inneh�ller f�r n�rvarande inga personer");
		} else {
			String name = readString(" Till vem vill du l�gga till prylar ? : ");
			for(Person p : allPersons){
				if(p.getName().equalsIgnoreCase(name)){
					found = true;
					addStuffToPerson(p);
				}
			}
			if(!found)
				System.out.println(" Finns ingen med det namnet i registret...");
		}
	}
	
	private void addStuffToPerson(Person p){	//L�gga till pryl till snubbe, delmetod	OK
		boolean keepAdding = true;
		do{
			System.out.println(" Dessa olika sorters prylar kan du l�gga till:"
					+"\n 1) Aktie\t 2) Apparat\n 3) Smycke\t 4) F�rdig");
			int type = readInt(" Vilken pryl vill du l�gga till : ");
			switch(type){
			case 1 : 
				String stockName = readString(" Ange Aktiens namn : ");
				int amount = readInt(" Ange antal : ");
				double stockPrice = readDouble(" Ange pris : ");
				p.addThing(new Stock(stockName,amount,stockPrice));
				break;
			case 2 :
				String gadgetName = readString(" Ange Apparatens namn : ");
				int gadgetPrice = readInt(" Ange ink�pspris : ");
				int gadgetWear = readInt(" Ange hur sliten apparaten �r 0=ny, 100=redo f�r soptippen : ");
				p.addThing(new Gadget(gadgetName,gadgetPrice,gadgetWear));
				break;
			case 3 :
				String jewelleryName = readString(" Ange typ av smycke : ");
				String jewelleryMaterial = readString(" Ange smyckets material : ");
				int jewelleryGems = readInt(" Ange antal �delstenar : ");
				p.addThing(new Jewellery(jewelleryName,jewelleryMaterial,jewelleryGems));
				break;
			case 4 :
				keepAdding = false;
				break;
			default :
					System.out.print(" Ogiltigt alternativ, f�rs�k igen");
			}
		}while(keepAdding);
	}
		
	private void deleteStuff(){	// Radera pryl fr�n snubbe	OK
		boolean found = false;
		if(allPersons.isEmpty()){
			System.out.println(" Registret inneh�ller f�r n�rvarande inga personer");
		} else {
			String name = readString(" F�r vem vill du ta bort prylar ? : ");
			for(Person p : allPersons){
				if(p.getName().equalsIgnoreCase(name)){
					found = true;
					System.out.println(" "+ p.getName() +" �ger f�ljande saker : ");
					p.listStuff();
					int thing = readInt(" Vad vill du ta bort? : ");				
					p.deleteThing(thing-1);
				}
			}
			if(!found)
				System.out.println(" Finns ingen med det namnet i registret...");		
		}
	}

	private void showPerson(){	// Visa viss snubbe	 OK
		
		boolean found = false;
		if(allPersons.isEmpty()){
			System.out.println(" Registret inneh�ller f�r n�rvarande inga personer");
		} else {
			String name = readString(" Ange personen du vill visa : ");
			for(Person p : allPersons){
				if(p.getName().equalsIgnoreCase(name)){
					found = true;
					System.out.print("\n "+ p.getName() +" �ger f�ljande saker : ");
					p.listStuffAll();
				}
			}
			if(!found)
				System.out.println(" Finns ingen med det namnet i registret...");
		}
	}	

	private void showAllPerson(){	// Visa alla snubbar	OK
		if(allPersons.isEmpty())
			System.out.println(" Registret inneh�ller f�r n�rvarande inga personer");
		else{
			for(Person p : allPersons)
				System.out.println("\n " + p.getName()+ " �ger saker till ett v�rde av : " + p.getSum() + "kr");
		}
	}
	
	private void showRichest(){	// Visa rikaste 	OK
		Person tmp = new Person("tmp");
		for(Person p : allPersons){
			if(p.getSum() > tmp.getSum())
				tmp = p;
		}
		System.out.println("\n " + tmp.getName()+ " �r rikast och �ger f�ljande prylar :\n");
		tmp.listStuffAll();
	}
	
	private void marketCrash(){	//B�rskrasch 	Ok
		for(Person p : allPersons)
			p.stockCrash();
		System.out.println(" Aj Aj Aj! B�rsen kraschade, alla aktier �r v�rdel�sa...");
	}
	
	private void quit(){		// Avsluta	OK
		try{
			FileOutputStream fil = new FileOutputStream("prylar.obj");
			ObjectOutputStream out = new ObjectOutputStream(fil);
			out.writeObject(allPersons);
		}
		catch(IOException e){
			System.exit(1);
		}
		System.exit(0);
	}
	
	public static void main(String[] args) {
		RegistryOfValueables pr = new RegistryOfValueables();
		int action;
	
		pr.getSavedFile();
		
		System.out.println("\n V�lkommen till Prylregistret");

		for(;;){
			
			action = readInt("\n 1) Registrera person" +
					"\t 2) Ta bort person\n 3) Registrera pryl" +
					"\t 4) Ta bort pryl fr�n person\n 5) Visa viss person" +
					"\t 6) Visa alla \n 7) Visa rikaste   " +
					"\t 8) B�rskrasch \n 9) Avsluta\n\n Vad vill du g�ra? : ");			
			switch(action){
				case 1:
					pr.addPerson();
					break;
				case 2:
					pr.deletePerson();
					break;
				case 3:
					pr.addStuff();
					break;
				case 4:
					pr.deleteStuff();
					break;
				case 5:
					pr.showPerson();
					break;
				case 6:
					pr.showAllPerson();
					break;
				case 7:
					pr.showRichest();
					break;
				case 8:
					pr.marketCrash();
					break;
				case 9:
					pr.quit();
				default:System.out.println("Felaktigt kommando...");
		
			}

		}
		
	}

}
