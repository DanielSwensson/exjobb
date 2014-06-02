import java.util.ArrayList;
import java.util.Scanner;

public class Register {

    private ArrayList<Person> register = new ArrayList<Person>();
    static Scanner input = new Scanner(System.in);

    // Prompt displayed in the main input sequence
    static final String PROMPT = "> ";
    
    private Person findPerson(String name) {
	/*
	  Searches for a person in the register
	  returns null if the name is not found
	*/
	for(Person p : register) {
	    if(p.getName().equalsIgnoreCase(name)) {
		return p;
	    }
	}
	
	return null;
    }
    
    private String addPerson() {
	/*
	  Presents a dialoge for creating and adding
	  a person to the register. It checks if there's
	  allready a person with the same name in the register.
	*/
	String name = getString("Namn på person: ");
	// Check if the given name is already in the register
	for(Person p : register) {
	    if(p.getName().equals(name)) {
		/* 
		   if a person with the given name is in the register
		   return a string indicating that
		*/
		return "Personen finns redan i registret";
	    }
	}
	
	/*
	  If the person doesn't exist in the register add the new
	  person and return a string indicating that the person 
	  has been added.
	*/
	register.add(new Person(name));
	return "Personen " + name + " har lagts till i registret";
    }
    
    private void addThing() {
	/*
	  Command interface to add a thing to the register.
	*/

	String whatThing;
	Person owner;

	if(register.isEmpty() == true) {
	    System.out.println("Det finns inga personer i registret: ");
	    return;
	}
	
	else {
	    System.out.println("Personer som finns i registret:");
	    for(Person p : register) {
		System.out.println(p.getName());
	    }
	}
	
	while(true) {
	    owner = findPerson(getString("Vem äger prylen: "));
	    if(owner == null) {
		System.out.println("Personen finnns inte i registret");
		return;
	    }
	    
	    else {
		break;
	    }
	}

	System.out.println("Prylar som kan ägas");
	System.out.print("Smycke \n" + 
			 "Apparat \n" +
			 "Aktie \n");

	while(true) {

	    whatThing = getString("Vilken sorts pryl: ");

	    switch(whatThing.toLowerCase()) {
	    case "smycke":
		addJewellery(owner);
		return;
	    case "aktie": 
		addStock(owner);
		return;
	    case "apparat":
		addGadget(owner);
		return;
	    default:
		System.out.println("Känner inte igen sak");
	    }
	}
    }

    private void addJewellery(Person owner) {
	/*
	  Adds a Thing of type Jewellery to the current register
	*/

	String sort = getString("Vilket sorts smycke: ");
	String gold;
	
	while(true) {
	    gold = getString("Är smycket av guld (Ja / Nej): ");
	   
	    if(!gold.equalsIgnoreCase("ja") && !gold.equalsIgnoreCase("nej")) {
		System.out.println("Vänligen ange Ja eller Nej");
	    }

	    else {
		break;
	    }
	}
	
	Boolean isGold = getBooleanFromString(gold);
	
	int gemstones = getInteger("Hur många ädelstenar: ");

	owner.addNewThing(new Jewellery(sort, gemstones, isGold));
    }

    private void addStock(Person owner) {
	/*
	  Adds a Thing of type Stock to the current register
	*/
	
	String name  = getString("Namn på aktien: ");
	double price = getDouble("Pris på aktien: ");
	int number   = getInteger("Antal akteier köpta: ");

	owner.addNewThing(new Stock(name, price, number));
	    
    }
    
    private void addGadget(Person owner) {
	/*
	  Adds a Thing of type Gadget to the current register
	*/
	
	String name  = getString("Namn på apparat: ");
	int wear     = getInteger("Hur mycket slitage (1-10): ");
	double price = getDouble("Inköpspris: ");

	owner.addNewThing(new Gadget(name, price, wear));
    }
    

    private boolean getBooleanFromString(String bool) {
	/*
	  This function will try to parse the input and see if it matches
	  the swedish words, ja/nej and retun a boolean value accordingly.
	  Ja = true, Nej = False.
	*/

	if(bool.equalsIgnoreCase("ja")) {
	    return true;
	}

	else {
	    return false;
	}
    }

    private String getString(String message) {
	/* 
	   Get a string from standard input
	   This function also does not except digits as input
	*/
	while(true) {
	    
	    System.out.print(message);
	    String nextString = input.nextLine();
	    
	    try {
		Double.parseDouble(nextString);
		throw new NotAValidStringException("String does not contain letters only");
	    }
	    catch(NotAValidStringException e) {
		System.out.println("Ange bara bokstäver");
	    }
	    catch(NumberFormatException e) {
		return nextString;
	    }
	}
    }
    
    private int getInteger(String message) {
	// Get an integer from standard input

	int nextInt;
	
	while(true) {
	    try {
		System.out.print(message);
		nextInt = Integer.parseInt(input.nextLine());
		return nextInt;
	    }
	    
	    catch(NumberFormatException e) {
		System.out.println("Vänligen ange ett heltal");
	    }
	}
    }
    
    private double getDouble(String message) {
	// Get a double from the standard input

	double nextDouble;

	while(true) {
	    try {
		System.out.print(message);
		nextDouble = Double.parseDouble(input.nextLine());
		return nextDouble;
	    }
	    
	    catch(NumberFormatException e) {
		System.out.println("Vänligen ange ett decimaltal");
	    }
	}
    }


    private void showAll() {
	/* 
	   Prints out all the persons in the register
	   If there are no persons in the register i.e
	   if the size of the ArrayList equals 0 prints 
	   out a string indicating that the list is empty
	*/
	if(register.isEmpty() == false) {
	    for(Person p : register) {
		System.out.println(p);
	    }
	}
	else {
	    System.out.println("Det finns inga personer i registret");
	}
    }

    private void showRichest() {
	/* 
	   Prints out the richest person in the register
	   by looping through the register and comparing
	   the total worth of the person.
	*/
	Person richest = null;
	double richestWorth = 0;

	for(Person p : register) {
	    if(p.getTotalWorth() > richestWorth) {
		richest = p;
		richestWorth = p.getTotalWorth();
	    }
	}
	if (richest == null) {
	    System.out.println("Inga personer i registret");
	}
	else {
	    System.out.println(richest);
	}
    }

    private void globalMarketCrash() {
	/*
	  Sets all of the stock values owned
	  by every person in the register to 0
	*/
	for(Person p : register) {
	    p.marketCrash();
	}
    }

    private void printHelp() {
	/*
	  Prints out the commands available
	*/
	System.out.println("Dessa kommando finns tillgänliga:");
	System.out.println();
	System.out.print("skapa person: Skapa en ny person i registret \n" +
			 "visa person:  Visa en viss person \n"  + 
			 "visa alla:    Visa alla personer i registret \n"    + 
			 "visa rikaste: Visa den rikaste personen i registret \n" + 
			 "skapa pryl:   Skapa en ny pryl för en person \n"   +
			 "börscrash:    Sätt alla aktievärden till 0 \n"    +
			 "avsluta:      Avsluta programmet \n");
    }

    public void run() {

	Register reg = new Register();
	String command;
	
	System.out.println("Skriv hjälp för att få se vilka kommandon som finns tillgängliga");

	while(true) {
	    
	    command = reg.getString(PROMPT);
	    
	    switch (command.toLowerCase()) {

	    case "skapa person":
		System.out.println(addPerson());
		break;

	    case "skapa pryl":
		addThing();
		break;

	    case "visa alla":
		showAll();
		break;

	    case "visa rikaste":
		showRichest();
		break;

	    case "visa person":

      	        String name = getString("Namn på person: ");
	        Person person = findPerson(name);

		if(person == null) {
		    System.out.println("Personen finnns inte i registret");
		}
		
		else {
		    System.out.println(person);
		    person.printAllThings();
		}

		break;

	    case "börscrash":
		globalMarketCrash();
	        break;

  	    case "avsluta":
		System.exit(0);

	    case "hjälp":
		printHelp();
		break;
	    default:
		System.out.print("Okänt kommando \n" +
				 "Skriv hjälp för se alla kommandon \n");
	    }
	}
    }
}
