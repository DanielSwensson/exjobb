


public class Apparater extends Pryl {
	
	private String ApparatTyp;
	private int Pris;
	private int Slitage;
	
	
	
	Apparater(String �, String t, String a, int p, int s){
		super(�, t);
		ApparatTyp = a;
		Pris = p;
		Slitage = s;
	}
	
	public String toString(){
		return "Apparat: " + ApparatTyp + " Ny Pris: " + Pris + " Kvalitetsniv�: " + Slitage + " V�rde: "+ getV�rde();
	}
	
	public double getV�rde(){
		return Pris * Slitage /10;
	}
	
	public void nollV�rd(){
		Pris = 0;
	}

}
