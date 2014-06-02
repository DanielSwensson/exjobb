
public class Smycke extends Pryl{

	private int antalÄdelstenar;
	private boolean guld ;
	
	public Smycke(String namn, boolean guld, int antal) {
		super(namn);
		this.antalÄdelstenar = antal;
		this.guld = guld;
		
	}

	
	public double getVärde() {
		int bas;
		
		if(guld == true)
			bas = 2000;
		else
			bas = 700;
		
		return bas + 500*antalÄdelstenar;
	}
	

}
