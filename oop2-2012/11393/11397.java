package varderegister;

public class Ovrigt extends Pryl{

	double pris;
	
	public Ovrigt(String typ, double pris){
		super(typ);
		this.pris = pris;
	}
	
	public double varde(){
		return pris;
	}
	
}
