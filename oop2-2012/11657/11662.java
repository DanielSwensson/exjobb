import java.util.Scanner;
import java.util.ArrayList;

public class PeopleAndStuff {
	private ArrayList <People> allPeople = new ArrayList<People>();
	static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {
				
		PeopleAndStuff pas =  new PeopleAndStuff();
		
		for(;;) {
			System.out.print("Welcome to PeopleNStuff!\n\n" +
					"Choose an option.\n" +
					"1 Register a person\n" +
					"2 Register an item\n" +
					"3 List all persons\n" +
					"4 List the most wealthy\n" +
					"5 List specific person\n" +
					"6 Cause a stock market crash\n" +
					"7 Exit\n");
					
			int alt = readInt("> ");					
			
			switch (alt) {
					
				case 1:
					pas.createPerson();
					break;
				case 2:
					pas.createItem();
					break;
				case 3: 
					pas.showAll();
					break;
				case 4:
					pas.showRichest();
					break;
				case 5:
					pas.showPerson();
					break;
				case 6:
					pas.stockMarketCrash();
					break;
				case 7:
					System.out.println("Good bye!");
					System.exit(0);
				default:
					System.out.println("Try again!");
			}
			
		}
	}
				
	public void createPerson(){
		String name = readString("New person: ");
		for (People p : allPeople){
			if (name.equalsIgnoreCase(p.getName())){
				System.out.println("The person already exists.");
				return;
			}
		}
		People p = new People(name);
		allPeople.add(p);
		return;
	}
											
	public void createItem(){
		String owner = readString("Which owner? ");
		boolean found = false;
		int ifound = 0;
		for (int index = 0; index < allPeople.size() && (!found); index++ ){
			if (owner.equalsIgnoreCase(allPeople.get(index).getName())){
				ifound = index;
				found = true;
			}
		}
		if (!found){
			System.out.println("The person you are looking for doesen't exist.");
			return;
		}
		String itemType = " ";
		while (!(itemType.equalsIgnoreCase("Jewelry") ||
				itemType.equalsIgnoreCase("Gadget") ||
				itemType.equalsIgnoreCase("Stock") )){
			itemType = readString("Type of item (Jewelry/Gadget/Stock): ");
		}
		if (itemType.equalsIgnoreCase("Jewelry")){
			String name = readString("Name: ");
			int gems = readInt("Number of gems: ");
			String metal = readString("Gold or Silver: ");
			boolean gold = metal.equalsIgnoreCase("Gold");
			Jewelry j = new Jewelry(name, gems, gold);
			allPeople.get(ifound).addItem(j);
		}
		if (itemType.equalsIgnoreCase("Stock")){
			String name = readString("Name of Stock: ");
			int quantity = readInt("Number of stock: ");
			int price = readInt("Stock price: ");
			Stock newStock = new Stock (name, quantity, price);
			allPeople.get(ifound).addItem(newStock);
		}
		if (itemType.equalsIgnoreCase("Gadget")){
			String name = readString("Kind of gadget: ");
			int orgValue = readInt("Gadget value: ");
			int decay = 0;
			while (decay < 1 || decay > 10){
				decay = readInt("How worn is the gadget (1 - worn out / 10 - brand new): ");
				if (decay < 1 || decay > 10){
					System.out.println("Not in correct range!");
				}
			}
			Gadget newGadget = new Gadget(name, orgValue, decay);
			allPeople.get(ifound).addItem(newGadget);
		}
	}
	public void showAll(){
		System.out.println("Registered people: ");
		for(People p : allPeople){
			System.out.println(p.getName() +" " + p.getTotalValue());
		}
		
	}
	public void showRichest(){
		int ifound = 0;
		int largestValue = 0;
		for (int index = 0; index < allPeople.size(); index++ ){
			if (largestValue < allPeople.get(index).getTotalValue()){
				ifound = index;
				largestValue = allPeople.get(index).getTotalValue();
			}
		}
		System.out.println(allPeople.get(ifound).getName() + " Šr rikast och Šger sammanlagt " +
				allPeople.get(ifound).getTotalValue());
		for (Item i : allPeople.get(ifound).getItem()){
			System.out.println(i.getName() + "  " + i.getValue());
		}
		return;
		
	}
	public void showPerson(){
		String owner = readString("Who do you want to show? ");
		boolean found = false;
		int ifound = 0;
		for (int index = 0; index < allPeople.size() && (!found); index++ ){
			if (owner.equalsIgnoreCase(allPeople.get(index).getName())){
				ifound = index;
				found = true;
			}
		}
		if (!found){
			System.out.println("Owner not found.");
			return;
		}
		System.out.println(allPeople.get(ifound).getName() + " Šger sammanlagt " +
				allPeople.get(ifound).getTotalValue());
		for (Item i : allPeople.get(ifound).getItem()){
			System.out.println(i.getName() + "  " + i.getValue());
		}
		return;
	}
	public void stockMarketCrash(){
		for(People p : allPeople){
			for(Item i : p.getItem()){
				if (i instanceof Stock){
					((Stock)i).setPriceZero();
				}
			}
		}
	}
	
	static int readInt (String question){
		for(;;){
			try{
				System.out.print(question);
				int x = Integer.parseInt(keyboard.nextLine());
				return x;
			}
			catch (NumberFormatException e) {
				System.out.println("Wrong - please enter an integer!");
			}
		}
	}
	
	static String readString(String question){
		System.out.print(question);
		return keyboard.nextLine();
	}


}

