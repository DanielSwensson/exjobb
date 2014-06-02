import java.util.Scanner;
import java.util.ArrayList;

public class Operations {

	ArrayList<Person> personlist = new ArrayList<Person>();
	ArrayList<Items> itemlist = new ArrayList<Items>();
	Scanner input = new Scanner(System.in);
	
	public void createPerson (){										//(1) Register new person
		System.out.println("\nYou have chosen to register a new person.\nPlease enter the name of the person:");
		String personNameData = input.nextLine();
				
		if (personChecker(personNameData)==true){
			System.out.println("The person "+ personNameData +" already exists.\n");
		}
		else {
			personlist.add(new Person(personNameData));
			System.out.println("Person "+personNameData+" successfully registered.\n");
		}
	}
	
	public void createItem (){											//(2) Register new item.
		try {
			System.out.println("You have chosen to register a new item.\nPlease enter the name of the owner:");
		
		String personNameData = input.nextLine();		
		String itemNameData;

		if (personChecker(personNameData)==false){
			personlist.add(new Person(personNameData));
			System.out.println(personNameData + " never used before. Person "+ personNameData +" now registered.");
			}
		System.out.println(personNameData + " set as owner.");
		
		System.out.println("What kind of item would you like to register?\n(1). Jewelry - (2). Stock(s) (3). Equipment");
		int itemTypeOperation = Integer.parseInt(input.nextLine());
		
		switch (itemTypeOperation){
		case 1:							// Jewelry
			System.out.println("What kind of jewelry would you like to register?");
			String jewelryNameData = input.nextLine();
			itemNameData = jewelryNameData;
			System.out.println("What is your jewelry made out of? (1). Gold or (2). Silver?");
			int jewelryMaterialData = Integer.parseInt(input.nextLine());
			System.out.println("How many gems does your jewelry have?");
			int jewelryNumberOfGemsData = Integer.parseInt(input.nextLine());
			itemlist.add(new Jewelry(personNameData, itemNameData, jewelryMaterialData, jewelryNumberOfGemsData));
			System.out.println("Jewelry registered.\n");
			break;
			
		case 2:							// Stock(s)
			System.out.println("What is the name of the stock you would like to register?");
			String stockNameData = input.nextLine();
			itemNameData = stockNameData;
			System.out.println("What is each stock worth?");
			int stockValueData = Integer.parseInt(input.nextLine());
			System.out.println("How many stock(s) do you own?");
			int stockQtyData = Integer.parseInt(input.nextLine());
			itemlist.add(new Stocks(personNameData, itemNameData, stockValueData, stockQtyData));
			System.out.println("Stock registered.\n");
			break;
		
		case 3:							// Equipment
			System.out.println("What is the name of the equipment you would like to register?");
			String equipmentNameData = input.nextLine();
			itemNameData = equipmentNameData;
			System.out.println("What was the purchase price of the equipment?");
			int equipmentPurchasePriceData = Integer.parseInt(input.nextLine());
			System.out.println("What is the condition of the equipment? (1 (worst) - 10 (best))");
			int equipmentStateData = Integer.parseInt(input.nextLine());
			itemlist.add(new Equipment(personNameData, itemNameData, equipmentPurchasePriceData, equipmentStateData));
			break;
			
				}
			}
		catch(NumberFormatException e) {
			System.out.println("Unknown command. Please, try again.");
			
		}
	}
	private boolean personChecker(String personNameData) {				//Used by case 1 and 2 to check if a person already exists.
		  for (int a = 0; a < personlist.size(); a++) {
		   if ((personlist.get(a).getpersonName().equalsIgnoreCase(personNameData))) {
		    return true;
		    }
		  }
		  return false;
		 }
	
	public void personsTotalValue (){									//(3) Calculates total value for persons
		System.out.println("Owner\tTotal Value");
		 for (Person p : personlist){
				System.out.println(p.getpersonName() + "\t" + Integer.toString(getOwnerTotalItemsValue(p.getpersonName())));
				}
		}
	
	public void listRichestPerson (){									//(4) Displays richest person and his/her items.
		 int max = getOwnerTotalItemsValue(personlist.get(0).getpersonName());
		 String pname = personlist.get(0).getpersonName();
			 for (int p = 0; p < personlist.size(); p++){
				if(getOwnerTotalItemsValue(personlist.get(p).getpersonName()) > max){
				max = getOwnerTotalItemsValue(personlist.get(p).getpersonName());
				pname = personlist.get(p).getpersonName();
				}
		 }
			 System.out.println("The richest person is "+ pname +" with a total value of "+ max +"\n\tItem (Value)");
			 for(int p=0; p<itemlist.size(); p++){
					if(itemlist.get(p).getitemOwner().equalsIgnoreCase(pname)) {
					System.out.println(itemlist.get(p));
			}
		}
	 }
	
	public void listPerson (){											//(5) Displays specified person and his/her items.
		System.out.println("Please, enter the name of the person you would like to list: ");
		String personName = input.nextLine();
		int personValue = 0;
		for (int p = 0; p < personlist.size(); p++){
			if(itemlist.get(p).getitemOwner().equalsIgnoreCase(personName)){
				personValue = getOwnerTotalItemsValue(personName);
			}		
	 }
		System.out.println(personName + " has items with a total value of " + personValue + ".\n\tItem (Value)");
		 for(int p=0; p<itemlist.size(); p++){
				if(itemlist.get(p).getitemOwner().equalsIgnoreCase(personName)) {
				System.out.println(itemlist.get(p));
			}
		 }
	}
	public int getOwnerTotalItemsValue(String itemOwner){				//Used by case 3, 4 and 5 to calculate total value for persons.
		int totalValue = 0;
		for (Items i : itemlist){
			if (i.getitemOwner().equalsIgnoreCase(itemOwner)){
				totalValue += i.getitemValue();	
			}
			}
		return  totalValue;	
		}
	
	public void stockExchangeCrash (){									//(6) Executes Stock Exchange Crash, making all stocks value = 0.
		System.out.println("(S)tock (E)xchange (C)rash executed. All stocks are now worth 0.\n");
		for (Items i : itemlist){
			if (i instanceof Stocks){
				for (Person p : personlist){	
					if(p.getpersonName().equalsIgnoreCase(i.getitemOwner())){
						((Stocks) i).crash();
					}
				}
			}
		}
	}
	
	public static void main (String[]args) {							//Main 
		
			Scanner input = new Scanner(System.in);
			Operations Operations = new Operations();
			int loopCheck = 1;											//Loop to keep application running.
			while (loopCheck == 1){
		try {
		System.out.println("Please, choose the operation that you would like to perform.\n(1). Register new person\n(2). Register new item\n" +
				"(3). List persons\n(4). Display richest person\n" +
				"(5). Display person\n(6). Initiate Stock Exchange Crash\n" +
				"(7). Exit");
		int operation = Integer.parseInt(input.nextLine());
		
		switch (operation){
	
		
		case 1: 		//Create person
			Operations.createPerson();	
			break;
		
		case 2:			// Create item
			Operations.createItem();	
			break;
		
		case 3:			// List things
			Operations.personsTotalValue();	
			break;
		
		case 4: 		// Show richest
			Operations.listRichestPerson();
			break;
		
		case 5:			// Show person
			Operations.listPerson();
			break;
						
		case 6:			// SEC (Stock Exchange Crash)
			Operations.stockExchangeCrash();
			break;
			
		case 7:			// Exit program
			System.out.println("Thank you for using this application.\nExiting program.");
			loopCheck=0;
			input.close();
			System.exit(0);
			break;
		
			}
			}
			catch (NumberFormatException e){
			System.out.println("Unknown command. Please, try again.");
			}
		}
		}
}
