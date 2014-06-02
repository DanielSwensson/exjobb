public class Apparat extends Vardesak{
	private double inkopsPris;
	private int slitage;
	
	//Konstruktor
	public Apparat (String nV, double iP, int sL){
		super(nV);
		inkopsPris=iP;
		slitage=sL;
		
	}
	//Metod f�r att h�mta v�rde
	public double getVarde() {
		return ((double)slitage / 10) * inkopsPris;
		
	}
	//Metod f�r att h�mta ink�pspris
	public double getInk�pspris(){
		return inkopsPris;
	}
	//Metod f�r att h�mta slitage
	public int getSlitage(){
		return slitage;
	}
	
}


