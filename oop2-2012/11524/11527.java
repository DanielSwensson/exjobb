import java.util.Scanner;
// En klass f�r alla programstyrnings - och anv�ndardialogsmetoder 
public class Kontroller {

	Scanner keyboard = new Scanner(System.in);
	private String personNamn;
	Personer personer;

	public Kontroller(Personer personer) {
		this.personer = personer;
	}

	//En meny f�r anv�ndarens val, varje val anropar en relevant metod
	public void meny (){
		boolean sant = true;
		while (sant){
			System.out.println("1. Skapa en ny person \n2. L�gga till prylar\n3. Visa alla\n4. Visa rikaste\n5. Visa en viss person\n6. B�rskrash\n7. Avsluta");
			int menyVal = kollaInput(keyboard);
			if (menyVal == 1){
				skapaPerson();
			} 
			else if (menyVal == 2){
				System.out.println("Vilken person?");
				String s�ktaPerson = keyboard.next();
				if (personer.giltigtNamn(s�ktaPerson)){
					Person p = personer.hittaPerson(s�ktaPerson);
					skapaPryl(p, keyboard); 
				}
			}
			else if (menyVal == 3){
				personer.visaAlla();
			}
			else if (menyVal == 4){
				Person rikaste = personer.visaRikaste();
				System.out.println("Rikaste �r " + rikaste.getNamn() + " som sammanlagt �ger: " + rikaste.countV�rde());
				
			}
			else if (menyVal == 5){
				System.out.println("Vem ska systemet visa? Skriv namnet.");
				String s�ktaPerson = keyboard.next(); 
				if (personer.giltigtNamn(s�ktaPerson)){
					personer.skrivaUtPers(s�ktaPerson);	
				}	
			}
			else if (menyVal == 6){
				b�rskrascha();
			}
			else  if (menyVal == 7){
				System.out.println("Hej d�!");
				sant = false;
			}
		}
	}

	//Skapar en ny person med namn och l�gger till den till en ArrayList "personer"
	private void skapaPerson (){
		System.out.println("Nya personens namn?");
		personNamn = keyboard.next(); 
		if (!personer.namnExisterar(personNamn)){
			Person p = new Person (personNamn);
			personer.l�ggTillPerson(p);
		}
	}

	//Skapar en pryl av typ aktie som tillh�r en tidigare valt person, Person p
	private void skapaAktie (Person p){
		System.out.println("Vad heter aktie?");
		String aktieNamn = keyboard.next();

		System.out.println("Hur m�nga aktier?");
		int antal = kollaInput(keyboard);
		
				
		
		System.out.println("Vilket pris?");
		int pris = kollaInput(keyboard);
		
		
		Aktie aktie = new Aktie (aktieNamn,0, antal, pris);
		p.addPryl(aktie);//l�gger till denna pryl till personen som nu �ger den
	}
	//Skapar en pryl av typ Smycke som tillh�r en tidigare valt person, Person p
	private void skapaSmycke (Person p){
		System.out.println("Vad heter smycken? ");
		String smyckeNamn = keyboard.next();
		
		System.out.println("Hur m�nga �delstenar? ");
		int �delstenar = kollaInput(keyboard);
		
		
		
		System.out.println("�r den av guld? 1.Ja 2.Nej");
		boolean guld;
		int guldVal = kollaInput(keyboard);//v�lj om smycket �r gjort av gult eller silver
		if (guldVal == 1){
			guld = true;//v�rde kommer bli 2000
		} else {
			guld = false;//v�rde kommer bli 700
		}
		Smycke smycke = new Smycke (smyckeNamn,0, �delstenar,guld);
		p.addPryl(smycke);//l�gger till denna pryl till personen 
	}
	
	//Skapar en pryl av typ Apparat som tillh�r en tidigare valt person
	private void skapaApparat (Person p){
		System.out.println("Vad heter apparaten?");
		String apparNamn = keyboard.next();

		System.out.println("Vilket var ink�pspris?");
		int ink�pspris = kollaInput(keyboard);
		
	
		System.out.println("Vad �r slitage (fr�n 1 - 10)");
		int slitage = kollaInput(keyboard);
		
		

		Apparat apparat = new Apparat (apparNamn, 0, ink�pspris, slitage);
		p.addPryl(apparat);//l�gger till denna pryl till personen som nu �ger den
	}

	//Dialog f�r anv�ndare att v�lja vilken typ av pryl personen kommer l�gga till 
	private void skapaPryl (Person p, Scanner keyboard){
		System.out.println("Vilken sorts pryl? 1.Smycke 2.Aktie 3.Apparat");
		int choice1 = kollaInput(keyboard);
		if (choice1 ==1){
			skapaSmycke(p);
		} 
		else if (choice1 == 2){
			skapaAktie(p);
		} 
		else {
			skapaApparat(p);
		}
	}

	public String getPersonNamn (){
		return personNamn;
	}
	private void b�rskrascha() {
		for (Person b : personer.allaPers){
			for (Pryl p :b.prylar){
				if (p.�rAktie()){
					p.v�rde = 0;
				}
			}
			System.out.println("� nej, alla aktier blir v�rdel�sa!");
		}
	}
	private int kollaInput(Scanner keyboard){
		boolean ok = false;
		int v�rde = 0;
		while (!ok){
			try {
				String str = keyboard.next();
				v�rde = Integer.parseInt(str);
				ok = true;
				
				
			}
			catch (NumberFormatException f){
				System.out.println("Fel format skriv in ett heltal");	
			}
		}
		
		return v�rde;
	}
}
