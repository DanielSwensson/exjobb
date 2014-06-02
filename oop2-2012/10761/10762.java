import java.util.Scanner;
import java.util.ArrayList;

public class Register {
	private static Scanner myScanner = new Scanner(System.in);
	private static ArrayList<Person> persons = new ArrayList<Person>();
	private static Person findPerson(String name){
		for (Person person : persons) {
			if(person.getName().equalsIgnoreCase(name)){
				return person;
			}
		}
		return null;
	}
	
	private static void printHelp() {
		System.out.println("Availible commands are:");
		System.out.println(
				"   help:        this command\n" +
				"   list:        list all persons\n" +
				"   listperson:  list a persons possesion\n" +
				"   findrichest  find the person with the highest welth and print belongings\n"+
				"   addperson:   register a new person\n" +
				"   addvaluable: register a new valuable\n" +
				"   crash:       make any currently owned stock worthless\n" +
				"   exit:        exit the program"
				);
	}
	
	public static int promptInt(String Message, String prompt) {
		int myInt=-1;
		System.out.println(Message);
		System.out.flush();
		myInt=readInt(prompt);
		
		while ( myInt < 0 ){
			System.out.println("Invalid entry, please retry");
			myInt=readInt(prompt);
		} 	
		return myInt;
	}
	
	public static String promptString(String Message, String prompt) {
		String myString;
		System.out.println(Message);
		System.out.flush();
		myString=readString(prompt);
		while (myString.isEmpty()){
			System.out.println("Nothing entered, please retry");
			myString=readString(prompt);
		} 	
		return myString;
	}
	
	private static String readString(String prompt) {
		System.out.print(prompt);
		String str = myScanner.nextLine();
		return str;
	}
	
	private static int readInt(String prompt) {
		int number=0;
		System.out.print(prompt);
		try {
			number = myScanner.nextInt();
		} catch(java.util.InputMismatchException e) {
			number = -1;
		}
		myScanner.nextLine();
		return number;
	}
	
	private static void addPerson() {
		String name=promptString("Enter name","name: ");
		Person newPerson= new Person(name);
		persons.add(newPerson);
		// debug print */ System.out.println(""+newPerson);
	}

	private static void addValuable() {
		Person person=null;
		Valuable valuable=null;
		String name=null;
		String type;

		while (	person == null) {
			name=promptString("Enter owner of the new item","name: ");
			person=findPerson(name);
			if (person==null) {
				System.out.println("\""+name+"\" Not found, try again!");
			}
		} 
		
		while (	valuable == null) {
			type=promptString("Enter valuable type, jewelry, device, stock","Type: ").trim();
			person=findPerson(name);

			if (type.equalsIgnoreCase("jewelry")){
				valuable= new Jewelry();
			} else if (type.equalsIgnoreCase("stock")) {
				valuable= new Stock();
			}else if (type.equalsIgnoreCase("device")) {
				valuable= new Device();
			}
		} 

		person.addValuable(valuable);		
	}
		
	private static void list() {
		for (Person person : persons) {
			System.out.println(person);
		}
	}
	
	private static void findRichest() {
		Person personOfInterest=null;
		for (Person person : persons) {
			//check if null before attempting to get welth or face a nullpointer!
			if ((personOfInterest == null) || (person.getWelth() > personOfInterest.getWelth())){
				personOfInterest=person;
			}
		}
		System.out.println(personOfInterest);
		
		for(Valuable valuable : personOfInterest.getValuables()){
			System.out.println(valuable);
		}

	}
	
	private static void listPerson() {
		String name=promptString("Enter person to list","name: ");

		Person personOfInterest = findPerson(name);

		if(personOfInterest instanceof  Person) {
			for(Valuable valuable : personOfInterest.getValuables()){
				System.out.println(valuable);
			}
		}
	}

	private static void stockCrash() {
		System.out.println("All stocks are now worthless.");
		for(Person person : persons){
			for(Valuable valuable:person.getValuables()){
				valuable.crash();
			}
		}
	}
	
	public static void main(String[] args) {
		String command;
		boolean exit = false;
		System.out.println("Welcome to Värderegistret 0.1 type \"help\" for a list of availible commands");
		/*/DEBUG */ persons.add(new Person()); 
		
		while (exit == false) {
			command=readString("> ");
			if (command.equals("help")) {  //java 1.6 compatible...
				printHelp();
				
			} else if (command.equals("listperson")|| command.equals("lp")) {
				listPerson();
								
			} else if (command.equals("list")) {
				list();

			} else if (command.equals("findrichest")) {
				findRichest();
			
			} else if (command.equals("addperson")|| command.equals("addp") ) {
				addPerson();
				
			} else if (command.equals("addvaluable") || command.equals("addv") ) {
				addValuable();
				
			} else if (command.equals("crash") || command.equals("addv") ) {
				stockCrash();
				
			} else if (command.equals("exit")) {
				exit = true;
				System.out.println("Good bye");

			} else if (command.isEmpty() ) {
				//if empty noop
			} else {
				System.out.println("   Unknown command \""+command+"\", try \"help\"");
			}
		}
		System.err.println("program terminated"); //debug print, stderr for the colours
	}
}
