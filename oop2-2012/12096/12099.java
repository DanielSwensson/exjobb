import java.util.ArrayList;



public class Person {

	private ArrayList<Pryl> allaPrylar = new ArrayList<Pryl>(); /*skapar en arraylist av som inneh�ller klassen Pryl (dess subklasser)*/

	private String namn;

	public Person(String namn) { 
		/*
		 * Person konstruktor
		 */
		this.namn = namn;
	}
	
	public void skrivPersonOchV�rde(){
		/*
		 * Skriver ut alla personer samt dess totala v�rde
		 */
		System.out.println(getNamn() + "\t" + getPersonV�rde());
	}

	public int getPersonV�rde(){
		/*
		 * Metod som r�knar och returnerar ett Person Objects totala  Pryl-v�rde
		 */
		int personV�rde = 0;
		for(Pryl pr : allaPrylar){

			personV�rde =personV�rde+ pr.getV�rde(); 
		}
		return personV�rde;
	}

	public String getNamn() {
		/*
		 * public metod som returnerar Person objectets namn
		 */
		return namn;
	}

	public void l�ggTillPryl(Pryl pryl){
		/*
		 * Skickar vidare inmatningen till Pryl-konstruktorn
		 */
		allaPrylar.add(pryl);
	}

	public void b�rsKraschPerson() {
		
		/*
		 * G�r igenom alla personens prylar, �r det en aktie s� g�rs priset p� varje aktie till 0kr
		 */
		for(Pryl pr:allaPrylar){
			if(pr instanceof Aktier){
				((Aktier) pr).b�rsKraschAktier();
			}
		}

	}

	public void skrivUtPersonOchPrylar(Person person) {
		/*
		 * skriver ut alla personens prylar och dess v�rde
		 */
		String output = "";
		for(Pryl p : allaPrylar){
			output += p.getPrylNamn() + "\t" + p.getV�rde() + "\n";
		}
		System.out.println(output);

	}




}
