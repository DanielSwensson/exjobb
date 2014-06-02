public class Aktier extends Pryl {
	private String namn;
	private int antal;
	private int pris;

	Aktier (String ä, String n, int a, int p){
		super(ä);
		namn = n;
		antal = a;
		pris = p;
	}

	public String toString(){
		return "Aktie " +namn +" är i antal " +antal +" . Och är värda " +getVärde() +" kr.";
	}

	public void bKrasch(){
		pris = 0;
	}
	
	public double getVärde(){
		return antal * pris;
	}
}
