import java.util.Scanner;
import java.util.ArrayList;

public class MainProgram {

	public static Scanner keyboard = new Scanner(System.in);
	public static ArrayList<Stuff> allStuff = new ArrayList<Stuff>();
	public static ArrayList<Person> persons = new ArrayList<Person>(); 

	public static void main(String[] args) {

		MainProgram mp = new MainProgram();

		int loop = 0;
		while (loop !=1){
			System.out.println("Vad šnskar ni gšra? \n-------------------- \n1. Skapa person\n2. Skapa pryl\n3. Visa alla\n4. Visa rikaste\n5. Visa viss person\n6. Bšrskrasch\n7. Avsluta");
			int choice = readInt("> ");

			switch (choice){
			case 1:	mp.createPerson(); break;			// Skapa person
			case 2: mp.createStuff(); break;			//	Registrera pryl
			case 3: mp.showAll(); break;				//  Visa alla
			case 4: mp.showWealthiest(); break;			//	Visa rikaste
			case 5: mp.showPerson(); break;				//	Visa viss person	
			case 6: mp.stockCrash(); break;				//	Bšrskrasch
			case 7:	loop = 1; System.exit(0); break;	// Avsluta programmet
			default: System.out.println("Felaktigt kommando. Fšrsšk igen.");
			}
		}

	}


	private static String readString(String prompt){
		String str ="";
		System.out.print(prompt);
		while (str.equals("")){
			str = keyboard.nextLine();
		}
		return str;
	}


	private static int readInt(String prompt){
		for (;;){
			try{
				System.out.print(prompt);
				String check = keyboard.nextLine();
				int number = Integer.parseInt(check);
				return number;
			} 
			catch (NumberFormatException e){
				System.out.println("Felaktigt kommando - ska vara ett numeriskt vŠrde");
			}
		}

	}


	void createPerson() {	// Skapa person
		int count = 0;
		String name = readString("Namn pŒ person > ");
		name = name.toLowerCase();

		for (int q = 0 ; q< persons.size(); q++ ){
			if( persons.get(q).getPerson().equals(name)) {
				count++;
			}
		}

		if (count == 0){
			persons.add(new Person(name));
		} else {
			System.out.println("Redan registrerad person");
		}

	}


	void createStuff(){		// Registrera pryl

		String subThing = null;
		String gold = null;
		int quantity = 0;
		int purchasePrice = 0;
		int tare = 0;
		int registrationChoice = 0;
		int registerdNameValue = 0;
		String owner = readString("€gare > ");
		owner = owner.toLowerCase();

		for( int q = 0; q < persons.size(); q++){

			if (persons.get(q).getPerson().equals(owner)) {
				registerdNameValue++;}
		}
		if (registerdNameValue == 0){
			System.out.println("Ej registerad anvŠndare");
		}else {

			int a = 0;
			String thing = readString("Vilken sorts pryl > ");
			thing = thing.toLowerCase();	

			while ( a == 0){
				if (thing.equals("smycke") || thing.equals("smycken") || thing.equals("aktie") || thing.equals("aktier") || thing.equals("apparat") || thing.equals("apparater")){
					a = 1;
				}else {
					System.out.println("Felaktig pryl. I dagslŠget kan vi bara registrera aktier, smycken och apparater. Var god fšrsšk igen.");
					thing = readString("Vilken sorts pryl >");
				}  
			}

			if (thing.equals("smycke") || thing.equals("smycken")){
				registrationChoice = 1;
			} else {
				if (thing.equals("aktie") || thing.equals("aktier")){ 
					registrationChoice = 2;
				} else { 
					if (thing.equals("apparat") || thing.equals("apparater")){
						registrationChoice = 3;
					} 
				}
			}

			switch (registrationChoice){

			case 1:			//	Skapa smycke
				subThing = readString("Vilken storts "+ thing +" > ");
				gold = readString("€r ditt " +subThing +" av guld (Ja/Nej) > ");
				gold = gold.toLowerCase();
				quantity = readInt("Antal Šdelstenar > ");

				allStuff.add(new Jewelery(owner, thing, subThing, gold, quantity));
				break;

			case 2:			//	Skapa aktie
				subThing = readString("Namn pŒ "+thing +" > ");
				quantity = readInt("Antal " +thing + " > ");	
				purchasePrice = readInt("Inkšpspris pŒ " +thing +" > ");

				allStuff.add(new Stock(owner, thing, subThing, quantity, purchasePrice));
				break;

			case 3:			//	Skapa apparat
				subThing = readString("Namn pŒ "+thing +" > ");
				purchasePrice = readInt("Inkšpspris pŒ " +thing +" > ");
				tare = readInt("Slitage pŒ " +thing + " > ");

				allStuff.add(new Appliance(owner, thing, subThing, purchasePrice, tare));
			}
		}


	}


	void showAll(){		// Visa alla

		double personsRiches = 0; 

		for (int t = 0 ; t < persons.size(); t++){
			for (int u = 0; u <allStuff.size(); u ++){
				if (persons.get(t).getPerson().equals(allStuff.get(u).getOwner())){
					personsRiches = personsRiches + allStuff.get(u).getValue();
				}
			}

			System.out.println(persons.get(t).getPerson() +" " +personsRiches);
			personsRiches = 0;
		}

	}


	void showWealthiest(){	// Visa rikaste personen
		
		double richValue = 0; 
		double wealth = 0;
		String wealthiestPerson = null;

		for (int t = 0 ; t < persons.size(); t++){
			for (int u = 0; u <allStuff.size(); u ++){
				if (persons.get(t).getPerson().equals(allStuff.get(u).getOwner())){
					richValue = richValue + allStuff.get(u).getValue();	
				}
			}

			if (richValue > wealth){
				wealth = richValue;
				wealthiestPerson = persons.get(t).getPerson();
			}

			richValue = 0;
		}

		System.out.println("Rikast Šr " +wealthiestPerson + " som sammanlagt Šger " +wealth);

		for (int i = 0; i < allStuff.size(); i++){
			if (allStuff.get(i).getOwner().equals(wealthiestPerson)){
				System.out.println(allStuff.get(i).getSubStuff() +" " + allStuff.get(i).getValue());
			}
		}

	}


	void showPerson(){		//Visa enskild person

		int searchValue = 0;
		String who = readString("Vem vill du titta pŒ > ");
		who = who.toLowerCase();
		for (int o = 0; o < persons.size(); o++){
			if (persons.get(o).getPerson().equals(who)){
				System.out.println(who +" Šger fšljande:");

				for (int p = 0; p < allStuff.size(); p++){
					if (allStuff.get(p).getOwner().equals(who)){
						System.out.println(allStuff.get(p).getSubStuff() +" " + allStuff.get(p).getValue());
					}
				}

				searchValue++;
			}
		}

		if (searchValue == 0){
			System.out.println("Ej registrerad person");
		}

	}


	void stockCrash(){		// Skapa bšrskrasch, dvs. alla aktier fŒr priset 0

		for (int a = 0 ; a < allStuff.size(); a++){
			if (allStuff.get(a).getStuff().equals("aktie") || allStuff.get(a).getStuff().equals("aktier")){
				allStuff.get(a).setPrice(0);
			}
		}

	}


}



