// Imports
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class ValueRegister {

	// Scanner-object - to read input from the user
	static Scanner input = new Scanner(System.in);

	// A string representing a line
	static String lines = "-----------------------------------------------";

	// A string that contains 2 linebreaks
	static String distance = "\n\n"; 

	// A boolean that is used to see if the application is running or not
	static boolean isRunning = true;

	// An arraylist that contains all the registered accounts/persons
	static ArrayList<Person> accounts = new ArrayList<Person>(); 

	// A string that will contain the user-input
	static String choice;



	// Function that searches for a given name and, if it finds, returns the person's element index, otherwise returning -1
	private static int getAccountIndex(String name){
		for (Person acc : accounts){
			if (acc.getName().equalsIgnoreCase(name)){
				return accounts.indexOf(acc);
			}
		}
		return -1;
	}

	// Function for creating a jewelry by invoking its constructor
	private static Jewelry createJewelry(){
		String name;
		int numOfGems;
		Boolean isGold;

		System.out.print("Enter jewelry type: ");
		name = input.nextLine();

		System.out.print("Enter number of gems: ");
		numOfGems = Integer.parseInt(input.nextLine());

		System.out.print("Is it gold [true/false]? ");
		isGold = Boolean.parseBoolean(input.nextLine());

		return new Jewelry(name, numOfGems, isGold);
	}

	// Function for creating shares by invoking its constructor
	private static Share createShare(){
		String name;
		int amount;
		double price;

		System.out.print("Enter share's name: ");
		name = input.nextLine();

		System.out.print("Enter number of shares: ");
		amount = Integer.parseInt(input.nextLine());

		System.out.print("Enter price:  ");
		price = Double.parseDouble(input.nextLine());

		return new Share(name, amount, price);
	}

	// Function for creating a device by invoking its constructor
	private static Device createDevice(){
		String name;
		double purchasePrice;
		int wearIndex;

		System.out.print("Enter device type: ");
		name = input.nextLine();

		System.out.print("Enter purchase price: ");
		purchasePrice = Double.parseDouble(input.nextLine());

		System.out.print("Enter wear index [1-10]:  ");
		wearIndex = Integer.parseInt(input.nextLine());

		return new Device(name, purchasePrice, wearIndex);
	}

	// Case '1' - Function for creating an account
	private static void createAccount(){
		System.out.print("Enter name: ");
		String accountName = input.nextLine();

		if (getAccountIndex(accountName) == -1){
			// If name is available
			Person newPerson = new Person(accountName);
			accounts.add(newPerson);

			System.out.print(distance + "Account successfully created!\nPress ENTER to continue." + distance);
			input.nextLine();
		}else{
			// If name is already used
			System.out.print(distance + "A person with the given name already exists!\nPress ENTER to continue." + distance);
			input.nextLine();
		}
	}

	// Case '2' - Function for registering item
	private static void registerItem(){
		System.out.print("Enter the name of the owner: ");
		String accountName = input.nextLine();

		// Checks if person with the given name exists
		if (getAccountIndex(accountName) == -1){
			System.out.print(distance + "Account with the given name does NOT exist!\nPress ENTER to continue." + distance);
			input.nextLine();
			return;
		}

		do{
			// Prints out a sub-menu and reads the input from the user
			System.out.print(distance);
			System.out.println("Item types");
			System.out.println("-- 1. Jewelry");
			System.out.println("-- 2. Shares");
			System.out.println("-- 3. Devices");
			System.out.println("-- 4. Go back to main menu\n");
			System.out.print("Choice: ");

			choice = input.nextLine();
			switch(choice){

			// Registering a jewelry
			case "1":
				try{
					accounts.get(getAccountIndex(accountName)).addItem(createJewelry());
					System.out.println("\nJewelry has been succesfully registered!");
					input.nextLine();
				}catch(NumberFormatException err){
					System.out.println("\nWrong input type, press ENTER to continue!" + "\nAdvanced users: error occurred " + err.getMessage().toLowerCase());
					System.out.println("Press ENTER to continue");
					input.nextLine();
				}
				break;

				// Registering shares
			case "2":
				try{
					accounts.get(getAccountIndex(accountName)).addItem(createShare());
					System.out.println("\nShare(s) has been succesfully registered!");
					System.out.println("Press ENTER to continue");
					input.nextLine();;
				}catch(NumberFormatException err){
					System.out.println("\nWrong input type, press ENTER to continue!" + "\nAdvanced users: error occurred " + err.getMessage().toLowerCase());
					System.out.println("Press ENTER to continue");
					input.nextLine();
				}
				break;

				// Registering devices
			case "3":
				try{
					accounts.get(getAccountIndex(accountName)).addItem(createDevice());
					System.out.println("\nDevice has been succesfully registered!");
					System.out.println("Press ENTER to continue");
					input.nextLine();
				}catch(NumberFormatException err){
					System.out.println("\nWrong input type, press ENTER to continue!" + "\nAdvanced users: error occurred " + err.getMessage().toLowerCase());
					System.out.println("Press ENTER to continue");
					input.nextLine();
				}
				break;

			case "4":
				return;

				// Incorrect input by user
			default:
				System.out.print(distance + "Incorrect input!\nChoose one of the available options ('1', '2', '3', '4').\nPress ENTER to continue.");
				System.out.println("Press ENTER to continue");
				input.nextLine();
			}
		}while(true);

	}

	// Case '3' - Function for removing account (person) or an item
	private static void removeUnit(){
		System.out.print("Enter the name of the owner: ");
		String accountName = input.nextLine();

		// Checks if person with the given name exists
		if (getAccountIndex(accountName) == -1){
			System.out.print(distance + "Account with the given name does NOT exist!\nPress ENTER to continue." + distance);
			input.nextLine();
			return;
		}

		do{
			// Prints out a sub-menu and reads the input from the user
			System.out.print(distance);
			System.out.println("-- 1. Remove one of "+ accounts.get(getAccountIndex(accountName)).getName() + "'s items");
			System.out.println("-- 2. Delete " + accounts.get(getAccountIndex(accountName)).getName() + " completely");
			System.out.println("-- 3. Go back to main menu\n");
			System.out.print("Choice: ");

			choice = input.nextLine();
			switch(choice){

			// Removing a belonging
			case "1":
				System.out.println(distance);
				System.out.println(accounts.get(getAccountIndex(accountName)).getName() + "'s belongings: ");
				for(int i = 0; i < accounts.get(getAccountIndex(accountName)).getAllItems().size(); i++){
					System.out.println(i+1 + ". " + accounts.get(getAccountIndex(accountName)).getAllItems().get(i).getName() + " \n\t " + accounts.get(getAccountIndex(accountName)).getAllItems().get(i).getValue() + "\n");
				}
				System.out.print("\nEnter index of item to be removed: ");

				try{
					accounts.get(getAccountIndex(accountName)).getAllItems().remove( (Integer.parseInt(input.nextLine())-1 ));
					System.out.println("\n\n\nItem as successfully been removed!");
					System.out.println("Press ENTER to continue");
					input.nextLine();
					return;
				}catch(NumberFormatException | IndexOutOfBoundsException err){
					System.out.println("\n\nWrong input type, press ENTER to continue!");
					System.out.println("Press ENTER to continue");
					input.nextLine();
					break;
				}

				// Deleting a person
			case "2":
				accountName = accounts.get(getAccountIndex(accountName)).getName();
				accounts.remove(getAccountIndex(accountName));
				System.out.println("\n" + accountName + " has been succesfully removed!");
				System.out.println("Press ENTER to continue");
				input.nextLine();
				return;

				// Returning to main menu
			case "3":
				return;

				// Incorrect input by user
			default:
				System.out.print(distance + "Incorrect input!\nChoose one of the available options ('1', '2', '3').\n");
				System.out.println("Press ENTER to continue");
				input.nextLine();
			}
		}while(true);
	}

	// Case '4' - Function that returns all registered accounts and there total value
	private static void showAllAccounts(){
		System.out.println("All accounts:");
		for(Person acc : accounts){
			System.out.println("\n* " + acc.getName() + "\n\t\t\t\t" + acc.getTotalValue());
		}

		System.out.println("\n\n\nPress ENTER to continue");
		input.nextLine();
	}

	// Case '5' - Function that shows richest account
	private static void showRichest(){
		Person accPointerA = accounts.get(0);
		Person accPointerB = accounts.get(0);

		for(Person acc : accounts){
			if (accPointerA.getTotalValue() < acc.getTotalValue()){
				accPointerA = acc;
			}
			else if(accPointerA.getTotalValue() == acc.getTotalValue()){
				accPointerB = acc;
			}
		}

		if (accPointerA.getTotalValue() == accPointerB.getTotalValue() && accPointerA != accPointerB){
			System.out.println("We have two equally rich persons - " + accPointerA.getName() + " and " + accPointerB.getName() + ".\n");
			System.out.println(accPointerA.getName() + " whose items got a total value of " + accPointerA.getTotalValue() + "\n");
			accPointerA.printAllItems();

			System.out.println(distance);

			System.out.println(accPointerB.getName() + " whose items got a total value of " + accPointerB.getTotalValue() + "\n");
			accPointerB.printAllItems();
		}else{
			System.out.println("Richest person is " + accPointerA.getName() + " whose items got a total value of " + accPointerA.getTotalValue() + "\n");
			accPointerA.printAllItems();
		}

		accPointerA = null;
		accPointerB = null;

		System.out.println("\n\n\nPress ENTER to continue");
		input.nextLine();
	}

	// Case '6' - Function that shows a specific person
	private static void showPerson(){
		System.out.print("Enter the name of the person: ");
		String accountName = input.nextLine();

		// Checks if person with the given name exists
		if (getAccountIndex(accountName) == -1){
			System.out.print(distance + "Account with the given name does NOT exist!\nPress ENTER to continue." + distance);
			input.nextLine();
			return;
		}

		System.out.println(distance + accounts.get(getAccountIndex(accountName)).getName() + " has a registered value of " + accounts.get(getAccountIndex(accountName)).getTotalValue());
		System.out.println("Items:\n");
		accounts.get(getAccountIndex(accountName)).printAllItems();

		System.out.println("\n\n\nPress ENTER to continue");
		input.nextLine();
	}

	// Case '7' - Function for initializing stockmarket crash
	private static void initStockCrash(){
		for(Person acc : accounts){
			for (Item x : acc.getAllItems()){
				if (x instanceof Share){
					((Share) x).setPrice(0);
				}
			}
		}
		System.out.println("\nThe main purpose of the stock market is\nto make fools of as many men as possible.\n - Bernard Baruch");
		System.out.println("\nPress ENTER to continue!");
		input.nextLine();
	}

	// Function that saves the current session
	private static void saveSession(){
		try{
			FileOutputStream file = new FileOutputStream("Stored_Data.vr");
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(accounts);
			out.close();
		}catch (IOException err){
			System.out.println("\nWarning!\nError occured during saving! Sorry about that..." + "\nAdvanced users: " + err.toString());
			input.nextLine();
			System.exit(1);
		}
	}

	// Function that reads previously saved session
	@SuppressWarnings("unchecked")
	private static void loadSession(){
		try {
			FileInputStream file = new FileInputStream("Stored_Data.vr");
			ObjectInputStream in = new ObjectInputStream(file);
			accounts = (ArrayList<Person>) in.readObject();
			in.close();
		}catch (IOException | ClassNotFoundException err) {
		}
	}


	// Main method
	public static void main(String[] args) {

		// Tries to load a previously saved session if there is any
		loadSession();

		// Menu
		do{
			// Prints out the menu
			System.out.println("$--------------- Value Register ---------------$");
			System.out.println(lines);
			System.out.println("1. Create account");
			System.out.println("2. Register item");
			System.out.println("3. Remove unit");
			System.out.println("4. Show all accounts");
			System.out.println("5. Show richest");
			System.out.println("6. Show specific account");
			System.out.println("7. Initialize stockmarket crash");
			System.out.println("8. Save & Exit");
			System.out.println(lines);

			// Waits and reads input from user
			System.out.print("Choice: ");
			choice = input.nextLine();

			// Switch
			switch(choice){

			// Create account
			case "1":
				System.out.println(distance + ">--------------- Create account ---------------<");
				createAccount();
				break;

				// Register item
			case "2":
				System.out.println(distance + ">--------------- Register item ---------------<");
				registerItem();
				System.out.println(distance);
				break;

				// Remove unit
			case "3":
				System.out.println(distance + ">--------------- Remove unit ---------------<");
				removeUnit();
				System.out.println(distance);
				break;

				// Show all accounts
			case "4":
				System.out.println(distance + ">------------- Show all accounts -------------<");
				showAllAccounts();
				System.out.println(distance);
				break;

				// Show richest
			case "5":
				System.out.println(distance + ">---------------- Show richest ---------------<");
				showRichest();
				System.out.println(distance);
				break;

				// Show specific account
			case "6":
				System.out.println(distance + ">----------- Show specific account -----------<");
				showPerson();
				System.out.println(distance);
				break;				

				// Initialize stockmarket crash
			case "7":
				System.out.println(distance + ">-------- Initialize stockmarket crash -------<");
				initStockCrash();
				System.out.println(distance);
				break;				

				// Exit
			case "8":
				saveSession();
				input.close();
				isRunning = false;
				break;

				// Incorrect input by user
			default:
				System.out.print(distance + "Incorrect input!\nChoose one of the available options ('1', '2', '3'...'7').\nPress ENTER to continue." + distance);
				input.nextLine();
			}
		}while(isRunning);
	}
}