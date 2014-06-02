

import java.util.Scanner;
import java.util.ArrayList;

public class HuvudProgram {

	ArrayList<Person> listaPerson = new ArrayList<Person>();
	Scanner sc = new Scanner(System.in);
		
	public int läsaHeltal(String fråga){
		for(;;){
			try{
			System.out.print(fråga);
			int number = Integer.parseInt(sc.nextLine());
			return number;
			}
			catch (NumberFormatException e) {
				System.out.println("Fel! Det ska vara numeriskt värde.");
				}
		}		
	}
	
	public String läsaSträng(String fråga) {
		System.out.print(fråga);
		String str = sc.nextLine();
		return str;
	}
		
	public Person visaPerson(String namn) {
		for (Person p : listaPerson) {
			if (p.visaNamn().equalsIgnoreCase(namn)){
				return p;
			}
		}
		return null;
	}
		
	public void skapaPerson() {
		String namnNyPerson = läsaSträng("Ange namn på den nya personen: ");
		Person p = visaPerson(namnNyPerson); 
		if (p != null) {
			System.out.println("Den personen finns redan.");
		}                             
		else {
			Person nyPerson = new Person(namnNyPerson);
			listaPerson.add(nyPerson);
		}			
	}	
	
	public void skapaPryl(){
		String personÄ;
		int prylSort;
		
		personÄ = läsaSträng("Vilken person äger prylen: ");
		if(visaPerson(personÄ) == null) {
			System.out.println("Det finns inte person med det namnet i registret!");
		}
		
		else {
			do{
				System.out.println("Välj mellan följande sorter av prylar genom att ange en siffra 1-3: \n1 för smycke, 2 för aktie och 3 för apparat." );
				prylSort = läsaHeltal("Ange ditt val: ");
				if (prylSort < 0 || prylSort > 3)
					System.out.println("Du ska välja en siffra 1-3!");
			}
			while (prylSort < 0 || prylSort > 3);
				
			switch(prylSort){
		
			case 1:
				String smyckeSort = läsaSträng("Vilken sorts smycke: ");
				String metalslag = läsaSträng("Vilket metalslag(valje mellan guld och silver): "); 
				int antalÄdelsten = läsaHeltal("Ange antal ädelsten: ");
				Smycke smycke = new Smycke("smycke", smyckeSort, antalÄdelsten, metalslag);
				visaPerson(personÄ).visaPrylSamling().add(smycke);
				break;
			
			case 2:
				String aktieSort = läsaSträng("Vilken sorts aktie: ");
				int antalAktie = läsaHeltal("Ange antal: ");
				int prisPerAktie = läsaHeltal("Ange pris per aktie: ");
				Aktie aktie = new Aktie("aktie", aktieSort, antalAktie, prisPerAktie);
				visaPerson(personÄ).visaPrylSamling().add(aktie);
				break;
			
			case 3:
				String apparatSort = läsaSträng("Vilken sorts apparat: ");
				int apparatInköpspris = läsaHeltal("Ange inköpspriset: ");
				int slitageGrad;
			
				do{
				System.out.println("Slitagegrad anges med siffror 1-10 där 10 är helt ny.");
				slitageGrad = läsaHeltal("Ange apparatens slitagegrad: ");
				if (slitageGrad < 1 || slitageGrad > 10)
					System.out.println("Du ska välja en siffra 1-10!");
				}
				while (slitageGrad < 1 || slitageGrad > 10);
			
				Apparat apparat = new Apparat("apparat", apparatSort, slitageGrad, apparatInköpspris); 	
				visaPerson(personÄ).visaPrylSamling().add(apparat);
				break;
			}
		}
	}
	
	public void visaAlla() {
		System.out.println("I registret finns: ");
		for(Person p : listaPerson) {
			System.out.println(p);
		}
	}
	
	public void visaRikaste() {
		try {
			String rikastePersonen = listaPerson.get(0).visaNamn();
			int högstaTotalVärde = listaPerson.get(0).visaTotalVärde();
			for(int i = 0; i < listaPerson.size(); i++) {
				if(listaPerson.get(i).visaTotalVärde() > högstaTotalVärde) {
					högstaTotalVärde = listaPerson.get(i).visaTotalVärde();
					rikastePersonen = listaPerson.get(i).visaNamn();
				}
			}
			System.out.println("Rikaste personen är " + rikastePersonen + " som sammanlagt äger " + högstaTotalVärde);
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("Det finns ingen person i registret!");
		}
		
	}
	
	public void visaViss() {
		Person p;
		String vissPersonNamn;
		
		vissPersonNamn = läsaSträng("Ange personens namn: ");
		p = visaPerson(vissPersonNamn);
		if (p == null) {
			System.out.println("Personen finns inte med i registret.");
		}
		else {
			for(int i = 0; i < listaPerson.size(); i++){
				if(listaPerson.get(i).visaNamn().equalsIgnoreCase(vissPersonNamn)){
					System.out.println(vissPersonNamn + "äger följande prylar: ");
					for(int j = 0; j < listaPerson.get(i).visaPrylSamling().size(); j++){	
						System.out.println(listaPerson.get(i).visaPrylSamling().get(j));
					}				
				}			
			}
		}
	}
	
	public void börsKrasch() {
		for(int i = 0; i < listaPerson.size(); i++){
			listaPerson.get(i).kraschaBörsen();
		}
	}
	public static void main(String[] args){
		HuvudProgram hp = new HuvudProgram();
		System.out.println("Hej och välkommen till Prylregisterprogrammet: ");
		System.out.println("Information: \n Ange siffran 1 för att skapa en person \n Ange siffran 2 för att skapa en pryl \n Ange siffran 3 för att visa alla personer i registret \n Ange siffran 4 om du vill visa den rikaste personen i registret. \n Ange siffran 5 för att visa en viss person i registret. \n Ange siffran 6 för att utföra börskrasch där alla personers aktier sätts till noll. \n Ange siffran 7 för att avsluta programmet.");
		for(; ;){
			int val = hp.läsaHeltal("Ange kommando 1-7: "); 
			switch (val){
				case 1: 
					hp.skapaPerson();
					System.out.println();
					break;
				
				case 2:
					hp.skapaPryl();
					System.out.println();
					break;
				
				case 3:
					hp.visaAlla();
					System.out.println();
					break;
					
				case 4:
					hp.visaRikaste();
					System.out.println();
					break;
				
				case 5:
					hp.visaViss();
					System.out.println();
					break;
				
				case 6:
					hp.börsKrasch();
					System.out.println();
					break;
					
				case 7:
					System.out.println("Tack och hej då!");
					System.exit(0);
					
				default: 
					System.out.println("Fel kommando. Ska vara siffra 1-7!"); 
				
			}		
		}
	}
}