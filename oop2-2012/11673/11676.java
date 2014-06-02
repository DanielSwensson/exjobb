import java.util.*;

public class Person {
	/**
	 * @uml.property  name="allaPrylar"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="Aktie"
	 */
	private ArrayList<Pryl> allaPrylar = new ArrayList<Pryl>();
	/**
	 * @uml.property  name="name"
	 */
	private String name;
	
	public Person(String name){
		this.name=name;
	}
	/**
	 * @return
	 * @uml.property  name="name"
	 */
	public String getName(){
		return name;
	}
	public String toString(){
		return name + "   " + totalValue();
	}
	public String toStringRichest(){
		return "Rikast �r " + name + " som sammanlagt �ger " + totalValue();
	}
	public String toStringCertainPerson(){
		return name + " �ger sammanlagt " + totalValue();
	}
	public void addPryl(Pryl p)//L�gger till pryl till person p
	{
		this.allaPrylar.add(p);
	}
	public void printArrayAllaPrylar(){ //Skriv ut alla prylar
		for (int x = 0; x<allaPrylar.size(); x++){
			System.out.println(allaPrylar.get(x));
		}
	}
	public double totalValue(){ //Alla prylar i AL g�s igenom, ber�knar totala v�rdet.
		double totalValue = 0;
		for (int x = 0; x<allaPrylar.size(); x++){
			totalValue = totalValue + (allaPrylar.get(x).getValue());
		}
		return totalValue;
	}

	public void aktieCrash(){
		System.out.print("En aktiekrasch har skett! Alla aktier �r v�rda 0!");
		//G� igenom allaPrylar och kolla om aktie finns. 
		//Om aktiepryl finns, ska den s�tta pricePerPost till 0.
		for (int x = 0; x<allaPrylar.size(); x++){
			if (allaPrylar.get(x) instanceof Aktie){
				Aktie a = (Aktie)allaPrylar.get(x);
				a.changePriceToZero();
			}
		}
	}
}	

	
