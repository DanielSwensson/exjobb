public class Aktier extends Pryl {
	private String namn;
	private int antal;
	private int pris;

	Aktier (String �, String n, int a, int p){
		super(�);
		namn = n;
		antal = a;
		pris = p;
	}

	public String toString(){
		return "Aktie " +namn +" �r i antal " +antal +" . Och �r v�rda " +getV�rde() +" kr.";
	}

	public void bKrasch(){
		pris = 0;
	}
	
	public double getV�rde(){
		return antal * pris;
	}
}
