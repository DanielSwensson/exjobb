import java.util.Scanner;
// En klass för alla programstyrnings - och användardialogsmetoder 
public class Kontroller {

	Scanner keyboard = new Scanner(System.in);
	private String personNamn;
	Personer personer;

	public Kontroller(Personer personer) {
		this.personer = personer;
	}

	//En meny för användarens val, varje val anropar en relevant metod
	public void meny (){
		boolean sant = true;
		while (sant){
			System.out.println("1. Skapa en ny person \n2. Lägga till prylar\n3. Visa alla\n4. Visa rikaste\n5. Visa en viss person\n6. Börskrash\n7. Avsluta");
			int menyVal = kollaInput(keyboard);
			if (menyVal == 1){
				skapaPerson();
			} 
			else if (menyVal == 2){
				System.out.println("Vilken person?");
				String söktaPerson = keyboard.next();
				if (personer.giltigtNamn(söktaPerson)){
					Person p = personer.hittaPerson(söktaPerson);
					skapaPryl(p, keyboard); 
				}
			}
			else if (menyVal == 3){
				personer.visaAlla();
			}
			else if (menyVal == 4){
				Person rikaste = personer.visaRikaste();
				System.out.println("Rikaste är " + rikaste.getNamn() + " som sammanlagt äger: " + rikaste.countVärde());
				
			}
			else if (menyVal == 5){
				System.out.println("Vem ska systemet visa? Skriv namnet.");
				String söktaPerson = keyboard.next(); 
				if (personer.giltigtNamn(söktaPerson)){
					personer.skrivaUtPers(söktaPerson);	
				}	
			}
			else if (menyVal == 6){
				börskrascha();
			}
			else  if (menyVal == 7){
				System.out.println("Hej då!");
				sant = false;
			}
		}
	}

	//Skapar en ny person med namn och lägger till den till en ArrayList "personer"
	private void skapaPerson (){
		System.out.println("Nya personens namn?");
		personNamn = keyboard.next(); 
		if (!personer.namnExisterar(personNamn)){
			Person p = new Person (personNamn);
			personer.läggTillPerson(p);
		}
	}

	//Skapar en pryl av typ aktie som tillhör en tidigare valt person, Person p
	private void skapaAktie (Person p){
		System.out.println("Vad heter aktie?");
		String aktieNamn = keyboard.next();

		System.out.println("Hur många aktier?");
		int antal = kollaInput(keyboard);
		
				
		
		System.out.println("Vilket pris?");
		int pris = kollaInput(keyboard);
		
		
		Aktie aktie = new Aktie (aktieNamn,0, antal, pris);
		p.addPryl(aktie);//lägger till denna pryl till personen som nu äger den
	}
	//Skapar en pryl av typ Smycke som tillhör en tidigare valt person, Person p
	private void skapaSmycke (Person p){
		System.out.println("Vad heter smycken? ");
		String smyckeNamn = keyboard.next();
		
		System.out.println("Hur många ädelstenar? ");
		int ädelstenar = kollaInput(keyboard);
		
		
		
		System.out.println("Är den av guld? 1.Ja 2.Nej");
		boolean guld;
		int guldVal = kollaInput(keyboard);//välj om smycket är gjort av gult eller silver
		if (guldVal == 1){
			guld = true;//värde kommer bli 2000
		} else {
			guld = false;//värde kommer bli 700
		}
		Smycke smycke = new Smycke (smyckeNamn,0, ädelstenar,guld);
		p.addPryl(smycke);//lägger till denna pryl till personen 
	}
	
	//Skapar en pryl av typ Apparat som tillhör en tidigare valt person
	private void skapaApparat (Person p){
		System.out.println("Vad heter apparaten?");
		String apparNamn = keyboard.next();

		System.out.println("Vilket var inköpspris?");
		int inköpspris = kollaInput(keyboard);
		
	
		System.out.println("Vad är slitage (från 1 - 10)");
		int slitage = kollaInput(keyboard);
		
		

		Apparat apparat = new Apparat (apparNamn, 0, inköpspris, slitage);
		p.addPryl(apparat);//lägger till denna pryl till personen som nu äger den
	}

	//Dialog för användare att välja vilken typ av pryl personen kommer lägga till 
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
	private void börskrascha() {
		for (Person b : personer.allaPers){
			for (Pryl p :b.prylar){
				if (p.ärAktie()){
					p.värde = 0;
				}
			}
			System.out.println("Å nej, alla aktier blir värdelösa!");
		}
	}
	private int kollaInput(Scanner keyboard){
		boolean ok = false;
		int värde = 0;
		while (!ok){
			try {
				String str = keyboard.next();
				värde = Integer.parseInt(str);
				ok = true;
				
				
			}
			catch (NumberFormatException f){
				System.out.println("Fel format skriv in ett heltal");	
			}
		}
		
		return värde;
	}
}
