
public class Apparat extends Pryl {

	private int ink�pspris;
	private double slitage;


	public Apparat (int ink�psp, double slit, String pt, String n){
		super (pt, n);
		ink�pspris = ink�psp;
		slitage = slit; 

	}

	public double getSlitage(){
		return slitage;
	}

	public int getInk�pspris(){
		return ink�pspris;
	}

	public double getV�rde(){
		return ink�pspris *(slitage/10.0);	
	}

}


