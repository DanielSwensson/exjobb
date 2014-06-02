import java.util.*;

public class Register {

	ArrayList<Person> persons = new ArrayList<Person>();
	Scanner sc = new Scanner(System.in);
	/**MENU*/

	private static void menu(){
		System.out.println("Welcome to IRS, the Item Registration Service" + " \n");

		System.out.println("_______________________");
		System.out.println("| 1. Register a person.|");
		System.out.println("| 2. Register an item. |");
		System.out.println("| 3. Show all.         |");
		System.out.println("| 4. Show richest.     |");
		System.out.println("| 5. Show specified.   |");
		System.out.println("| 6. Stock Crash.      |");
		System.out.println("| 7. Exit.             |");
		System.out.println("|______________________|");
	}

	/**CREATION OF ITEMS*/

	private void createItem(){

		System.out.println("Who has the item?: ");			
		String name = sc.next();								
		boolean found = false;									
		Person per = null;
		for(Person p : persons)								
			if(p.getName().equalsIgnoreCase(name)){				
				per = p;
				found = true;									
				break;
			}
		if(!found){
			System.out.println("Person not found");
			return;
		}

		String specifiedItem = readString("What kind of item is it? (Type in Gadget, Stock or Accessory:");

		if (specifiedItem.equals("accessory")){
			per.addItem(createAccessory());
		}
		else if (specifiedItem.equals("stock")){
			per.addItem(createStock());
		}
		else if (specifiedItem.equals("gadget")){
			per.addItem(createGadget());    
		}
	}

	/**ACCESSORIES*/

	private Item createAccessory(){
		String specifiedAccessory = readString("What type of accessory?: ");

		String specifiedMaterial;
		for(;;){
			specifiedMaterial = readString("Is it made of gold/silver:");
			if (specifiedMaterial.equals("gold") || specifiedMaterial.equals("silver")) {
				int numberOfGems = readInt("How many gems does it have?: ");
				if (numberOfGems>=0) {
					return new Accessory(specifiedAccessory, specifiedMaterial, numberOfGems);	
				}else{
					System.out.println("You can't have a negative number of gems, if your \n" +
							"accessory doesn't have any gems, please type in  \nthe material" +
							"again and then 0");
				}

			}
			else{
				System.out.println("Error 505, you can only type in Silver or Gold:");
			}
		}
	}


	/**GADGETS*/

	private Item createGadget(){
		String specifiedGadget = readString("What type of gadget is it?: ");
		int conditionOfGadget = readInt("How is the gadgets condition, 1-10 (10 being the best score)?: ");

		for (;;) {
			if((conditionOfGadget<=1) || (conditionOfGadget>=11)) {
				conditionOfGadget = readInt("Wrong type of condition, type in a value between 1-10: ");

			}else{
				break;
			}
		}
		int priceOfGadget = readInt("What is the price of the gadget?: ");

		return new Gadget(specifiedGadget, conditionOfGadget, priceOfGadget);
	}


	/**STOCKS*/

	private Item createStock(){																
		String specifiedStock = readString("What kind of stock do you have?: ");
		int numberOfStocks = readInt("How many stocks do you have?: ");
		double stockPrice = readInt("What is the stock price?: ");

		return new Stock (specifiedStock, stockPrice, numberOfStocks);
	}


	/**CRASH*/

	private void stockExchangeCrash() {

		for (int c =0; c< persons.size(); c++) {
			persons.get(c).stockValueCrash();
		}
		System.out.println("Stock Exchange CRASH! Your stocks are now worth NOTHING!");
	}


	/**PERSONS*/

	Person getPerson(String newPerson) {							
		for (Person nPerson : persons)
			if (nPerson.getName().equalsIgnoreCase(newPerson))
				return nPerson;
		return null;	
	}


	private void registerPerson(){

		String newPerson = readString("Please register a person: ");	
		Person individual = getPerson(newPerson);								
		if (individual!=null) 
			System.out.println("That person aldready exists!");
		else{

			persons.add(new Person(newPerson));										
			return;
		}
	}																

	/**PRINT PERSONS*/

	private void printAll(){	

		System.out.println("Registered persons: ");
		for (int c = 0 ; c < persons.size(); c++){
			System.out.print("  " + persons.get(c) + "   " + persons.get(c).totalValue() + " \n");
		} 
	}

	private void printSpecified() {

		String printSpecified = readString("Specified person: Who do you want printed?: ");
		Person specificPerson = getPerson(printSpecified);

		if (specificPerson == null) {
			System.out.print("Person doesn't exsist in the system");
		}else {
			System.out.println(specificPerson.specifiedBelongings());
		}
	}

	private void printRichest() {
		System.out.println("Richest person is: ");

		Person largestAtm = persons.get(0);

		for (int c = 1 ; c < persons.size(); c++){
			Person a = persons.get(c);
			if(a.totalValue() > largestAtm.totalValue()) {
				largestAtm = a;
			}
		}
		System.out.println(largestAtm.getName()+ " "+ largestAtm.totalValue()+"\n\n"+largestAtm.specifiedBelongings());
	}


	/**ERROR CHECKING AND SCANNER*/

	int readInt(String question){
		for(;;){
			try{
				System.out.println(question);
				int x = Integer.parseInt(sc.next());    
				if (x<0) {
					System.out.println("You can't type in a negative value. Please try again.");
				}else {
					return x;
				}
			}catch (NumberFormatException e){
				System.out.println("Wrong type of value, please type in a numeric value");
			}
		}
	}

	String readString(String question){
		System.out.println(question);
		String str=sc.next();   
		String strLow = str.toLowerCase();
		return strLow;
	}

	/**MAIN METHOD*/

	public static void main(String[] args) {

		Register reg = new Register();
		Register.menu();

		for (;;){
			int choice = reg.readInt("\n" + "START\nWhat do you want to do?");
			switch (choice) {
			case 1:
				reg.registerPerson();
				break;
			case 2:
				reg.createItem();
				break;
			case 3:
				reg.printAll();
				break;
			case 4:
				reg.printRichest();
				break;
			case 5:
				reg.printSpecified();
				break;
			case 6:
				reg.stockExchangeCrash();
				break;
			case 7:
				System.out.print("You killed me, goodbye.");
				System.exit(0);
			default:
				System.out.println("Wrong type of value, type in a value between 1-7");
			} //end of switch
		} //end of for
	} // end of main
} // class