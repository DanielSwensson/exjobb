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
		return "Rikast är " + name + " som sammanlagt äger " + totalValue();
	}
	public String toStringCertainPerson(){
		return name + " äger sammanlagt " + totalValue();
	}
	public void addPryl(Pryl p)//Lägger till pryl till person p
	{
		this.allaPrylar.add(p);
	}
	public void printArrayAllaPrylar(){ //Skriv ut alla prylar
		for (int x = 0; x<allaPrylar.size(); x++){
			System.out.println(allaPrylar.get(x));
		}
	}
	public double totalValue(){ //Alla prylar i AL gås igenom, beräknar totala värdet.
		double totalValue = 0;
		for (int x = 0; x<allaPrylar.size(); x++){
			totalValue = totalValue + (allaPrylar.get(x).getValue());
		}
		return totalValue;
	}

	public void aktieCrash(){
		System.out.print("En aktiekrasch har skett! Alla aktier är värda 0!");
		//Gå igenom allaPrylar och kolla om aktie finns. 
		//Om aktiepryl finns, ska den sätta pricePerPost till 0.
		for (int x = 0; x<allaPrylar.size(); x++){
			if (allaPrylar.get(x) instanceof Aktie){
				Aktie a = (Aktie)allaPrylar.get(x);
				a.changePriceToZero();
			}
		}
	}
}	

	
