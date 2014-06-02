import java.util.ArrayList;
import java.util.Scanner;

public class PrylProgram {
	
	
	private ArrayList<Person> alla = new ArrayList<Person>();
	Scanner sc = new Scanner(System.in);
	
	public int readInt(String fr�ga){
		/* Hj�lpmetod f�r att l�sa in int*/
		for(;;){
			try{;
				boolean done = false;
				while(!done){
					System.out.println(fr�ga);
					int x=Integer.parseInt(sc.nextLine());
					if (x<0){
						System.out.println("Talet f�r inte vara mindre �n 0!");
					}else{
						done = true;
						return x;
					}
				}
			}
			catch (NumberFormatException e){
				System.out.println("Fel - skall vara numeriskt v�rde");
			}
		}
	}

	public String readString (String fr�ga){
		/*
		 * Hj�lpmetod f�r att l�sa in Strings
		 */
		System.out.println(fr�ga);
		String str=sc.nextLine();
		return str;
	}

	private Person getPerson (String namn){ 
		/*
		 * Hj�lpmetod f�r att returnera en person n�r man s�ker p� dess namn
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
		 * R�knar ut vem som �r rikast
		 */
		int h�gstV�rde = 0;
		Person rikast = null;
		for(Person p : alla){
				
			if(p.getPersonV�rde() > h�gstV�rde){
				h�gstV�rde = p.getPersonV�rde();
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
		 * B�rjar med att fr�ga om inmatning
		 */
		String namn = readString("Vad �r det f�r smycke?"); 
		
		boolean guld;
		for(;;){
			String svar = readString("�r det guld eller silver?");
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
		int antalStenar = readInt("Hur m�nga fina stenar?");
		
		getPerson(vem).l�ggTillPryl(new Smycke(namn,guld,antalStenar));  
		
		/*Skickar inmatningen till konstruktorn*/
		
	}
	private void aktieTillPerson(String vem){
		/* B�rjar med att fr�ga om inmatning */
		
		String namn = readString("Vad heter aktien? ");		
		int pris = readInt("Vad har aktien f�r styckpris?");
		int antalAktier = readInt("Hur m�nga aktier har personen?");
		
		getPerson(vem).l�ggTillPryl(new Aktier(namn, pris, antalAktier)); 
		/*Skickar inmatningen till konstruktorn*/
	}
	private void apparatTillPerson(String vem){
		/* B�rjar med att fr�ga om inmatning */
		String namn = readString("Vad �r det f�r apparat?");
		int ink�psPris = readInt("Ink�pspris?");
		int slitage;
		do{
			slitage = readInt("Hur sliten �r apparaten p� en skala 1-10 d�r 1 �r extremt sliten och 10 �r som ny? ");
			if(slitage <1 || slitage >10){
				System.out.println("Svara med ett tal mellan 1 och 10");				
			}
		}while(slitage <1 || slitage >10); // Tills jag f�r r�tt svar
		
		getPerson(vem).l�ggTillPryl(new Apparat(namn, ink�psPris, slitage));
		/*Skickar inmatningen till konstruktorn*/
	}
	
	private void skapaPryl(){
		/*Metod f�r att ge en viss person<Person> en viss pryl<Pryl>*/
		String vem;
		for(;;){
			vem = readString("Vilken person ska f� en pryl?");
			if (getPerson(vem) != null){break;}
			else{
				System.out.println("Finns ingen s�dan person, skriv igen...");
				}
		}
		for(;;){

			
			int prylTyp = 0;
			prylTyp = readInt("Vilken typ av pryl ska personen f�? \n1: Smycke \n2: Aktie \n3: Apparat.");
			
			if (prylTyp==1){
				smyckeTillPerson(vem); // G�r till metoden d�r inmatning f�r smycke sker
				break;
			}else if (prylTyp==2){
				aktieTillPerson(vem); //G�r till metoden d�r inmatning f�r aktier sker
				break;
			}else if (prylTyp==3){
				apparatTillPerson(vem); //G�r till metoden d�r inmatning f�r apparat sker
				break;
			}else{
			System.out.println("Fel inmatad information, det ska vara ett tal mellan 1-3");
			}
		}
	}
	
	private void visaAlla(){
		/*Denna metoden visar alla personers v�rde*/
		for (Person p : alla){
			p.skrivPersonOchV�rde();
		}
	}

	private void visaRikaste(){
		/*r�knar f�rst ut vilken person som �r rikast, sedan skriver om den personen och dess prylar*/
		try{
			Person rikast = setRikaste();
			System.out.println("Rikast �r " + rikast.getNamn() + " som sammanlagt �ger " + rikast.getPersonV�rde() + "kr" );
			rikast.skrivUtPersonOchPrylar(rikast);
		}catch(NullPointerException e){System.out.println("Ingen person �ger n�got med v�rde");}
	}
	private void visaViss(){
		/*Kod f�r att visa en person och dess v�rden*/
		
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
			System.err.println("blev fel - NullPointerException"); // s� att det visas om det blir fel(fast det ska inte beh�vas)
		}
	}

	private void b�rskrasch(){	
		
		/* kod f�r b�rskrash, pris = 0kr f�r varje aktiv aktie*/
		
		for(Person p : alla){
		p.b�rsKraschPerson();
		}
	}
	
	private void program() {
		/* Kod f�r sj�lv kommandostyrda programmet*/
		
		System.out.println("Hejsan och v�lkommen till Prylprogrammet");
		for(;;){
			int val = readInt("\n1: Skapa person\n2: Skapa Pryl\n3: Visa alla\n4: Visa rikaste\n5: Visa viss\n6: B�rskrash" +
								"\n7: Avsluta\n\nAnge kommando 1-7: ");
			switch (val){
			case 1: skapaPerson(); break;
			case 2: skapaPryl(); break;
			case 3: visaAlla(); break;
			case 4: visaRikaste(); break;
			case 5: visaViss(); break;
			case 6: b�rskrasch(); break;
			case 7: System.out.println("Tack och hejd� :)");
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
