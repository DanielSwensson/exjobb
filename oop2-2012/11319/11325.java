package valueables;

import java.util.ArrayList;
import java.util.Scanner;

import valueables.items.Device;
import valueables.items.Item;
import valueables.items.Jewelry;
import valueables.items.Jewelry.Material;
import valueables.items.Stock;

public class Valuables implements Runnable{
	private ArrayList<Person> people = new ArrayList<Person>();
	private Scanner keyInput = new Scanner(System.in);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Valuables vb = new Valuables();
		vb.run();
	}

	@Override
	public void run() {
		printHelp();
		String command;
		
		while (true) {
			System.out.print("Enter Command: ");
			command = readCommand();
			if (command.equals("create person") || command.equals("cp")) {
				people.add(createPerson());
				
			} else if (command.equals("list all") || command.equals("la")) {
				for(Person p : people){
					System.out.println(p);
				}
			} else if (command.equals("create item") || command.equals("ci")) {
				Person p;
				System.out.print("Enter Person name: ");
				p=findPerson(readInput());
				if(p==null){
					System.out.println("Could not find person");
				}else{
					p.addItem(createItem());
				}
				
			}else if(command.equals("show richest") || command.equals("sr")){
				
				if (!people.isEmpty()) {
					Person richest=people.get(0);
					for(int i=1; i<people.size(); i++){
						if(people.get(i).getAssets()>richest.getAssets())
							richest=people.get(i);
					}
					System.out.println("Richest person is "+richest.getName()+" whith a total of "+richest.getAssets());
					System.out.println(richest.getItemList());
				}else{
					System.out.println("No registered persons");
				}
				
			}else if(command.equals("show person") || command.equals("sp")){
				if (!people.isEmpty()) {
					Person p;
					System.out.print("Enter Person name: ");
					p = findPerson(readInput());
					if (p == null) {
						System.out.println("Could not find person");
					} else {
						System.out.println(p.getItemList());
					}
				}else{
					System.out.println("No registered persons");
				}
				
				
			}else if(command.equals("crash market") || command.equals("cm")){	
				crashMarket();
				
			}else if (command.equals("exit") || command.equals("q")) {
				System.exit(0);
			} else if (command.equals("help") || command.equals("h")) {
				printHelp();
			}
		}
	}
	
	private void crashMarket() {
		for(Person p : people){
			p.marketCrash();
		}
	}

	private Item createItem() {
		int itemType = -1;
		Item item=null;
		
		
		System.out.println("\n1. Jewelry");
		System.out.println("2. Stock");
		System.out.println("3. Device");
		
		do{
			System.out.print("Select item type: ");
			itemType=readPositiveInt();
			
			switch(itemType){
			case 1: item=createJewelry();
					break;
			case 2: item=createStock();
					break;
			case 3: item=createDevice();
					break;
			default: System.out.println("Invalid choice\n" +
					"Valid: 1,2,3");
			}
		}while(item==null);
		return item;
	}

	private Item createDevice() {
		String name;
		int price=-1;
		int wear=-1;
		name = getName();
			System.out.print("Enter device price:");
			price = readPositiveInt();
		
		do {
			System.out.println("Enter wear 0-10, 10=new, 0=broken");
			System.out.print("Enter wear: ");
			wear = readPositiveInt();
		} while (wear>10);
		return new Device(name, price, wear);
	}

	private Item createStock() {
		String name;
		int price=-1;
		int quantity=-1;
		name = getName();
		
		System.out.print("Enter stock price:");
		price = readPositiveInt();
		System.out.print("Enter stock quantity:");
		quantity = readPositiveInt();
		return new Stock(name, price, quantity);
	}

	private Item createJewelry() {
		String name;
		int gems=-1;
		Material material=null;
		
		name = getName();
			System.out.print("Enter number of gems:");
			gems = readPositiveInt();
		
		String materialChoice=null;
		
		do {
			System.out.print("Gold/Silver:");
			materialChoice = readCommand();
			if (materialChoice.equals("gold")) {
				material = Jewelry.Material.GOLD;
			} else if (materialChoice.equals("silver")) {
				material = Jewelry.Material.SILVER;
			} else {
				System.out.println("Unknown command. Valid choices Gold/Silver");
				materialChoice=null;
			}
		} while (materialChoice==null);
		return new Jewelry(name,gems,material);
	}
	
	private String getName(){
		System.out.print("Enter name:");
		return readInput();
	}
	private Person createPerson() {
		System.out.print("Enter name:");
		return new Person(readInput());
	}
	private Person findPerson(String name){
		
		for(Person p : people){
			if(p.getName().equals(name)){
				return p;
			}
		}
		return null;
	}

	/*
	 * Read input from standard in stripping leading and trailing whitespace
	 */
	private String readInput(){
		return keyInput.nextLine().trim();
	}
	private String readCommand(){
		return readInput().toLowerCase();
	}
	/*
	 * Read and parse integer from standard input
	 * Note: Integer.MIN_value will be returned if parsing fails
	 * @return integer
	 */
	private int readInt(){
		int i=Integer.MIN_VALUE;
			try {
				i = Integer.parseInt(readInput());
			} catch (NumberFormatException e) {
				//Do nothing
			}
		return i;
	}
	
	private int readPositiveInt(){
		int i = -1;
		boolean correctInput=false;
		do{
			i=readInt();
			if(i<0){
				System.out.print("Enter a positive integer: ");
			}
			else{
				correctInput=true;
			}
		}while(!correctInput);
		return i;
	}
	
	private void printHelp(){
		System.out.println("Available commands:");
		System.out.println("Create person\t\tcp");
		System.out.println("Create item\t\tci");
		System.out.println("List all\t\tla");
		System.out.println("Show richest\t\tsr");
		System.out.println("Show person\t\tsp");
		System.out.println("Crash market\t\tcm");
		System.out.println("Exit\t\t\tq");
		System.out.println("Help\t\t\th");
		System.out.println("Commands ignore case\n");
	}

}
