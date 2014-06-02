
public class Aktier extends Pryl{
	private String Namn;
	private int Antal;
	private int Pris;
	
	
	Aktier(String ä, String t, String n, int a, int p){
		super(ä , t);
		Namn = n;
		Antal = a;
		Pris = p;
	}
	
	
	public String toString(){
		return "Aktie: " + Namn + " Antal: " + Antal + " Pris/st: " + Pris + " Värde: "+ getVärde();
	}
	
	public double getVärde(){
		return Antal * Pris;
	}
	
	public void nollVärd(){
		Pris = 0;
	}

}
