
public class Smycke extends Vardesak{

	private boolean material;
	private int antalÄdelstenar;
	
	//konstruktorn nedan
	public Smycke (String nV, int aÄ, boolean m){
		super (nV);
		antalÄdelstenar=aÄ;
		material=m;
		
	}
	
	//en metod för att hämta värde	
	public double getVarde() {
		if (material== true)
			return 2000 + 500 * antalÄdelstenar;
		else
			return 700 + 500 * antalÄdelstenar;

	}
	//en metod för att hämta material
	public boolean getMaterial() {
		return material;
		
	}
	// en metod fšr att hŠmta antal Šdelstenar
	public int getAntalÄdelstenar() {
		return antalÄdelstenar;
	}
		

}


