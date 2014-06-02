public class Apparat extends Vardesak{
	private double inköpsPris;
	private int slitage;
	
	//konstruktor nedan
	public Apparat (String nV, double iP, int sL){
		super(nV);
		inköpsPris=iP;
		slitage=sL;
		
	}
	//metod för att hämta värde
	public double getVarde() {
		return ((double)slitage / 10) * inköpsPris;
		
	}
	// metod för att hämta inköpspris
	public double getInköpspris(){
		return inköpsPris;
	}
	//metod för att hämta slitage
	public int getSlitage(){
		return slitage;
	}
	
}


