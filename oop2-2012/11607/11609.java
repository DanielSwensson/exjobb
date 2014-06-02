public class Apparat extends Vardesak{
	private double ink�psPris;
	private int slitage;
	
	//konstruktor nedan
	public Apparat (String nV, double iP, int sL){
		super(nV);
		ink�psPris=iP;
		slitage=sL;
		
	}
	//metod f�r att h�mta v�rde
	public double getVarde() {
		return ((double)slitage / 10) * ink�psPris;
		
	}
	// metod f�r att h�mta ink�pspris
	public double getInk�pspris(){
		return ink�psPris;
	}
	//metod f�r att h�mta slitage
	public int getSlitage(){
		return slitage;
	}
	
}


