
public class Menu {

	private static Register register = new Register();

	private void addThingMenuHelp() {
		System.out.println("Make your choice by typing in one of the following commands: " + 
				"\n1. Jewellery " +
				"\n2. Share " +
				"\n3. Appliance");
	}

	public void addThingMenu() {

		addThingMenuHelp();

		while (true) {
			String command = register.readString(">").toLowerCase();
			switch (command) {
			case "1":
			case "jewellery":
				register.addJewellery();
				break;
			case "2":
			case "share":
				register.addShare();
				break;
			case "3":
			case "appliance":
				register.addAppliance();
				break;
			case "help":
				addThingMenuHelp();
				break;
			default:
				System.out.println("'" + command + "' is not recognized as a command. Type help for a list of commands.");
				break;
			}
		}	
	}

	private void mainMenuHelp() {
		System.out.println("Person and thing registration [Version 1.0.1337]" +
				"\nMake your choice by typing in one of the following commands: " +
				"\n1. Add person" +
				"\n2. Add thing" +
				"\n3. Show all persons" +
				"\n4. Show richest person" +
				"\n5. Show person" +
				"\n6. Stock market crash" +
				"\n7. Help" +
				"\n8. Exit");
	}

	public void mainMenu() {
		while (true) {
			String command = register.readString(">").toLowerCase();
			switch (command) {
			case "1":
			case "add person":
				register.addPerson();
				break;
			case "2":
			case "add thing":
				register.addThing();
				break;
			case "3":
			case "show all persons":
				register.showAllPersons();
				break;
			case "4":
			case "show richest person":
				register.showRichestPerson();
				break;
			case "5":
			case "show person":
				register.showPerson();
				break;
			case "6":
			case "stock market crash":
				register.startStockMarketCrash();
				break;
			case "7":
			case "help":
				mainMenuHelp();
				break;
			case "8":
			case "exit":
				exitProgram();
				break;
			default:
				System.out.println("'" + command + "' is not recognized as a command. Type help for a list of commands.");
				break;
			}
		}	
	}

	private void exitProgram() {
		System.out.println("Closing... " +
				"\nYou can now safely close the program.");
		System.exit(0);
	}

	public static void main(String[] args) {

		Menu menu = new Menu();

		menu.mainMenuHelp();
		menu.mainMenu();

	}

}