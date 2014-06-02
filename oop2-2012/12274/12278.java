import java.util.*;

public class Person {

	private String namn;
	
	ArrayList<Vardesak> allaVardesaker = new ArrayList<Vardesak>();
	
	//Konstruktor
	public Person (String n){
		namn=n;
	}
	
	//Metod fšr att hŠmta namn
	public String getNamn(){
		return namn;
	}
	
	//Metod fšr att hŠmta totalt vŠrde i personens egen arraylist 
	public double getTotalVarde(){
		double totalSumma=0;
		for(Vardesak v : allaVardesaker){
			totalSumma=totalSumma + v.getVarde();
		}
		return totalSumma;
	}
	
	//Metod fšr att lŠgga till vŠrdesaker
	public void addVardesaker(Vardesak v){
		allaVardesaker.add(v);
	}
	//Metod fšr bšrskrasch. v instanceof aktier visar att v Šr en aktier och ingen annan vŠrdesak och krasch() Šr metoden som heter samma sak som ligger i klassen aktier. 
	public void börsKrasch(){
		for(Vardesak v : allaVardesaker)
			if (v instanceof Aktie)
				((Aktie) v).krasch();
	}
	
	public String getAllaVardesaker(){
		String vardesaker = "";
		for(Vardesak v : allaVardesaker)
			vardesaker = vardesaker + v.getVardesaksNamn()+" " + v.getVarde()+ " ";
		return vardesaker;
		
	}
	
	public String toString(){
		return namn;
	}
}

