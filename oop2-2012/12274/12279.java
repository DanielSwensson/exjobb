
public class Smycke extends Vardesak{

	private boolean material;
	private int antalÄdelstenar;
	
	//konstruktorn nedan
	public Smycke (String nV, int aÄ, boolean m){
		super (nV);
		antalÄdelstenar=aÄ;
		material=m;
		
	}
	
	//Metod fšr att hŠmta vŠrde.	
	public double getVarde() {
		if (material== true)
			return 2000 + 500 * antalÄdelstenar;
		else
			return 700 + 500 * antalÄdelstenar;

	}
	//Metod fšr att hŠmta material.
	public boolean getMaterial() {
		return material;
		
	}
	//Metod fšr att hŠmta antal Šdelstenar.
	public int getAntalÄdelstenar() {
		return antalÄdelstenar;
	}
		

}


