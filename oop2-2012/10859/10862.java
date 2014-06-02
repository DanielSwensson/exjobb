package pr;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Marc Balbo
 * @version 1.5
 * @since 2013-01-16
 * 
 *        PrylRegister: PrylReg:Huvudklass
 */

public class PrylReg {
    static ArrayList<Person> perrsonArray = new ArrayList<Person>();
    static SaveLoad sl = new SaveLoad("PR.save");
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
	System.out.println("Välkommen till Prylregistret");

	try {// felhantering
	    for (;;) {

		System.out.println("\ntryck 1 för att Skapa person");
		System.out.println("tryck 2 för att Skapa pryl.");
		System.out.println("tryck 3 för att Visa alla.");
		System.out.println("tryck 4 för att Visa rikaste.");
		System.out.println("tryck 5 för att Visa viss person.");
		System.out.println("tryck 6 för att Börskrasch.");
		System.out.println("tryck 7 för att Avsluta.");
		System.out.println("tryck 8 för att Spara.");
		System.out.println("tryck 9 för att Ladda.");

		System.out.print("Choose menu item: ");
		int chs = menuChooser();
		switch (chs) {
		case 1:
		    System.out.println("Skapa person");
		    skapaPerson();
		    break;
		case 2:
		    System.out.println("Skapa pryl");
		    skapaPryl();
		    break;
		case 3:
		    System.out.println("Visa alla.");
		    visaAlla();
		    break;
		case 4:
		    System.out.println("Visa rikaste.");
		    visaRikaste();
		    break;
		case 5:
		    System.out.println("Visa viss person.");
		    visaVissPerson();
		    break;
		case 6:
		    System.out.println("Börskrasch.");
		    borskrasch();
		    break;
		case 7:
		    System.out.println("Avslutat");
		    in.close();
		    System.exit(0);

		    break;
		case 8:
		    System.out.println("Spara.");
		    sl.Save(perrsonArray);
		    break;
		case 9:
		    System.out.println("Ladda");
		    perrsonArray = sl.Load();
		    break;
		default:
		    System.out.println("Invalid choice.");
		}

	    }
	} catch (Exception e) {
	    System.out.println("övrig fel input" + e);
	}
    }

    private static void skapaPerson() { // skapar en ny person instants och
	// sparar den i arrayen perrsonArray
	String namn = readString("Nya personens namn: ");
	Person p = getPerson(namn);
	if (p != null)
	    System.out.println("Den personen finns redan");
	else {
	    Person ny = new Person(namn);
	    perrsonArray.add(ny);
	}
    }

    private static void skapaPryl() { 	// anroppar metoder i person instantsena
					// som skapar en ny pryl instants och
					// sparar den i arrayen prylArray
	String typ = null;
	String namn = readString("Vilken person äger prylen: ");
	Person p = getPerson(namn);
	if (p != null) {
	    typ = readString("Vilken sorts pryl[1. Aktie/ 2. Apparat/3. Smycke]");

	    if (typ.equalsIgnoreCase("1") || typ.equalsIgnoreCase("Aktie")) {
		String prylNamn = readString("Vilket Namn");
		int antal = readInt("Vilket antal");
		int pris = readInt("Vilket pris");
		p.addAktie(prylNamn, antal, pris);
		p.getFormogenhet();

	    } else if (typ.equalsIgnoreCase("2")
		    || typ.equalsIgnoreCase("Apparat")) {
		String prylNamn = readString("Vilket Namn");
		int pris = readInt("Vilket pris");
		int slitaget = readInt("Hur sliten [1-10]");
		p.addApparat(prylNamn, pris, slitaget);
		p.getFormogenhet();

	    } else if (typ.equalsIgnoreCase("3")
		    || typ.equalsIgnoreCase("Smycke")) {
		String sort = readString("Vilket sorts smycke");
		String gold = readString("Är smycket av guld");

		int adelstenar = readInt("Antal ädelstenar");
		p.addSmycke(sort, gold, adelstenar);
		p.getFormogenhet();

	    } else {
		System.out.println("Fel Typ");
		// break;
	    }

	} else {
	    System.out.println("Den personen finns inte");
	    // break;
	}

    }

    private static void visaAlla() {
	for (int i = 0; i < perrsonArray.size(); i++) {
	    System.out.println(" "
		    + ((Person) perrsonArray.get(i)).getName().toString() + " "
		    + ((Person) perrsonArray.get(i)).getFormogenhet());
	}
    }

    private static void visaRikaste() {
	
	try {
	    double rikY = 0;
	    int rikX = 0;
	    for (int i = 0; i < perrsonArray.size(); i++) {
	        if (((Person) perrsonArray.get(i)).getFormogenhet() > rikY) {
	    	rikX = i;
	    	rikY = ((Person) perrsonArray.get(i)).getFormogenhet();
	        }
	    }
	    System.out.println(" "
	    	+ ((Person) perrsonArray.get(rikX)).getName().toString()
	    	+ " är rikast med en förmögenet på  "
	    	+ ((Person) perrsonArray.get(rikX)).getFormogenhet());
	    ((Person) perrsonArray.get(rikX)).listaPryl();
	} catch (IndexOutOfBoundsException e) {
	    System.out.println("finns ingen i arrayen, lägg till en individ");
	    
	}catch (Exception e) {
	    
	    e.printStackTrace();
	}

    }

    private static void visaVissPerson() {
	String namn = readString("Vem vill du visa? : ");
	Person p = getPerson(namn);
	if (p != null) {
	    System.out.println("" + p.getName() + "");
	    p.listaPryl();
	} else {

	}
    }

    private static void borskrasch() {
	for (Object person : perrsonArray) {
	    for (Pryl pryl : ((Person) person).getPrylArray()) {
		if (pryl instanceof Aktie) {// om ett objekt i arraten är av
		    // typen Aktie
		    ((Aktie) pryl).setPris(0);// sätter aktiens värde till 0
		}
	    }
	}
    }

    private static Person getPerson(String namn) { // hämtar och returerar en
	// person efter dess namn
	for (Object p : perrsonArray)
	    if (((Person) p).getName().equalsIgnoreCase(namn))
		return (Person) p;
	return null;
    }

    private static int menuChooser() { // tillåter int´s mellan 1 och 9
	try {
	    int x = 0;
	    do {
		if (in.hasNext("[1-9]")) {
		    x = in.nextInt();
		} else {
		    in.next();
		    System.out.println("var god forsök igen! ");
		}
	    } while (x < 1 || x > 9);
	    {
		return x;
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return 0;
    }

    private static int readInt(String string) {
	// läser in int och kontrolerar
	// att det är siffror som matas in
	System.out.println(string);
	int inty = 0;

	while (!in.hasNextInt()) { // kontrolerar om nästa tecken i strömmen är
	    // en siffra
	    System.out.println("Bara Siffror: ");
	    in.next(); // om inte så går den till nästa tecken
	}
	inty = in.nextInt();
	return inty;
    }

    private static String readString(String string) {
	System.out.println(string);
	String str = in.next();
	return str;
    }

}
