public class Apparat extends Vardesak{
	private double inkopsPris;
	private int slitage;
	
	//Konstruktor
	public Apparat (String nV, double iP, int sL){
		super(nV);
		inkopsPris=iP;
		slitage=sL;
		
	}
	//Metod fšr att hŠmta vŠrde
	public double getVarde() {
		return ((double)slitage / 10) * inkopsPris;
		
	}
	//Metod fšr att hŠmta inkšpspris
	public double getInköpspris(){
		return inkopsPris;
	}
	//Metod fšr att hŠmta slitage
	public int getSlitage(){
		return slitage;
	}
	
}


