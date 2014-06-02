/* 
Gruppmedlemmar:
Ayat Baroudi
Sabrine Boudraa
Tara Ahmad Yousif
DSV, Inlupp2
 */

import java.util.*;

public class Register {

	private static Scanner keyboard = new Scanner(System.in);
	private static ArrayList<Person> personList = new ArrayList<Person>();

	public static void main(String[] args) {

		while (true) {
			System.out.println(" ");
			System.out.println("Välj ett alternativ nedan:");
			System.out.println("1.Skapa person");
			System.out.println("2.Skapa pryl");
			System.out.println("3.Visa alla personer");
			System.out.println("4.Visa rikaste personen");
			System.out.println("5.Visa en viss person");
			System.out.println("6.Börskrasch");
			System.out.println("7.Avsluta");

			try{ 
				int answer = 0;
				answer = keyboard.nextInt();
				if(answer == 0 || answer > 7){
					System.out.println("Fel, måste vara mellan 1 och 7!");
				}else{

					switch (answer) {
					case 1:
						addPerson();
						break;
					case 2:
						addPryl();
						break;
					case 3:
						listPerson();
						break;
					case 4:
						hittaRikast();
						break;
					case 5:
						hittaVissPerson();
						break;
					case 6:
						börsKrasch();
						break;
					case 7:
						System.out.println("Systemet avslutas");
						System.exit(1);
						break;
					default:
						System.out.println(answer + " är inte ett giltigt kommando");
						break;

					}
				}
			}

			catch (NumberFormatException e) {
				System.out.println("FEL, måste vara ett numeriskt värde!");
				keyboard.nextLine();
			}    
			catch(InputMismatchException ex)
			{
				System.out.println("FEL, måste vara ett numeriskt värde!");	
				keyboard.nextLine();
			}
		}
	}

	private static void addPerson() {

		System.out.println("Ange personens namn: ");
		String namn = keyboard.next();
		keyboard.nextLine();

		boolean personFinns=false;

		for(Person p : personList) {
			if(p.getnamn().equalsIgnoreCase(namn))
			{
				System.out.print("Personen " + "(" +namn + ")" +" finns redan!");
				System.out.println(" ");

				personFinns=true;
			}
		}

		if(!personFinns)
		{
			personList.add(new Person(namn));
			System.out.print("Personen "+ namn +" har skapats");
			System.out.println(" ");
		}
	} 

	private static void addPryl() throws NumberFormatException
	{

		if(personList.isEmpty()) {
			System.out.println("Det finns inga personer registrerade!");
			return; }

		System.out.println("Ange namnet på personen som äger prylen: ");
		String inputNamn = keyboard.next();

		boolean personFinns = false;
		for(Person p : personList){

			if(p.getnamn().equalsIgnoreCase(inputNamn)) {
				personFinns=true;

				System.out.println("Ange prylens sort (smycke, aktie eller apparat): ");
				String inputPryl = keyboard.next();
				keyboard.nextLine();

				if (inputPryl.equalsIgnoreCase("Smycke")) {
					System.out.println("Ange smyckets typ: ");
					String smycke = keyboard.next();

					System.out.println("Är smycket av guld eller silver? ");
					String metallTyp = keyboard.next();

					while (!metallTyp.equalsIgnoreCase("guld") && !metallTyp.equalsIgnoreCase("silver")) 
					{
						System.out.println(" ");
						System.out.println("Fel inmatning."); 
						System.out.println("Är smycket av guld eller silver: ");
						metallTyp = keyboard.next();
					}

					System.out.println("Ange antal ädelstenar: ");
					int antalÄdelstenar = Integer.parseInt(keyboard.next());

					p.LäggaTillPryl(new Smycke(smycke, metallTyp, antalÄdelstenar));
					System.out.println("Prylen har registrerats!" + ""); 

				} else if (inputPryl.equalsIgnoreCase("Aktie")) {

					System.out.println("Ange aktiens namn: ");
					String aktie = keyboard.next();

					System.out.println("Ange antalet aktier: ");
					int antal = keyboard.nextInt();

					System.out.println("Ange aktiens värde: ");
					int aktiePris = keyboard.nextInt();
					System.out.println(" ");

					p.LäggaTillPryl(new Aktie(aktie, antal, aktiePris));
					System.out.println("Prylen har registrerats!");

				} else if (inputPryl.equalsIgnoreCase("Apparat")) {

					System.out.println("Ange apparatens typ: ");
					String apparat = keyboard.next();

					System.out.println("Ange apparatens pris: ");
					int apparatPris = keyboard.nextInt();
					System.out.println(" ");

					System.out.println("Ange apparatens slitage mellan 1 och 10, där 10 betyder helt ny och 1 mycket sliten: ");
					int slitage = keyboard.nextInt();

					p.LäggaTillPryl(new Apparat(apparat, apparatPris, slitage));
					System.out.println("Prylen har registrerats!");
				} else   
					System.out.println("prylen du har angett finns inte."); 
			}
		}
		if (!personFinns) {
			System.out.println("Personen du har angett finns inte!");
		}	
	}

	private static void listPerson() {

		if(personList.isEmpty()){
			System.out.println("Det finns inga personer registrerade!");
			return; }

		String allaPersoner = "";
		for(Person p : personList)

			allaPersoner += p.toString();
		System.out.println("Nedanstående personer finns i registret: ");
		System.out.println(allaPersoner);
	}

	private static void hittaRikast() {

		if(personList.isEmpty()){
			System.out.println("Det finns inga personer registrerade!");
			return; }

		Person rikast = personList.get(0);
		for(Person r : personList){
			if(r.getvärde() > rikast.getvärde())
				rikast = r;
		}
		System.out.println("Rikast är " + rikast.getnamn() + " som sammanlagt äger " + rikast.getvärde() +" kr");
		System.out.print(rikast.visaprylar());
	}

	private static void hittaVissPerson() {

		if(personList.isEmpty()){
			System.out.println("Det finns inga personer registrerade!");
			return; }

		System.out.print("Vilken person vill du se? ");
		String namnVissPerson = keyboard.next();
		keyboard.nextLine();

		boolean HittaEnVissPerson = false;

		for(Person vissP : personList) {
			if(vissP.getnamn().equalsIgnoreCase(namnVissPerson)) {	
				HittaEnVissPerson=true;
				System.out.print(vissP.toString());
				System.out.println(" ");
				System.out.print(vissP.visaprylar());
			}
		} 

		if(!HittaEnVissPerson) {
			System.out.println("Den personen du har angett finns inte.");
		}
	}

	private static void börsKrasch() {

		if(personList.isEmpty()){
			System.out.println("Det finns inga personer registrerade!");
			return; }

		for(Person p : personList) {
			for(Pryl k : p.getprylar()) { 
				if(k instanceof Aktie) 
					((Aktie)k).krasch();
			}
		} 
		System.out.println("Alla aktier är nu satta till 0!");
	}
}