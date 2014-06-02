import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class Register implements Serializable{
	private ArrayList<Person> people = new ArrayList<Person>();
	private static Scanner sc = new Scanner(System.in);
	public Register(){
	}
	public void run(){
		boolean running = true;
		while(running){
			System.out.println("");
			this.printMenu();
			//System.out.print(this.getMenu());
			int command = this.readInt("Command:");
			System.out.println("");
			switch(command){
				case 1:
					//addPerson
					this.addPerson();
					break;
				case 2:
					//removePerson
					this.removePerson();
					break;
				case 3:
					//addValuable
					this.addValuable();
					break;
				case 4:
					//removeValuable
					this.removeValuable();
					break;
				case 5:
					//listPeople
					this.printPeople();
					break;
				case 6:
					//listRichest
					this.printRichest();
					break;
				case 7:
					//listValuables
					String str =this.readString("Input name:");
					this.printValuables(str);
					break;
				case 8:
					//changeShareValue
					this.changeShareValue();
					break;
				case 9:
					this.crashMarket();
					break;
				case 0:
					running = false;
					break;
				default:
					System.out.println("Not a valid command");
					break;
			}
		}
	}
	private void printMenu(){
		System.out.print( 
				"Available commands:\n"+
				"1: 	Add person\n"+
				"2: 	Remove person\n"+
				"3: 	Add valuable\n"+
				"4: 	Remove valuable\n"+
				"5: 	List all people\n"+
				"6: 	List richest person\n"+
				"7: 	List a persons valuables\n"+
				"8:	Change stock value\n"+
				"9: 	Crash stock market\n"+
				"0:	Quit\n");
	}
	private String readString(String question){
		String str = "";
		while (str.equals("")){
			System.out.print(question);
			str = sc.nextLine();
			str = str;
		}
		return str;
	}
	private int readInt(String question){
		while(true){
			try{
				System.out.print(question);
				int x = Integer.parseInt(sc.nextLine());
				return x;
			}
			catch(NumberFormatException e){
				System.out.println("Error - Not a numeric value");
			}
		}
	}
	private double readDouble(String question){
		while(true){
			try{
				System.out.print(question);
				double x = Double.parseDouble(sc.nextLine());
				return x;
			}
			catch(NumberFormatException e){
				System.out.println("Error - Not a numeric value");
			}
		}
	}
	private void addPerson(){
		String name = this.readString("Name:");
		people.add(new Person(name));
	}
	private void removePerson(){
		if (people.size() > 0){
			System.out.println("Available people:");
			int i = 0;
			for(Person p : people){
				i++;
				System.out.println(i+": "+p);
			}
			int personIndex = 0;
			while(personIndex < 1 || personIndex > people.size()){
				personIndex = this.readInt("Who do you want to remove (1-"+people.size()+"):");
			}
			people.remove(personIndex - 1);
		}
		else{
			System.out.println("No people registered.");
		}
	}
	private void addValuable(){
		String name = this.readString("Name of person:");
		Person currentPerson = null;
		for(Person p : people){
			if(p.getName().equals(name)){
				currentPerson = p;
			}
		}
		if(currentPerson == null){
			System.out.println("Person doesn't exist.");
		}
		else{
			int type = 0;
			while(type < 1 || type > 3){
				System.out.println(
						"What type of valuable:\n"+
						"1: Jewellery\n"+
						"2: Appliance\n"+
						"3: Share");
				type = this.readInt("Type:");
				String n;
				double v;
				switch(type){
					case 1:
						n = this.readString("jewellery name:");
						int gemAmount = this.readInt("Number of gems:");
						String metal = "";
						while(metal.equals("") || (!metal.toLowerCase().equals("gold") && !metal.toLowerCase().equals("silver"))){
							metal = this.readString("gold or silver:");
						}
						if(metal.equalsIgnoreCase("gold")){
							currentPerson.addThing(new Jewellery(n, 2000.0, gemAmount));
						}
						else{
							currentPerson.addThing(new Jewellery(n, 700.0, gemAmount));
						}

						break;
					case 2:
						n = this.readString("Appliance name:");
						v = this.readDouble("Value:");
						int w = 0;
						while(w < 1  || w > 10){
							w = this.readInt("Amount of wear(1-10):");
						}
						currentPerson.addThing(new Appliance(n,v,w));
						break;
					case 3:
						n = this.readString("Share name:");
						v = this.readDouble("Value:");
						int a  = this.readInt("Amount:");
						currentPerson.addThing(new Share(n,v,a));
						break;
				}
			}
		}
	}
	private void removeValuable(){
		if(people.size() > 0){
			System.out.println("Available people:");
			int i = 0;
			for(Person p : people){
				i++;
				System.out.println(i+": "+p);
			}
			int personIndex = 0;
			while(personIndex < 1 || personIndex > people.size()){
				personIndex = this.readInt("Who do you want to remove valuables from(1-"+people.size()+"):");
			}
			Person p = people.get(personIndex-1);
			if (p.getThingList().size()>0){
				System.out.println(p.getThingString());
				int itemIndex = 0;
				while(itemIndex < 1 || itemIndex > p.getThingList().size()){
					itemIndex = this.readInt("Which valuable do you want to remove(1-"+p.getThingList().size()+"):");
				}
				p.getThingList().remove(itemIndex - 1);
			}
			else{
				System.out.println(p.getName() + " doesn't have any valuables");
			}

		}

		else {
			System.out.println("No people registered");
		}
	}
	private void printPeople(){
		for(Person person : people){
			System.out.println(person);
		}
		System.out.println("");
	}
	private void printRichest(){
		if(!people.isEmpty()){
			Person person = people.get(0);
			for(Person p : people){
				if(p.getValue() > person.getValue()){
					person = p;
				}
			}
			System.out.println("Richest person: "+person.getName());
			System.out.println("Total wealth: "+person.getValue());
			System.out.println("Possessions:");
			System.out.print(person.getThingString());
			System.out.println("");
		}
		else {
			System.out.println("No people registered.");
		}
	}
	private void printValuables(String name){
		for(Person p : people){
			if(p.getName().equals(name)){
				System.out.println(p.getThingString());
			}
		}
	}
	private void changeShareValue(){
		String name = this.readString("Name of share:");
		double value = this.readDouble("New value of share:");
		for(Person person : people){
			person.changeShareValue(name, value);
		}
	}
	private void crashMarket(){
		//Är väl ett specialfall av changeShareValue men för 
		//läsbarhetens skull så fick den här metoden vara med.
		for(Person p : people){
			p.crashMarket();
		}
	}
}
