import java.util.Scanner;
import java.util.List;


public class CommandLineInterface {
	public static void main(String[] args){
		CommandLineInterface prog = new CommandLineInterface();
		prog.run();
		}
	
	private Scanner keyboard;
	private Register register;
	
	public CommandLineInterface() {
		keyboard = new Scanner(System.in);	
		register = new Register();
	}
	
	private void run() {
		message("Welcome to -VALUE LIST- The program that keeps track of your valuebles! Choose your command from below ");

		while(true){	
			message("1. Create new Person.");
			message("2. Create new Item.");
			message("3. List all persons.");
			message("4. List richest person.");
			message("5. List specific person.");
			message("6. Make the stock crash.");
			message("7. Exit the program.");
			int action = readInt("$:");
		
			
			switch (action){
			
			case 1: 
				createPerson();
				break;
			case 2:
				createItem();
				break;
			case 3:
				listAll();
				break;
			case 4:
				listRichest();
				break;
			case 5:
				listSpecific();
				break;
			case 6: 
				startStockCrash();
				break;
			case 7:
				exitProgram();
			default: 
				printHelp();
				break;
			}
		}
	}
	
	private int readInt(String prompt) {
		try {
			return Integer.parseInt(readStr(prompt));
		} catch (NumberFormatException ex) {
			message("Please enter an integer.");
			return readInt(prompt);
		}
	}
	
	private String readStr(String prompt) {
		System.out.print(prompt);
		return keyboard.nextLine();
	}
	
	private void message(Object o) {
		System.out.println(o.toString());
	}
	
	private void createPerson() {
		String wantedName = readStr("Please select wanted name: ");
		boolean sucess = register.createPerson(wantedName);
		
		if(sucess == true){
			message("Person registred.");
		}else{
			message("Person already exists in register.");
		}
	}
	
	private void createItem(){
		message("Please enter the number according to what kind of item you want to add: ");
		message("1. Jewelry");
		message("2. Stock");
		message("3. Electronic Product");
		int action = readInt("$:");
		
		switch(action){
		
		case 1:
			addJewelry();
			break;
		
		case 2:
			addStock();
			break;
			
		case 3:
			addElectronicProduct();
			break;
			
		default: 
			message("Invalid command, returning to main menu");
			return;
			}
		}

	private void addElectronicProduct() {
		String nameElectronic = readStr("Wanted name of Electronic Product: ");
		int newPrice = readInt("What is the price of the product when it was new? ");
		int condition = readInt("Rate the condition of the item in the intervall 1-10 where 10 is new and 1 is very old ");
		String ownerElectronic = readStr("To who does the Electronic product belong?");
		
		boolean sucessElectronic = register.createElectronicProduct(nameElectronic, newPrice, condition, ownerElectronic);
		
		if(sucessElectronic == true){
			message("Electronic product sucessfully registered.");
		}else{
			message("Couldn't find owner for Electronic product or condition was out of intervall, please try again.");
		}
	}

	private void addStock() {
		
		String nameStock = readStr("Wanted name of Stock: ");
		int shares = readInt("How many shares do you want to register? ");
		int price = readInt("What is the price of the stock? ");
		String ownerStock = readStr("To who does the Stock(s) belong? "); 
		
		boolean sucessStock = register.createStock(nameStock, shares, price, ownerStock );
		
		if(sucessStock == true){
			message("Stock(s) sucessfully registered.");
		}else{
			message("Couldn't find owner for Stock(s), please try again.");
		}
	}

	private void addJewelry() {
		String nameJewelry = readStr("Wanted name of Jewelry: ");
		int goldTrue = readInt("Is it gold or silver? For gold press 1, for silver press 2");
		boolean gold = goldTrue == 1 ? true : false;
		
		int numberOfGems = readInt("How many gems does the Jewelry have: ");
		String ownerJewelry = readStr("To who does the Jewelry belong: ");
		boolean sucessJewelry = register.createJewelry(nameJewelry, gold, numberOfGems, ownerJewelry);
		
		if(sucessJewelry == true){
			message("Jewelry sucessfully registered.");
		} else {
			message("Couldn't find owner for Jewelry, please try again.");
		}
	}
	
	private void printHelp(){
		message("Please enter a number in the intervall 1-7 according to the menu.");
		}
	
	private void listAll(){
		List<Person> people = register.getPersonList();
		message("People in register: ");
		for(Person p : people) {
			double worth = p.calculateNetWorth();
			
			message(p.getName() + "\t" + "$" + worth);
		}
	}
	
	private void listRichest(){
		Person richestPerson = register.getRichestPerson();
		if (richestPerson == null){
			message("Could not find any person with a new worth over $0.");
			return;
		}
		
		List <Item > toPrint = richestPerson.getItemList();
		
		message("Richest person is " + richestPerson.getName() + "with total net worth of $" + richestPerson.calculateNetWorth() + " :" );
		for(Item i : toPrint){
			message("" + i);
		}
		message("\n");
	}
	
	private void listSpecific(){
		String wantedName = readStr("Who do you wish to list?");

		List<Item> toPrint = register.getSpecificItemList(wantedName);
		if(toPrint == null){
			message("Couldn't find specific person.");
			return;
		}
		
		message(wantedName + " has:");
		for(Item i : toPrint){
			message(i);
			}
		}
	
	private void startStockCrash(){
		message("NEWS DAILY: BREAKING NEWS! \nThe Stockmarket has crashed, every stock has been reset to $0.\n");
		register.initiateStockCrash();
	}
	
	private void exitProgram(){
		message("Thank you for using -VALUE LIST-, Welcome back!");
		System.exit(0);
	}
	
}
