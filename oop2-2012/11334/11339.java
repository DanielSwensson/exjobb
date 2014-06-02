import java.util.ArrayList;
import java.util.Scanner;
class V�rdesak {
	private static Scanner tangentbord = new Scanner(System.in);

	private String namn;

	private int pris;

	private int totalV�rde = 0;

	public int getPris(){
		return pris;
	}
	public String getNamn(){
		return namn;
	}
	public int getTotalV�rde(){
		return totalV�rde;
	}
	public void setTotalV�rde(int totalV�rde){
		this.totalV�rde = totalV�rde;
	}
	//konstruktor
	V�rdesak(String namn, int pris, int totalV�rde ){
		this.namn = namn;
		this.pris = pris;
		this.totalV�rde = totalV�rde;
	}
	public static void skapaPryl (){
		boolean finns = false;
		System.out.println("Vad heter personen?" );
		String personNamn = tangentbord.nextLine();
		Person personen = null;
		for (int x = 0; x < Person.getPersonLista().size(); x++){

			ArrayList<Person> personLista = Person.getPersonLista();
			Person p = personLista.get(x);
			if(p.getNamn().equals(personNamn)){
				//h�r finns personen s� blabla /
				personen = p;				
				finns = true;
			}
		}
		if(!finns){
			System.out.println("personen finns inte");
		}{
			System.out.println("Vilken typ av pryl vill du skapa?");
			System.out.println("1: Smycke");
			System.out.println("2: Aktier");
			System.out.println("3: Apparater");

			int val =0;

			try { val=Integer.parseInt(Person.getTangentbord().nextLine());
			switch (val){

			case 1:
				System.out.println("Du vill skapa smycke.");
				Smycke.skapaSmycke(personen);
				break;

			case 2:
				System.out.println("Du vill skapa aktier");
				Aktie.skapaAktie(personen);
				break;

			case 3: 
				System.out.println("Du vill skapa apparater ");
				Apparat.skapaApparat(personen);
				break;

			default:
				System.out.println("Menyval du har angivit existerar inte.");	}
			}
			catch(NumberFormatException e){
				System.out.println("Du har angivit fel kommando.");
			}
		}		
	}
	public static void main (String []args){
		while (true){

			System.out.println("Vad vill du g�ra? ");
			System.out.println("1: Skapa person");
			System.out.println("2: Skapa pryl");
			System.out.println("3: Visa alla personer");
			System.out.println("4: Visa rikaste");
			System.out.println("5: Visa viss person");
			System.out.println("6: B�rskrasch");
			System.out.println("7: Avsluta");

			int choice = 0;
			try {  choice = Integer.parseInt(Person.getTangentbord().nextLine());

			switch (choice){
			case 1:
				Person.skapaPerson();
				break;
			case 2:
				skapaPryl();
				break;

			case 3:
				Person.visaAllaPersoner();
				break;

			case 4:
				Person.visaRikaste();
				break;

			case 5:
				Person.visaVissPerson();
				break;

			case 6:
				Aktie.b�rskrasch();
				break;

			case 7:
				System.exit(0);
				break;

			default:
				System.out.println("Menyval du har angivit existerar inte.");
			}	
			}	catch(NumberFormatException e){
				System.out.println("Du har angivit fel kommando.");
			}
		}
	}
}