import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;


public class ValueRegister {
	static Scanner keyboard = new Scanner(System.in);
	private ArrayList<Person> personList = new ArrayList<Person>();
	
	private void createPerson(){
		String newPersonName = readString("Name:");
		
		if(checkIfNameExists(newPersonName)==false){
			personList.add(new Person(newPersonName));
		}else{
			System.out.println("Person with that name already exists");
		}
		
	}
	
	private void addItem(){
		String personName = readString("To which  person?");
		
		if(checkIfNameExists(personName)==true){
			for(Person person:personList){
				if(person.getName().equalsIgnoreCase(personName)){
					String newItemName = readString("What kind of item?     (Jewelry/Share/Device)");
					if(newItemName.equalsIgnoreCase("JEWELRY") || newItemName.equalsIgnoreCase("JEWELLERY")){
						
						String material = readString("What material?");
						String name = readString("What kind of jewelry?");
						int gems = readInt("How many gems?");
						if(material.equalsIgnoreCase("GOLD")){
							person.addItem(new Jewelry(name,true,false,gems));
						}else if(material.equalsIgnoreCase("SILVER")){
							person.addItem(new Jewelry(name,false,true,gems));
						}else{
							person.addItem(new Jewelry(name,false,false,gems));
						}
						
					}else if(newItemName.equalsIgnoreCase("SHARE")){
						
						person.addItem(new Share(readString("What company"),readInt("How many?"),readInt("What is the price per share?")));
						
					}else if(newItemName.equalsIgnoreCase("DEVICE")){
						
						person.addItem(new Device(readString("What kind of device?"),readInt("In what condition? (1(poor)-10(good))"),readInt("What is the original price")));
						
					}else{
						System.out.println("Not a valid item");
					}
				}
			}
		}else{
			System.out.println("Person does not exist");
		}
	}
	
	private void showAll(){
		for(Person p : personList){
			System.out.println(p.toString());
		}
	}
	
	private void showWealthiest(){
		Person wealthiest = null;
		int highestValue=0;
		for(Person p:personList){
			if(p.getTotalValue()>=highestValue){
				wealthiest = p;
				highestValue = p.getTotalValue();
			}
		}
		if(wealthiest!=null){
			System.out.println(wealthiest.getName()+" is the wealthiest with a total value of "+highestValue);
			printPersonInventory(wealthiest);
		}else{
			System.out.println("There are no people in the system!");
		}
	}
	
	private void showPerson(){
		String person = readString("Which person?");
		if(checkIfNameExists(person)==true){
			for(Person p:personList){
				if(p.getName().equalsIgnoreCase(person)){
					System.out.println(p.getName()+" with a total value of "+p.getTotalValue());
					printPersonInventory(p);
				}
			}
		}else{
			System.out.println("Person does not exist");
		}
	}
	
	private void stockMarketCrash(){
		for(Person p:personList){
			p.makeSharesWorthless();
		}
	}
	
	private void removePerson(){
		String name = readString("Which person?");
		if(checkIfNameExists(name)==true){
			for(int i=0;i<personList.size();i++){
				if(personList.get(i).getName().equalsIgnoreCase(name)){
					personList.remove(i);
					
				}
			}
		}else{
			System.out.println("Person does not exist");
		}
	}
	
	private void removeItem(){
		String name = readString("From which person?");
		if(checkIfNameExists(name)==true){
			for(Person p:personList){
				if(p.getName().equalsIgnoreCase(name)){
					printPersonInventoryNumbered(p);
					int itemIndex = readInt("Which item do you want to remove     (select by number)");
					if(itemIndex<=p.getItemListLength() && itemIndex>0){
						p.removeItemAtIndex(--itemIndex);
					}else{
						System.out.println("unvalid choice");
					}
				}
			}
		}else{
			System.out.println("Person does not exist");
		}
	}
	
	private void printPersonInventory(Person p){
		for(int i=0;i<p.getInventoryLength();i++){
			System.out.println(p.toStringInventoryLine(i));
		}
	}
	
	private void printPersonInventoryNumbered(Person p){
		for(int i=0;i<p.getInventoryLength();i++){
			System.out.println((i+1)+"   "+p.toStringInventoryLine(i));
		}
	}
	
	private boolean checkIfNameExists(String name){
		for(Person p:personList){
			if(p!=null){
				if(p.getName().equalsIgnoreCase(name)){
					return true;
				}
			}
		}
		return false;
	}
	
	private int readInt(String question){
		while(true){
			try{
				System.out.print(question+"\n>");
				return Integer.parseInt(keyboard.nextLine());
			}
			catch (NumberFormatException e){
				System.out.println("Error - Not a number");
			}
		}
	}
	
	private String readString(String question){
		System.out.print(question+"\n>");
		return keyboard.nextLine();
	}
	
	private void save(){
		try{
			FileOutputStream file=new FileOutputStream("ValueRegister.txt");
			ObjectOutputStream out=new ObjectOutputStream(file);
			out.writeObject(personList);
			}
			catch (IOException e){
			System.exit(1);
			}
	}
	
	private void load(){
		try{
			FileInputStream file=new FileInputStream("ValueRegister.txt");
			ObjectInputStream in=new ObjectInputStream(file);
			personList = (ArrayList<Person>)in.readObject();
			}
			catch (FileNotFoundException e){
			//No file found - empty personList
			}
			catch (IOException e){ System.exit(2);}
			catch (ClassNotFoundException e){ System.exit(3);}
	}
	
	public static void main(String[] args){
		ValueRegister mp = new ValueRegister();
		
		mp.load();
		
		System.out.println("Welcome! Main menu: \n 1. Create Person \n 2. Add item \n 3. Show all \n 4. Show wealthiest \n 5. Show person \n 6. Stock market crash \n 7. Quit \n 8. Remove person \n 9. Remove Item");
		while(true){
			int select=mp.readInt("Type command 1-9 ");
			switch (select){
				case 1: mp.createPerson(); break;
				case 2: mp.addItem(); break;
				case 3: mp.showAll(); break;
				case 4: mp.showWealthiest(); break;
				case 5: mp.showPerson(); break;
				case 6: mp.stockMarketCrash(); break;
				case 7: System.out.println("Goodbye!");
						mp.save();
						System.exit(0);
				case 8: mp.removePerson();break;
				case 9: mp.removeItem();break;
				default: System.out.println("Unrecognized command");
			}
		}
	}
}
