import java.util.ArrayList;



public class Person {

	private ArrayList<Pryl> allaPrylar = new ArrayList<Pryl>(); /*skapar en arraylist av som innehåller klassen Pryl (dess subklasser)*/

	private String namn;

	public Person(String namn) { 
		/*
		 * Person konstruktor
		 */
		this.namn = namn;
	}
	
	public void skrivPersonOchVärde(){
		/*
		 * Skriver ut alla personer samt dess totala värde
		 */
		System.out.println(getNamn() + "\t" + getPersonVärde());
	}

	public int getPersonVärde(){
		/*
		 * Metod som räknar och returnerar ett Person Objects totala  Pryl-värde
		 */
		int personVärde = 0;
		for(Pryl pr : allaPrylar){

			personVärde =personVärde+ pr.getVärde(); 
		}
		return personVärde;
	}

	public String getNamn() {
		/*
		 * public metod som returnerar Person objectets namn
		 */
		return namn;
	}

	public void läggTillPryl(Pryl pryl){
		/*
		 * Skickar vidare inmatningen till Pryl-konstruktorn
		 */
		allaPrylar.add(pryl);
	}

	public void börsKraschPerson() {
		
		/*
		 * Går igenom alla personens prylar, är det en aktie så görs priset på varje aktie till 0kr
		 */
		for(Pryl pr:allaPrylar){
			if(pr instanceof Aktier){
				((Aktier) pr).börsKraschAktier();
			}
		}

	}

	public void skrivUtPersonOchPrylar(Person person) {
		/*
		 * skriver ut alla personens prylar och dess värde
		 */
		String output = "";
		for(Pryl p : allaPrylar){
			output += p.getPrylNamn() + "\t" + p.getVärde() + "\n";
		}
		System.out.println(output);

	}




}
