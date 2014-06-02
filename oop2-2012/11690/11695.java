import java.util.*;

public class Register {

	static Scanner keyboard = new Scanner (System.in); 
	static ArrayList<Person> allaPersoner = new ArrayList<Person>();

	public static void main(String[] args) {
		String command="";
		
		while (true) {

			System.out.println("1. Skapa person \n2. Skapa pryl \n3. Visa alla \n4. Visa rikaste \n5. Visa viss person \n6. Borskrasch \n7. Avsluta \n");
			command = keyboard.nextLine();
			System.out.println();

			switch (command) {
			case "1":
				regPerson();
				break;
			case "2":
				regPryl();
				break;
			case "3":
				listaAllt();
				break;
			case "4":
				listaRikaste();
				break;
			case "5":
				listaPerson();
				break;
			case "6":
				borskrasch();
				break;
			case "7":
				System.out.println("");
				System.out.println("Program avslutat");
				System.exit(0);
				break;
			default:
				System.out.println("Felaktikt kommando");
				System.out.println();
				break;

			}
		}
	}

	private static Person getNamn (String namn) {
		for (Person m : allaPersoner)
			if ( m.getNamn().equalsIgnoreCase(namn))
				return m;
		return null;
	}

	public static void regPerson() {
		try {
		    System.out.print("Skriv in namn:" + " ");
		    String namn = keyboard.nextLine();
		    Person m = getNamn(namn);
		    if (m!=null)
		    	System.out.println("Personen finns redan i registret");

		    else{
		    	allaPersoner.add(new Person( namn ));
		    	System.out.println("Person sparad");
		    	System.out.println();
		    }
		} catch (Exception e) {
		    System.out.println("\nFelaktig inmatning!!!"+"\n"+e.getMessage()+"\n");
		   
		}
	}

	public static void regPryl() {
		try {
		    while (true) {
			System.out.print("Skriv in ägarens namn:" + " ");
			String namn = keyboard.nextLine();
			Person m = getNamn(namn);
			System.out.println();

			if (m == null)
			    System.out.println("Personen finns ej i systemet");
			else {

			    System.out
				    .println("1. Aktie \n2. Smycke \n3. Apparat \n");
			    String val = keyboard.nextLine();

			    switch (val) {
			    case "1":
				System.out.println();
				System.out.println("Vad heter aktien?");
				String aktieTyp = keyboard.nextLine();
				System.out.println("Hur många aktier har du?");
				int antalAktie = Integer.parseInt(keyboard
					.nextLine());
				System.out
					.println("Vad ar priset for aktierna?");
				int aktiePris = Integer.parseInt(keyboard
					.nextLine());
				Aktier aktie = new Aktier(aktieTyp, antalAktie,
					aktiePris);
				m.addPryl(aktie);
				break;
			    case "2":
				System.out.println();
				System.out
					.println("Vad ar det får typ av smycke?");
				String smyckeTyp = keyboard.nextLine();
				System.out
					.println("är smycket av guld eller silver?");
				String guldSilver = keyboard.nextLine();
				System.out
					.println("Hur många ädelstenar har smycket?");
				int antaladelsten = Integer.parseInt(keyboard
					.nextLine());
				Smycken smycke = new Smycken(smyckeTyp,
					guldSilver, antaladelsten);
				m.addPryl(smycke);
				break;
			    case "3":
				System.out.println();
				System.out
					.println("Vad ar det for typ av apparat?");
				String typApparat = keyboard.nextLine();
				System.out
					.println("Vad är priset på apparaten?");
				int nPris = Integer.parseInt(keyboard
					.nextLine());
				System.out
					.println("Vad är slitskadorna? 1-10, 10 betyder helt ny och 1 mycket sliten");
				int slitskada = Integer.parseInt(keyboard
					.nextLine());
				Apparater apparat = new Apparater(typApparat,
					nPris, slitskada);
				m.addPryl(apparat);
				break;
			    default:
				System.out.println("Felaktikt kommando");
				System.out.println();
				break;
			    }
			    System.out.println("Pryl sparad \n");
			}
			break;
		    }
		} catch (Exception e) {
		    System.out.println("Felaktig inmatning!!!"+"\n"+e.getMessage());
		}
	}

	public static void listaAllt() {
		System.out.println("I registret finns:");
		for (int i = 0; i < allaPersoner.size(); i++){
			System.out.println(allaPersoner.get(i)+ " ");
			System.out.println();
		}	
	}

	public static void listaRikaste() {
		int pIndex=0 , fm=0;
		for (int i = 0; i < allaPersoner.size(); i++){
			if (allaPersoner.get(i).getVarde()>fm){
				pIndex=i;
				fm=allaPersoner.get(i).getVarde();


				System.out.println("Rikaste är " + allaPersoner.get(pIndex).getNamn() + " som sammanlagt äger " + allaPersoner.get(pIndex).getVarde());	
				allaPersoner.get(pIndex).listaPrylar();
			}
		}	
	}

	public static void listaPerson() {
		System.out.println("Uppge namn på den du säker:");
		String vem = keyboard.nextLine();

		int indexPerson = -1;
		boolean namn = false;	
		for (int i = 0; i < allaPersoner.size(); i++) {
			if (allaPersoner.get(i).getNamn().equalsIgnoreCase(vem)){
				namn=true;
				indexPerson=i; 
			}	
		}
		if (namn){
			System.out.println(allaPersoner.get(indexPerson).toString1()) ;				
		}

		else{		
			System.out.println("Personen med det namnet fanns ej i registret");	
		}
		System.out.println();
	}

	public static void borskrasch (){
		for(Person person : allaPersoner){
			for(Pryl pobjekt : ((Person) person).getAllaPrylar()){
				if (pobjekt instanceof Aktier ){
					((Aktier) pobjekt).setVarde(0); 
				}
			}
		}
	}
}