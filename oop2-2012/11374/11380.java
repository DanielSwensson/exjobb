import java.util.*;

public class PersonRegister {
	
	private ArrayList<Person> allPersons = new ArrayList<Person>();
	private InputHelper helper = new InputHelper();
	

	public Person getPerson(String name) {         
		
		for (Person person : allPersons) {
			if (person.getName().equals(name)) 
				return person;
		}	
	    return null;
	}
	
	public void newPerson() {
		
		String name = helper.readString("The Persons name: ");
		Person person = getPerson(name);
		
		if (person!=null) {
			System.out.println("It allready exists a person with that name. ");
		
		} else {
			Person theNewPerson = new Person(name);
			allPersons.add(theNewPerson);
		}
	}
	
	public void newValuable() {
		
		Person person;
		
		do {	
			String owner = helper.readString("Who is the owner of the valuable? ");
			person = getPerson(owner);
		
			if(person==null) {
				System.out.println("There isnt any with that name added."); 
			}	
			
		} while (person==null);
			
		 String kind = helper.readString("Choose kind of Valuable; Jewelry, Appliance or Share: ");
		
		if (kind.equals("Jewelry")) {
			
			String name = helper.readString("Name of jewelry: ");
			int numbersOfGemstones = helper.readInt("How many gemstones does it have?: ", 0);
			String jewelryMadeOf = helper.readString("Made of:");
			
			Valuable newValuable = new Jewelry(name, numbersOfGemstones, jewelryMadeOf);
			person.addValuable(newValuable);				
		}
		
		if (kind.equals("Appliance")) {
			
			String name = helper.readString("Name of Appliance: ");
			int purchasePrice = helper.readInt("What is the purchasePrice?: ", 0);
			int wear = helper.readInt("Wear (1-10):", 1, 10);	
		 
			Valuable newValuable = new Appliance(name, purchasePrice, wear);
			person.addValuable(newValuable);
		}
		
		if (kind.equals("Share")) {
			
			String name = helper.readString("Name of Share: ");
			int numbersOfShares =helper.readInt("How many Shares?: ", 1);
			int price = helper.readInt("Price per Share:", 0);
				
			Valuable newValuable = new Share(name, numbersOfShares, price);
			person.addValuable(newValuable);
		}
		
		if (!kind.equals("Jewelry") && !kind.equals("Appliance") && !kind.equals("Share")) {
			System.out.println("You can only choose between the valuables mentioned, try again by pressing 2. ");
		}	
	}
	
	public void showAll() {
			
		for (int index = 0; index < allPersons.size(); index++) {
			Person person = allPersons.get(index);
			
				System.out.println("Name: " + person.getName() + ". TotalValue of valuables: " + person.getsumOfValuables());
		}
	}
		
	public void showPerson() {
			
		String name = helper.readString("Who do you like to find? ");
		
		for (int index = 0; index<allPersons.size(); index++) {
			Person person = allPersons.get(index);
				
			if (allPersons.get(index).getName().equals(name)) {
					
				System.out.println("You asked for " + name + ". ");
					
				for (int i = 0; i < person.getValuables().size(); i++) {
					Valuable valuable = person.getValuables().get(i);
						 
					System.out.println(valuable);
				}
				System.out.println("TotalValue of valuables: " + person.getsumOfValuables());
				return; 
			} 
		}
	}
				
	public void richestPerson() {
		
		String b = null;
		int y=0;
		Person person = null;
			
		for(int index=0; index < allPersons.size(); index++) {
			person = allPersons.get(index);
			int a = person.getsumOfValuables();
			
			if (a > y) {
				
				y=a;
				b = person.getName();
			}	
		}
			System.out.println("The richest person is " + b +  " with a fortune of " + y + ".");
			
			for (int index = 0; index<allPersons.size(); index++) {
				person = allPersons.get(index);
					
				if (person.getName().equals(b)) {
					System.out.println(person.getValuables());
			
				}
			}
			
		}
		
	public void stockCrash() {
				
		for(int index=0; index < allPersons.size(); index++) {
			Person person = allPersons.get(index);
			
			for (int i = 0; i < person.getValuables().size(); i++) {
				Valuable valuable = person.getValuables().get(i);
				
				if (valuable instanceof Share) {
					
					Share tmpShare = (Share)valuable;
					tmpShare.setPrice(0);
					
				}	
			}			 
		}		
	}      
}		
	

