


public class Apparater extends Pryl {
	
	private String ApparatTyp;
	private int Pris;
	private int Slitage;
	
	
	
	Apparater(String ä, String t, String a, int p, int s){
		super(ä, t);
		ApparatTyp = a;
		Pris = p;
		Slitage = s;
	}
	
	public String toString(){
		return "Apparat: " + ApparatTyp + " Ny Pris: " + Pris + " Kvalitetsnivå: " + Slitage + " Värde: "+ getVärde();
	}
	
	public double getVärde(){
		return Pris * Slitage /10;
	}
	
	public void nollVärd(){
		Pris = 0;
	}

}
