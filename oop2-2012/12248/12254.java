
public class Smycke extends Pryl{

	private int antal�delstenar;
	private boolean guld ;
	
	public Smycke(String namn, boolean guld, int antal) {
		super(namn);
		this.antal�delstenar = antal;
		this.guld = guld;
		
	}

	
	public double getV�rde() {
		int bas;
		
		if(guld == true)
			bas = 2000;
		else
			bas = 700;
		
		return bas + 500*antal�delstenar;
	}
	

}
