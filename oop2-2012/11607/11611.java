import java.util.*;

public class Person {

	private String namn;
	
	ArrayList<Vardesak> allaVardesaker = new ArrayList<Vardesak>();
	
	//konstruktor
	public Person (String n){
		namn=n;
	}
	
	//metod för att hämta namn
	public String getNamn(){
		return namn;
	}
	
	// metod för att hämta totalt värde i personens egen arraylist 
	public double getTotalVarde(){
		double totalSumma=0;
		for(Vardesak v : allaVardesaker){
			totalSumma=totalSumma + v.getVarde();
		}
		return totalSumma;
	}
	
	//metod för att lägga till värdesaker
	public void addVardesaker(Vardesak v){
		allaVardesaker.add(v);
	}
	// en metod för börschkrach. v instanceof akterier visar att v är en aktier och ingen annan värdesak och krasch() är metoden som heter samma sak som ligger i klassen aktier. 
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

