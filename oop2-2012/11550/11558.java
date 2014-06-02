import java.util.Scanner;

public class Main {

	static private AddTo add = new AddTo();
	static private List li = new List();
	static private Remove rm = new Remove();
	private Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args)	{
		Main m = new Main();
		FileHandler fh = new FileHandler();
		AddTo add = new AddTo();
		String fileName = "Record.obj";  // File to read and store data
		fh.getFromFile(fileName);
		System.out.println("Hej och välkommen till Prylprogrammet");
		boolean cmd = true;
		while(cmd) {
			int menu = m.readInt("1 - Skapa person | 2 - Skapa pryl | 3 - Visa alla | 4 - Visa rikaste \n" +
					" 5 - Visa viss person | 6 - Börskrasch | 7 - Ta bort | 8 - Avsluta");
			if(m.numberExist(menu, 1, 10)) {
				switch (menu) {
				case 1: 
					m.createPerson();
					break;
				case 2:
					m.addGadget();
					break;
				case 3:
					li.listAllPerson();
					break;
				case 4:
					m.listPersonMostValue();
					break;
				case 5:
					m.listGadget();
					break;
				case 6:
					add.stockMarketChrash();
					break;
				case 7:
					m.remove();
					break;
				case 8:
					fh.saveToFile(fileName);
					cmd = false;
					break;
				default:
					break;
				}
			} else {
				System.out.println("Tyvärr, du matade in et felaktigt nummer, var god försök igen");
			}
		}
	}
	
	// Method for checking which person has the most value
	private void listPersonMostValue() {
		System.out.println("Rikast är " + li.listPersonMostValue()[0] + " med ett totalt värde på " + li.listPersonMostValue()[1]);
		li.listPersonGadget(li.listPersonMostValue()[0]);
	}

	// Method for displaying delete menu
	private void remove() {
		int type = readInt("1 - Person | 2 - Pryl");
		String name = null;
		switch (type) {
		case 1:
			name = choosePerson();
			if(!name.equals("empty")) {
				rm.removePerson(name);
			}
			break;
		case 2:
			name = choosePerson();
			if(!name.equals("empty")) {
				Gadget[] stuffArray = null;
				li.listPersonGadget(name, 1);
				stuffArray = li.listPersonGadget(name, 1);
				for(int i = 0 ; i < stuffArray.length ; i++) {
					System.out.println(i+1 + ".  " + stuffArray[i].getTypeName() + "    " + stuffArray[i].getName() + "    " + stuffArray[i].getValue());
				}
				removeGadget(name);
			}
			break;
		default:
			break;
		}
	}
	
	// Method asking user for a person, return name if exists
	private String choosePerson() {
		String name = readString("Ange önskad person: ");
		if (!personExist(name)) {
			System.out.println("Det finns tyvärr ingen person med namnet " + name);
		} else {
			return name;
		}
		name = "empty";
		return name;
	}
	
	// Method for removing specific gadget
	private void removeGadget(String name) {
		Gadget[] stuffArray = li.listPersonGadget(name, 1);
		int gadget = readInt("Ange nummeret på den pryl som du önskar ta bort:");
		if (!numberExist(gadget, 1, stuffArray.length)) {
			System.out.println("Den angivna prylen finns inte på listan!");
		} else {
			rm.removeGadget(gadget, name);
			System.out.println("Den valda prylen har raderas.");
		}
		
	}
	
	// Method for listing a specific persons gadgets
	private int listGadget() {
		li.listAllPerson();
		Gadget[] stuffArray = null;
		String name = choosePerson();
		if(!name.equals("empty")) {
			stuffArray = li.listPersonGadget(name, 1);
			for(int i = 0 ; i < stuffArray.length ; i++) {
				System.out.println(i+1 + ".  " + stuffArray[i].getTypeName() + "    " + stuffArray[i].getName() + "    " + stuffArray[i].getValue());
			}
		return stuffArray.length;
		}
		return 0;
		
	}
	
	// Method for checking if an integer is the right span, return true if correct
	private boolean numberExist(int input, int low, int max) {
		if(input >= low && input <= max) {
			return true;
		}
		return false;
	}

	// Method for creating a new person
	private void createPerson() {
		String name = readString("Nya personens namn: ");
		if(personExist(name)) {
			System.out.println("Det finns tyvärr redan en person med namnet " + name);
		} else {
			add.addPerson(name);
		}
	}

	// Method for displaying adding gadget menu
	private void addGadget() {
		String name = choosePerson();
		while(!name.equals("empty")) {
			int type = readInt("1 - Smycke | 2 - Aktie | 3 - Apparat");
			if(numberExist(type, 1, 3)) {
				switch (type) {
				case 1:
					String jewType = readString("Ange vilken typ av smycke: ");
					int matter = readInt("1 - Silver | 2 - Guld: ");
					int numGem = readInt("Antal juveler: ");
					add.addJewelry(name, jewType, matter, numGem);
					name = "empty";
					break;
				case 2:
					String shareType = readString("Ange namn pÂ aktie: ");
					int rate = readInt("Pris per aktie: ");
					int amount = readInt("Antal: ");
					add.addShare(name, shareType, rate, amount);
					name = "empty";
					break;
				case 3:
					String applianceType = readString("Ange vilken typ av apparat: ");
					int costPrice = readInt("Inköpspris: ");
					int wear = readInt("Slitage (10 = ny, 1 = redo för tippen): ");
					add.addAppliance(name, applianceType, costPrice, wear);
					name = "empty";
					break;
				default:
					break;
				} 
			} else {
				System.out.println("Tyv‰rr var nummret felaktigt, var god fˆrsˆk igen");
			}
		}
	}	
	
	// Check if a person with the same name exist in the system
		private boolean personExist(String name) {
			for (Person p : AddTo.all) {
				if (p.getName().equalsIgnoreCase(name)) {
					return true;
				}
			}
			return false;
		}
			
		// Ask user for an integer and check if true
		private int readInt(String question)	{
			for ( ; ; ) {
				try	{
					System.out.print(question + "\n>");
					int x=Integer.parseInt(keyboard.nextLine());
					return x;
				}
				catch (NumberFormatException e)	{
					System.out.println("Fel - skall vara numeriskt värde");
				}
			}
		}
			
		// Ask user for a string
		private	String readString(String question)	{
			System.out.println(question + "\n>");
			String str=keyboard.nextLine();
			return str;
		}	
}

