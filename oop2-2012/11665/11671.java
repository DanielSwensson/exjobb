import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class Valuables {
	static Scanner keyboard = new Scanner(System.in);
	private ArrayList<Person> allPersons = new ArrayList<Person>();

	public static void main(String[] args) {

		Valuables v = new Valuables();

// Read saved data
		try{
			FileInputStream file = new FileInputStream("Valuables.data");
			ObjectInputStream in = new ObjectInputStream(file);
			while (file.available() > 0){
				Person p = (Person)in.readObject();
				v.allPersons.add(p);
			}
			System.out.println("Data har lästs in, "+v.allPersons.size()+" person"+
					(v.allPersons.size()==1 ? "" : "er"));
		}
		catch (FileNotFoundException e){
			System.out.println("Inga indata hittades");
		}
		catch (IOException e){
			System.out.println(e);
			System.out.println("IO exception");
			System.exit(2);
		}
		catch (ClassNotFoundException e){
			System.out.println(e);
			System.out.println("Class not found");
			System.exit(3);
		}

// Command loop
		while(true){
			System.out.print("Kommandon är:");
			System.out.print(" 1=Skapa person,");
			System.out.print(" 2=Skapa objekt,");
			System.out.print(" 3=Visa alla,");
			System.out.print(" 4=Visa rikaste,");
			System.out.print(" 5=Visa viss person,");
			System.out.println(" 6=Börskrasch,");
			System.out.print("              7=Ta bort person");
			System.out.print(" 8=Ta bort objekt,");
			System.out.print(" 9=Ta bort alla,");
			System.out.println(" 10=Avsluta");
			int command = readInt("Ange kommando (1-10): ");
			switch (command) {
				case 1:
					v.createPerson();
					break;
				case 2:
					v.createThing();
					break;
				case 3:
					v.showAllPersons();
					break;
				case 4:
					v.showRichestPerson();
					break;
				case 5:
					v.showOnePerson();
					break;
				case 6:
					v.crashStockMarket();
					break;
				case 7:
					v.removePerson();
					break;
				case 8:
					v.removeThing();
					break;
				case 9:
					v.removeAllPersons();
					break;
				case 10:
// Save data and exit
					try{
						FileOutputStream file = new FileOutputStream("Valuables.data");
						ObjectOutputStream out = new ObjectOutputStream(file);
						for(Person p : v.allPersons){
							out.writeObject(p);
						}
						System.out.println("Data har sparats");
					}
					catch (IOException e){
						System.out.println(e);
						System.out.println("IO exception");
						System.exit(1);
					}

					System.out.println("Programmet avslutas");
					System.exit(0);
					break;
// Wrong command given
				default:
					System.out.println("Fel kommando, försök igen");
			}
		}
	} // main()
	
	void createPerson(){
		String name = readString("Ange namn: ");
		boolean thisPersonIsNew = true;
		for(Person p : allPersons){
			if(name.equalsIgnoreCase(p.getName())){
				thisPersonIsNew = false;
			}
		}
		if(thisPersonIsNew){
			allPersons.add(new Person(name));
			System.out.println("Ny person skapad: "+name);
		} else {
			System.out.println("Personen finns redan!");
		}
		return;
	} // createPerson()

	void createThing(){
		if(allPersons.size() > 0){
// Ask for owner
			boolean noOwnerFound = true;
			int ownerIndex = 0;
			while(noOwnerFound){
				String name = readString("Vem ska äga objektet: ");
				for(int i=0; i<allPersons.size() && noOwnerFound; i++){
					if(name.equalsIgnoreCase(allPersons.get(i).getName())){
						ownerIndex = i;
						noOwnerFound = false;
					}
				}
				if(noOwnerFound) System.out.println("Det finns ingen som heter " + name + ", försök igen!");
			}
// Ask for kind
			boolean noKind = true;
			String kind = "";
			while(noKind){
				kind = readString("Vilket objekt (Smycke/Aktie/Apparat): ").toLowerCase();
				if(kind.equals("smycke") ||
						kind.equals("aktie") ||
						kind.equals("apparat")){
					noKind = false;
				}
				if(noKind) System.out.println("Fel sorts objekt, försök igen!");
			}
// If jewellery, ask for details
			if(kind.equals("smycke")){
				String thingName = readString("Vilken sorts smycke: ");
				Boolean isGold = readString("Är smycket av guld (ja/nej)? ").equalsIgnoreCase("ja");
				int numberOfStones = readInt("Antal ädelstenar: ");
// Create new jewellery
				Jewellery thing = new Jewellery(thingName, isGold, numberOfStones);
				allPersons.get(ownerIndex).addThing(thing);
				System.out.print(allPersons.get(ownerIndex).getName() + " har fått ett nytt smycke: " + thingName);
				System.out.println(" med värdet " + thing.getValue());
// If stock, ask for details
			} else if(kind.equals("aktie")){
				String thingName = readString("Aktiens namn: ");
				int number = readInt("Antal aktier: ");
				int price = readInt("Pris/aktie: ");
// Create new stock
				Stock thing = new Stock(thingName, number, price);
				allPersons.get(ownerIndex).addThing(thing);
				System.out.print(allPersons.get(ownerIndex).getName() + " har fått en ny aktie: " + thingName);
				System.out.println(" med värdet " + thing.getValue());
// If device, ask for details
			} else if(kind.equals("apparat")){
				String thingName = readString("Apparatens namn: ");
				int originalPrice = readInt("Inköpsvärde: ");
				int wear = 0;
				while(wear<1 || wear >10){
					wear = readInt("Slitage (1-10): ");
					if(wear<1 || wear>10) System.out.println("Fel värde, försök igen!");
				}
// Create new device
				Device thing = new Device(thingName, originalPrice, wear);
				allPersons.get(ownerIndex).addThing(thing);
				System.out.print(allPersons.get(ownerIndex).getName() + " har fått en ny apparat: " + thingName);
				System.out.println(" med värdet " + thing.getValue());
// Program execution should never come here
			} else {
				System.out.println("Fel i programmet!");
				System.exit(1);
			}
		} else {
			System.out.println("Registret är tomt, skapa först minst en person!");
		}
		return;
	}// createThing()
	
	void showAllPersons(){
		if(allPersons.size() > 0){
			System.out.println("I registret finns följande personer:");
			for(Person p : allPersons){
				System.out.println(p.getName() + ", äger objekt till ett värde av " + p.getTotalValue());
			}
		} else {
			System.out.println("Registret är tomt");
		}
		return;
	} // showAllPersons()

	void showRichestPerson(){
		if(allPersons.size() > 0){
			int richest = 0;
			for(int i=1; i<allPersons.size(); i++){
				if(allPersons.get(i).getTotalValue() > allPersons.get(richest).getTotalValue()){
					richest = i;
				}
			}
			System.out.println("Rikast är " + allPersons.get(richest).getName() +
					" som äger objekt till ett värde av " +
					allPersons.get(richest).getTotalValue() + ":");
			allPersons.get(richest).printThings();
		} else {
			System.out.println("Registret är tomt");
		}
		return;
	} // showRichestPerson()

	void showOnePerson(){
		if(allPersons.size() > 0){
			String name = readString("Ange namn: ");
			boolean noPersonFound = true;
			int personIndex = 0;
			for(int i=0; i<allPersons.size() && noPersonFound; i++){
				if(name.equalsIgnoreCase(allPersons.get(i).getName())){
					noPersonFound = false;
					personIndex = i;
				}
			}
			if(noPersonFound){
				System.out.println(name + " finns inte");
			} else {
				System.out.println(allPersons.get(personIndex).getName() +
						" äger objekt till ett värde av " +
						allPersons.get(personIndex).getTotalValue() + ":");
				allPersons.get(personIndex).printThings();
			}
		} else {
			System.out.println("Registret är tomt");
		}
		return;
	} // showOnePerson()
	
	void crashStockMarket(){
		for(Person p : allPersons){
			for(Thing t : p.getThings()){
				if(t instanceof Stock){
					((Stock) t).setPrice(0);
				}
			}
		}
		System.out.println("Alla aktier är nu värdelösa");
		return;
	} // crashStockMarket()

	void removePerson(){
		if(allPersons.size() > 0){
			String name = readString("Ange namn: ");
			boolean noPersonFound = true;
			int personIndex = 0;
			for(int i=0; i<allPersons.size() && noPersonFound; i++){
				if(name.equalsIgnoreCase(allPersons.get(i).getName())){
					noPersonFound = false;
					personIndex = i;
				}
			}
			if(noPersonFound){
				System.out.println(name + " finns inte");
			} else {
				System.out.println(allPersons.get(personIndex).getName() +
						" är nu borttagen");
				allPersons.remove(personIndex);
			}
		} else {
			System.out.println("Registret är tomt");
		}
		return;
	} // removePerson()

	void removeThing(){
		if(allPersons.size() > 0){
// Ask for owner
			boolean noOwnerFound = true;
			int ownerIndex = 0;
			while(noOwnerFound){
				String name = readString("Vems objekt ska tas bort? ");
				for(int i=0; i<allPersons.size() && noOwnerFound; i++){
					if(name.equalsIgnoreCase(allPersons.get(i).getName())){
						ownerIndex = i;
						noOwnerFound = false;
					}
				}
				if(noOwnerFound) System.out.println("Det finns ingen som heter " + name + ", försök igen!");
			}
// Ask for object
			String objectName = readString("Vilket objekt ska tas bort? ");
			boolean noObjectFound = true;
			int objectIndex = 0;
			ArrayList<Thing> things = allPersons.get(ownerIndex).getThings();
			for(int i=0; i<things.size() && noObjectFound; i++){
				if(objectName.equalsIgnoreCase(things.get(i).getName())){
					objectIndex = i;
					noObjectFound = false;
				}
			}
			if(noObjectFound){
				System.out.println(allPersons.get(ownerIndex).getName() +
						" äger inte "+objectName);
			} else {
				System.out.println(allPersons.get(ownerIndex).getName()+"s "+
						things.get(objectIndex).getName()+
						" är nu borttagen");
				allPersons.get(ownerIndex).removeThing(objectIndex);
			}
		} else {
			System.out.println("Registret är tomt");
		}
		return;
	} // removeThing()
	
	void removeAllPersons(){
		if(allPersons.size() > 0){
			allPersons.clear();
			System.out.println("Alla personer är nu borttagna");
		} else {
			System.out.println("Registret är tomt");
		}
		return;
	} // removeAllPersons()

	static int readInt(String prompt){
		while(true){
			try{
				return Integer.parseInt(readString(prompt));
			}
			catch(NumberFormatException e){
				System.out.println("Ange ett heltal!");
			}
		}
	} // readInt()
	
	static String readString(String prompt){
		System.out.print(prompt);
		return keyboard.nextLine();
	} // readString()

} // Valuables
