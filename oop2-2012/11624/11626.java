public class Apparater extends Pryl {
	private String namn;
	private int pris;
	private int slitage;

	Apparater (String ä, String n, int p, int s){
		super(ä);
		namn = n;
		pris = p;
		slitage = s;
	}

	public String toString(){
		return "Apparaten är en/ett " +namn +" och är värd " +getVärde() +" kr."; 
	}

	public double getVärde(){
		return pris * slitage/10;
	}
}
