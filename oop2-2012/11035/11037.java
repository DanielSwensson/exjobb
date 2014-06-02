
public class Apparat extends Pryl {

	private int inköpspris;
	private double slitage;


	public Apparat (int inköpsp, double slit, String pt, String n){
		super (pt, n);
		inköpspris = inköpsp;
		slitage = slit; 

	}

	public double getSlitage(){
		return slitage;
	}

	public int getInköpspris(){
		return inköpspris;
	}

	public double getVärde(){
		return inköpspris *(slitage/10.0);	
	}

}


