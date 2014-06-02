import java.util.*;
public class Main {

	private static Scanner keyboard = new Scanner(System.in);
	private static ArrayList<person> personAl = new ArrayList<person>();
	private static ArrayList<item> itemAl = new ArrayList<item>();
	
	public static int readInt(String question){
		for(;;){
			try{
			System.out.print(question);
			int x = Integer.parseInt(keyboard.next());
			return x;
			
			}catch (NumberFormatException e){
			System.out.println("Wrong input - has to be a number!");
			}
		}
	}
	public static void commando(){
		int commando;
		System.out.println("\n1 - Register person\n2 - Register item\n3 - Show person\n4 - Show all\n5 - Stock crash\n6 - Show wealthiest\n7 - Remove person\n8 - Remove item\n9 - Exit\n");
		
		commando = readInt("Commando: ");
		
		switch(commando){
		case 1: 
			registerPerson();
			commando();
		case 2: 
			registerItem();
			commando();
		case 3:
			showPerson();
			commando();
		case 4:
			showAll();
			commando();
		case 5:
			stockMarketCrash();
			commando();
		case 6:
			showWealthiest();
			commando();
		case 7: 
			removePerson();
			commando();
		case 8:
			removeItem();
			commando();
		case 9:
			System.exit(0);
		default:
			commando();
		}
		
	}
	public static void registerPerson(){

		int rotation = 0; 
		
		while (rotation <= 0){
			
			System.out.println("Name: ");
			String personName = keyboard.next();
			person ny = new person(personName, 0);
			
			
			for(int x=0; x<personAl.size(); x++){// Check to maintain there are no names register twice. 
				
				if(personAl.get(x).getPersonName().equalsIgnoreCase(personName)){
					System.out.println( personName + " already exsists, choose anathor name!");
					commando();
				}
				
			}
			personAl.add(ny);
			System.out.println("Registration complete!");
			rotation += 1;
		}
	}
	
	public static void registerItem(){
		
		System.out.println("Owner of the item: ");
		String itemOwner = keyboard.next();
		
		if (personAl.isEmpty()){ // Check to see that at least one person registered to be able to register a item.
			System.out.println("No person has been registered, register a person before registering an item!");
			commando();
		}
		
		
		for(int x=0; x<personAl.size(); x++){
			
			if ((itemOwner.equalsIgnoreCase(personAl.get(x).getPersonName()))){
		
				System.out.println("Item type(Stock, Jewlery or Appliance) : ");
				String itemType = keyboard.next();
				
								
				if (itemType.equalsIgnoreCase("Stock")){
					
					registerItemStock(itemOwner, itemType);

				}
					
				if (itemType.equalsIgnoreCase("Jewlery")){
												
					registerItemJewlery(itemOwner, itemType);
					
				}
				
				if(itemType.equalsIgnoreCase("Appliance")){
					
					registerItemAppliance(itemOwner, itemType);

				}
				commando();
			}	
		
		}
			System.out.println(itemOwner + " does not excist, try again!");// Error message, if the person is not found.
			
}	
	public static void registerItemStock(String itemOwner, String itemType){

		
		int itemWorth = 0;
		System.out.println("Whats the name of the stock?: ");
		String itemName = keyboard.next();
		
		int stockPrice = readInt("Price of the stock?: ");
		
		int stockAmount = readInt("Amount of stocks?: ");
		
		itemWorth = stockPrice * stockAmount;
		item ny = new stock(itemOwner, 0, itemType, itemName, itemWorth, stockAmount, stockPrice);
		itemAl.add(ny);
		
		editPersonNetWorth(itemOwner,itemWorth);
		
	}
	public static void registerItemJewlery(String itemOwner, String itemType){
		
		int itemWorth = 0;
		System.out.println("What kind of jewlery?: ");
		String itemName = keyboard.next();
		
		int gemStones =readInt("How many gem stones?: ");
							
		System.out.println("What material(Gold/Silver)?: ");
		String gemMaterial = keyboard.next();
		
		if (gemMaterial.equalsIgnoreCase("Gold")){
			itemWorth = 2000 + (500 * gemStones);
		}
		
		if(gemMaterial.equalsIgnoreCase("Silver")){
			itemWorth = 700 + (500 * gemStones);
		}
		
		item ny = new jewlery(itemOwner,0,itemType,itemName,itemWorth,gemStones,gemMaterial);
		itemAl.add(ny);
		editPersonNetWorth(itemOwner, itemWorth);
		
	}
	public static void registerItemAppliance(String itemOwner, String itemType){
		
		int itemWorth = 0;
		System.out.println("What kind of appliance?: ");
		String itemName = keyboard.next();
		
		int boughtPrice = readInt("Price when bought?: ");
		
		int condition = readInt("Condition(1-10)?: ");
		
		if (condition >= 1 && condition <= 10){
			
			itemWorth = (boughtPrice * condition) / 10;
			
			item ny = new appliance(itemOwner,0,itemType,itemName,itemWorth,condition,boughtPrice);
			itemAl.add(ny);
			
		}else{
			System.out.println("Condition" + " has to be between 1-10, try again!");
			registerItem();					
		}
		
		editPersonNetWorth(itemOwner, itemWorth);
		
		
	}
	
	public static void editPersonNetWorth(String itemOwner,int itemWorth){
		
		for (person p : personAl){ // Add the itemWorth to the owners netWorth.
			if (p.getPersonName().equals(itemOwner)){	
			p.setPersonNetWorth(itemWorth);
			}
		}
	}
	
	public static void showAll(){
		
		for(person p : personAl){
			System.out.println(p.getPersonName() +" "+ p.getPersonNetWorth());
		}
		
		if(personAl.isEmpty()){
			System.out.println("No person is registered!");
		}
		
	}
	public static void showPerson(){
		
		System.out.println("Who are you searching?: ");
		String inp = keyboard.next();
		
		
		for (person p : personAl){// Iterate over names.
			if(inp.equalsIgnoreCase(p.getPersonName())){
				
				System.out.println(p.getPersonName() + " networth is " + p.getPersonNetWorth() + " consisting off: " );
				
				for (item i : itemAl){// Iterate over items.
				
					if (p.getPersonName().equals(i.getItemOwner())){//Check to make sure the name is the same for both the item and person.
						System.out.println(i.getItemName() + " " + i.getItemWorth());
					}
				}
			}
		}
	}
	public static void showWealthiest(){
		
		int wealthiestPersonMoney = 0; 
		String wealthiestPersonName = "";
		
		for (int x=0;x<personAl.size(); x++){ // Search for the wealthiest person. 
			
			if(personAl.get(x).getPersonNetWorth() >= wealthiestPersonMoney ){
				wealthiestPersonMoney = personAl.get(x).getPersonNetWorth();
				wealthiestPersonName = personAl.get(x).getPersonName();
			}
			
		}
		
		System.out.println(wealthiestPersonName +" has " + wealthiestPersonMoney + " consisting of these assets: ");
		
		for (int x=0;x < itemAl.size();x++){ // The wealthiest persons items.
			if(itemAl.get(x).getItemOwner().equalsIgnoreCase(wealthiestPersonName)){
				System.out.println(itemAl.get(x).getItemName() + "  " + itemAl.get(x).getItemWorth());
			}
		}
		
}
	
	public static void stockMarketCrash(){
		
		
		int temp = 0;// Temp is used to remove from the persons nettoWorth.
		for (person p : personAl){
			temp = 0;
			for (int x=0;x<itemAl.size(); x++){
				if (itemAl.get(x).getItemType().equalsIgnoreCase("stock")){
					
					if(itemAl.get(x).getItemWorth() != 0){
						
						if(itemAl.get(x).getItemOwner().equalsIgnoreCase(p.getPersonName())){
							temp = temp + itemAl.get(x).getItemWorth();
							itemAl.get(x).setItemWorth(0);
						}
					}
					
				}
			}
			
			p.setPersonNetWorth(- temp);
		}
	}
	public static void removePerson(){
		
		System.out.println("Which person would you like to remove?: ");
		String removePerson = keyboard.next();
		
		
		
		for(int x=0;x<personAl.size();x++){ // Remove person
			if(personAl.get(x).getPersonName().equalsIgnoreCase(removePerson)){
			personAl.remove(x);
			}
			
		}
		
		for(int y=0;y<itemAl.size();y++){ // Remove persons items
			if(itemAl.get(y).getItemOwner().equalsIgnoreCase(removePerson)){
			itemAl.remove(y);
			}
		}
		
		
	}
	public static void removeItem(){



		
		System.out.println("Who is the owner of the item to be removed?: ");
		String removeItemOwner = keyboard.next();
		
		System.out.println(removeItemOwner + " has the folowing things: ");
		
		for(item i : itemAl){
			if(i.getItemOwner().equalsIgnoreCase(removeItemOwner)){
				System.out.println(i.getItemName() + " " + i.getItemWorth());
			}
		}
				
		System.out.println("Which item would you like to remove?: ");
		String removeItem = keyboard.next();
		
		int temp = 0;
		
		
		for(int x=0;x<itemAl.size(); x++){
			
			if(itemAl.get(x).getItemName().equalsIgnoreCase(removeItem)){
				temp = itemAl.get(x).getItemWorth();
				itemAl.remove(x);
			}
		}
			
		for (person p : personAl){

			if(removeItemOwner.equalsIgnoreCase(p.getPersonName())){
				p.setPersonNetWorth(- temp);
			}
		}	

	}
	public static void main(String[] args) {
		
		commando();
		
	}
}
