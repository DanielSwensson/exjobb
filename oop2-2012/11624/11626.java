public class Apparater extends Pryl {
	private String namn;
	private int pris;
	private int slitage;

	Apparater (String �, String n, int p, int s){
		super(�);
		namn = n;
		pris = p;
		slitage = s;
	}

	public String toString(){
		return "Apparaten �r en/ett " +namn +" och �r v�rd " +getV�rde() +" kr."; 
	}

	public double getV�rde(){
		return pris * slitage/10;
	}
}
