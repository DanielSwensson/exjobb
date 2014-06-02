import java.util.ArrayList;
import java.util.Scanner;

public class PrylProgram {
	
	
	private ArrayList<Person> alla = new ArrayList<Person>();
	Scanner sc = new Scanner(System.in);
	
	public int readInt(String fråga){
		/* Hjälpmetod för att läsa in int*/
		for(;;){
			try{;
				boolean done = false;
				while(!done){
					System.out.println(fråga);
					int x=Integer.parseInt(sc.nextLine());
					if (x<0){
						System.out.println("Talet får inte vara mindre än 0!");
					}else{
						done = true;
						return x;
					}
				}
			}
			catch (NumberFormatException e){
				System.out.println("Fel - skall vara numeriskt värde");
			}
		}
	}

	public String readString (String fråga){
		/*
		 * Hjälpmetod för att läsa in Strings
		 */
		System.out.println(fråga);
		String str=sc.nextLine();
		return str;
	}

	private Person getPerson (String namn){ 
		/*
		 * Hjälpmetod för att returnera en person när man söker på dess namn
		 */
		for (Person p : alla){
			if (p.getNamn().equalsIgnoreCase(namn)){
				return p;
			}
		}
		return null;
		
			
	}

	public Person setRikaste(){
		
		/*
		 * Räknar ut vem som är rikast
		 */
		int högstVärde = 0;
		Person rikast = null;
		for(Person p : alla){
				
			if(p.getPersonVärde() > högstVärde){
				högstVärde = p.getPersonVärde();
				rikast = p;
			}
		}return rikast;
		
	}
	
	private void skapaPerson(){
		/*
		 * Skapar en person i alla<Person> ArrayListen
		 */
		String namn = readString("Nya personens namn: ");
		Person p = getPerson(namn);
		if (p!=null)
			System.out.println("Den personen finns redan");
		else{
			Person ny = new Person(namn);
			alla.add(ny);
		}
	}
	
	private void smyckeTillPerson(String vem){

		/*
		 * Börjar med att fråga om inmatning
		 */
		String namn = readString("Vad är det för smycke?"); 
		
		boolean guld;
		for(;;){
			String svar = readString("Är det guld eller silver?");
			if (svar.equalsIgnoreCase("guld")){
				guld = true;
				break;
			}else if(svar.equalsIgnoreCase("silver")){
				guld = false;
				break;
			}else{
				System.out.println("\nGULD ELLER SILVER!!!\n");
			}
		}
		int antalStenar = readInt("Hur många fina stenar?");
		
		getPerson(vem).läggTillPryl(new Smycke(namn,guld,antalStenar));  
		
		/*Skickar inmatningen till konstruktorn*/
		
	}
	private void aktieTillPerson(String vem){
		/* Börjar med att fråga om inmatning */
		
		String namn = readString("Vad heter aktien? ");		
		int pris = readInt("Vad har aktien för styckpris?");
		int antalAktier = readInt("Hur många aktier har personen?");
		
		getPerson(vem).läggTillPryl(new Aktier(namn, pris, antalAktier)); 
		/*Skickar inmatningen till konstruktorn*/
	}
	private void apparatTillPerson(String vem){
		/* Börjar med att fråga om inmatning */
		String namn = readString("Vad är det för apparat?");
		int inköpsPris = readInt("Inköpspris?");
		int slitage;
		do{
			slitage = readInt("Hur sliten är apparaten på en skala 1-10 där 1 är extremt sliten och 10 är som ny? ");
			if(slitage <1 || slitage >10){
				System.out.println("Svara med ett tal mellan 1 och 10");				
			}
		}while(slitage <1 || slitage >10); // Tills jag får rätt svar
		
		getPerson(vem).läggTillPryl(new Apparat(namn, inköpsPris, slitage));
		/*Skickar inmatningen till konstruktorn*/
	}
	
	private void skapaPryl(){
		/*Metod för att ge en viss person<Person> en viss pryl<Pryl>*/
		String vem;
		for(;;){
			vem = readString("Vilken person ska få en pryl?");
			if (getPerson(vem) != null){break;}
			else{
				System.out.println("Finns ingen sådan person, skriv igen...");
				}
		}
		for(;;){

			
			int prylTyp = 0;
			prylTyp = readInt("Vilken typ av pryl ska personen få? \n1: Smycke \n2: Aktie \n3: Apparat.");
			
			if (prylTyp==1){
				smyckeTillPerson(vem); // Går till metoden där inmatning för smycke sker
				break;
			}else if (prylTyp==2){
				aktieTillPerson(vem); //Går till metoden där inmatning för aktier sker
				break;
			}else if (prylTyp==3){
				apparatTillPerson(vem); //Går till metoden där inmatning för apparat sker
				break;
			}else{
			System.out.println("Fel inmatad information, det ska vara ett tal mellan 1-3");
			}
		}
	}
	
	private void visaAlla(){
		/*Denna metoden visar alla personers värde*/
		for (Person p : alla){
			p.skrivPersonOchVärde();
		}
	}

	private void visaRikaste(){
		/*räknar först ut vilken person som är rikast, sedan skriver om den personen och dess prylar*/
		try{
			Person rikast = setRikaste();
			System.out.println("Rikast är " + rikast.getNamn() + " som sammanlagt äger " + rikast.getPersonVärde() + "kr" );
			rikast.skrivUtPersonOchPrylar(rikast);
		}catch(NullPointerException e){System.out.println("Ingen person äger något med värde");}
	}
	private void visaViss(){
		/*Kod för att visa en person och dess värden*/
		
		try{
			boolean test = false;
			while(test == false){
				String vem = readString("Vilken person? ");
				if (getPerson(vem) != null){
					getPerson(vem).skrivUtPersonOchPrylar(getPerson(vem));
					test = true;
				}else{
					System.out.println("Personen finns inte, testa igen. ");
				}
			}
		}catch(NullPointerException e){
			System.err.println("blev fel - NullPointerException"); // så att det visas om det blir fel(fast det ska inte behövas)
		}
	}

	private void börskrasch(){	
		
		/* kod för börskrash, pris = 0kr för varje aktiv aktie*/
		
		for(Person p : alla){
		p.börsKraschPerson();
		}
	}
	
	private void program() {
		/* Kod för själv kommandostyrda programmet*/
		
		System.out.println("Hejsan och välkommen till Prylprogrammet");
		for(;;){
			int val = readInt("\n1: Skapa person\n2: Skapa Pryl\n3: Visa alla\n4: Visa rikaste\n5: Visa viss\n6: Börskrash" +
								"\n7: Avsluta\n\nAnge kommando 1-7: ");
			switch (val){
			case 1: skapaPerson(); break;
			case 2: skapaPryl(); break;
			case 3: visaAlla(); break;
			case 4: visaRikaste(); break;
			case 5: visaViss(); break;
			case 6: börskrasch(); break;
			case 7: System.out.println("Tack och hejdå :)");
					System.exit(0); break;
			default: System.out.println("Felkommando\n"); break;
			}
			
			
		}
		
	}
	
	public static void main(String[] args){
		PrylProgram pp = new PrylProgram();
		pp.program();
		/*
		 * Startar mitt program.
		 */
	}



}
