

import java.util.Scanner;
import java.util.ArrayList;

public class HuvudProgram {

	ArrayList<Person> listaPerson = new ArrayList<Person>();
	Scanner sc = new Scanner(System.in);
		
	public int l�saHeltal(String fr�ga){
		for(;;){
			try{
			System.out.print(fr�ga);
			int number = Integer.parseInt(sc.nextLine());
			return number;
			}
			catch (NumberFormatException e) {
				System.out.println("Fel! Det ska vara numeriskt v�rde.");
				}
		}		
	}
	
	public String l�saStr�ng(String fr�ga) {
		System.out.print(fr�ga);
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
		String namnNyPerson = l�saStr�ng("Ange namn p� den nya personen: ");
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
		String person�;
		int prylSort;
		
		person� = l�saStr�ng("Vilken person �ger prylen: ");
		if(visaPerson(person�) == null) {
			System.out.println("Det finns inte person med det namnet i registret!");
		}
		
		else {
			do{
				System.out.println("V�lj mellan f�ljande sorter av prylar genom att ange en siffra 1-3: \n1 f�r smycke, 2 f�r aktie och 3 f�r apparat." );
				prylSort = l�saHeltal("Ange ditt val: ");
				if (prylSort < 0 || prylSort > 3)
					System.out.println("Du ska v�lja en siffra 1-3!");
			}
			while (prylSort < 0 || prylSort > 3);
				
			switch(prylSort){
		
			case 1:
				String smyckeSort = l�saStr�ng("Vilken sorts smycke: ");
				String metalslag = l�saStr�ng("Vilket metalslag(valje mellan guld och silver): "); 
				int antal�delsten = l�saHeltal("Ange antal �delsten: ");
				Smycke smycke = new Smycke("smycke", smyckeSort, antal�delsten, metalslag);
				visaPerson(person�).visaPrylSamling().add(smycke);
				break;
			
			case 2:
				String aktieSort = l�saStr�ng("Vilken sorts aktie: ");
				int antalAktie = l�saHeltal("Ange antal: ");
				int prisPerAktie = l�saHeltal("Ange pris per aktie: ");
				Aktie aktie = new Aktie("aktie", aktieSort, antalAktie, prisPerAktie);
				visaPerson(person�).visaPrylSamling().add(aktie);
				break;
			
			case 3:
				String apparatSort = l�saStr�ng("Vilken sorts apparat: ");
				int apparatInk�pspris = l�saHeltal("Ange ink�pspriset: ");
				int slitageGrad;
			
				do{
				System.out.println("Slitagegrad anges med siffror 1-10 d�r 10 �r helt ny.");
				slitageGrad = l�saHeltal("Ange apparatens slitagegrad: ");
				if (slitageGrad < 1 || slitageGrad > 10)
					System.out.println("Du ska v�lja en siffra 1-10!");
				}
				while (slitageGrad < 1 || slitageGrad > 10);
			
				Apparat apparat = new Apparat("apparat", apparatSort, slitageGrad, apparatInk�pspris); 	
				visaPerson(person�).visaPrylSamling().add(apparat);
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
			int h�gstaTotalV�rde = listaPerson.get(0).visaTotalV�rde();
			for(int i = 0; i < listaPerson.size(); i++) {
				if(listaPerson.get(i).visaTotalV�rde() > h�gstaTotalV�rde) {
					h�gstaTotalV�rde = listaPerson.get(i).visaTotalV�rde();
					rikastePersonen = listaPerson.get(i).visaNamn();
				}
			}
			System.out.println("Rikaste personen �r " + rikastePersonen + " som sammanlagt �ger " + h�gstaTotalV�rde);
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("Det finns ingen person i registret!");
		}
		
	}
	
	public void visaViss() {
		Person p;
		String vissPersonNamn;
		
		vissPersonNamn = l�saStr�ng("Ange personens namn: ");
		p = visaPerson(vissPersonNamn);
		if (p == null) {
			System.out.println("Personen finns inte med i registret.");
		}
		else {
			for(int i = 0; i < listaPerson.size(); i++){
				if(listaPerson.get(i).visaNamn().equalsIgnoreCase(vissPersonNamn)){
					System.out.println(vissPersonNamn + "�ger f�ljande prylar: ");
					for(int j = 0; j < listaPerson.get(i).visaPrylSamling().size(); j++){	
						System.out.println(listaPerson.get(i).visaPrylSamling().get(j));
					}				
				}			
			}
		}
	}
	
	public void b�rsKrasch() {
		for(int i = 0; i < listaPerson.size(); i++){
			listaPerson.get(i).kraschaB�rsen();
		}
	}
	public static void main(String[] args){
		HuvudProgram hp = new HuvudProgram();
		System.out.println("Hej och v�lkommen till Prylregisterprogrammet: ");
		System.out.println("Information: \n Ange siffran 1 f�r att skapa en person \n Ange siffran 2 f�r att skapa en pryl \n Ange siffran 3 f�r att visa alla personer i registret \n Ange siffran 4 om du vill visa den rikaste personen i registret. \n Ange siffran 5 f�r att visa en viss person i registret. \n Ange siffran 6 f�r att utf�ra b�rskrasch d�r alla personers aktier s�tts till noll. \n Ange siffran 7 f�r att avsluta programmet.");
		for(; ;){
			int val = hp.l�saHeltal("Ange kommando 1-7: "); 
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
					hp.b�rsKrasch();
					System.out.println();
					break;
					
				case 7:
					System.out.println("Tack och hej d�!");
					System.exit(0);
					
				default: 
					System.out.println("Fel kommando. Ska vara siffra 1-7!"); 
				
			}		
		}
	}
}