import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Database {
	private Scanner scan;
	private ArrayList<Person> allPersons;
	private boolean personExists;
	
	public Database() {
	scan = new Scanner(System.in);
	allPersons = new ArrayList<Person>();
	
		while(true) {
			personExists = false;
			
			try {
			
			System.out.print("1. Add person\n2. Add item\n3. Show all persons\n4. Show richest person\n5. Show specific person\n6. Register stock market crash\n7. Exit\n\nCommand: ");
			int cmd = scan.nextInt();
			System.out.println();
			
			switch(cmd) {
			
				case 1:
					addPerson();
					break;
					
				case 2:
					addItem();
					break;
					
				case 3:	
					showAllPersons();
					break;
					
				case 4:
					showRichestPerson();
					break;
					
				case 5:
					showSpecificPerson();
					break;
					
				case 6:
					registerStockMarketCrash();
					break;
					
				case 7:
					System.out.print("Terminating session.");
					System.exit(0);
	
				default:
					System.out.println("Command not found.");
			}
			
			} catch(InputMismatchException e) {
				System.out.println("\nIncorrect input.\n");
				scan.nextLine();
				continue;
			}
			
			System.out.println();
		}
	}
	
	public void addPerson() {
		System.out.print("Name of person: ");
		scan.nextLine();
		String name = scan.nextLine();
		
		for(Person p : allPersons) {
			if(name.equalsIgnoreCase(p.getName()))
				personExists = true;
		}
		
		if(personExists)
		System.out.println("\nPerson already exists.");
		
		else {
		allPersons.add(new Person(name));
		System.out.println("\nPerson successfully added.");
		}
	}
	
	public void addItem() {
		System.out.print("Name of owner: ");
		scan.nextLine();
		String nameOfOwner = scan.nextLine();
		Person owner = null;
		
		for(Person p : allPersons) {
			if(nameOfOwner.equalsIgnoreCase(p.getName())) {
				personExists = true;
				owner = p;
			}
		}
		
		if(!personExists)
			System.out.println("\nOwner doesn't exist.");
		
		else {
				System.out.print("Item category (Jewelery/Shares/Apparatus): ");
				String itemCategory = scan.nextLine();
				
				if(itemCategory.equalsIgnoreCase("Jewelery") || itemCategory.equalsIgnoreCase("Shares") || itemCategory.equalsIgnoreCase("Apparatus")) {
				
				System.out.print("Type of item (Ring, Ericsson AB, TV, etc): ");
				String type = scan.nextLine();
						
				if(itemCategory.equalsIgnoreCase("Jewelery")) {
					System.out.print("Material (Silver/Gold): ");
					String material = scan.nextLine();
					System.out.print("Number of gems: ");
					int numberOfGems = scan.nextInt();
					owner.addItem(new Jewelery(type, material, numberOfGems));
				}
				
				else if(itemCategory.equalsIgnoreCase("Shares")) {
					System.out.print("Number of shares: ");
					int numberOfShares = scan.nextInt();
					System.out.print("Price per share: ");
					int pricePerShare = scan.nextInt();
					owner.addItem(new Shares(type, numberOfShares, pricePerShare));
				}
				
				else if(itemCategory.equalsIgnoreCase("Apparatus")) {
					System.out.print("Purchase price: ");
					int purchasePrice = scan.nextInt();
					System.out.print("Level of wear (1-10): ");
					int levelOfWear = scan.nextInt();
					owner.addItem(new Apparatus(type, purchasePrice, levelOfWear));
				}
				System.out.println("\nItem added successfully.");
			}
			else
				System.out.println("Item category not found.");
		}
	}
	
	public void showAllPersons() {
		for(Person p : allPersons)
			System.out.println(p);
	}
	
	public void showRichestPerson() {
		int n = 0;
		
		for(Person p : allPersons) {
			if(p.getItemCollectionValue() > n)
				n = p.getItemCollectionValue();
		}
		
		for(Person p : allPersons) {
			if(p.getItemCollectionValue() == n) {
				System.out.println(p);
			for(Item i : p.getItemCollection())
				System.out.println(i);	
			}
		}
	}
	
	public void showSpecificPerson() {
		System.out.print("Person of interest: ");
		scan.nextLine();
		String personOfInterest = scan.nextLine();
		
		for(Person p : allPersons) {
			if(personOfInterest.equalsIgnoreCase(p.getName())) {
				System.out.println("\n" + p);
				
				for(Item i : p.getItemCollection())
				System.out.println(i);
				
				personExists = true;
			}
		}
		
		if(!personExists)
			System.out.println("\nPerson doesn't exist.");
	}

	public void registerStockMarketCrash() {
		for(Person p : allPersons)
			p.stockMarketCrash();
		
		System.out.println("Stock market crash registered, shares are hereby worthless.");
	}

	public static void main(String[] args) {
		new Database();
	}
}
