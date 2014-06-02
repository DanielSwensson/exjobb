
public class Smycke extends Vardesak{

	private boolean material;
	private int antal�delstenar;
	
	//konstruktorn nedan
	public Smycke (String nV, int a�, boolean m){
		super (nV);
		antal�delstenar=a�;
		material=m;
		
	}
	
	//Metod f�r att h�mta v�rde.	
	public double getVarde() {
		if (material== true)
			return 2000 + 500 * antal�delstenar;
		else
			return 700 + 500 * antal�delstenar;

	}
	//Metod f�r att h�mta material.
	public boolean getMaterial() {
		return material;
		
	}
	//Metod f�r att h�mta antal �delstenar.
	public int getAntal�delstenar() {
		return antal�delstenar;
	}
		

}


