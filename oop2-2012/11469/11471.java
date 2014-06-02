
public class Aktier extends Pryl{
	private String Namn;
	private int Antal;
	private int Pris;
	
	
	Aktier(String �, String t, String n, int a, int p){
		super(� , t);
		Namn = n;
		Antal = a;
		Pris = p;
	}
	
	
	public String toString(){
		return "Aktie: " + Namn + " Antal: " + Antal + " Pris/st: " + Pris + " V�rde: "+ getV�rde();
	}
	
	public double getV�rde(){
		return Antal * Pris;
	}
	
	public void nollV�rd(){
		Pris = 0;
	}

}
