
public class Aktie extends Pryl {
	
	private double styckpris;
	private int antal;
	
	
	public Aktie(String tap, double styckpris, int antal){
		super (tap);
	this.antal = antal;
	this.styckpris = styckpris;
	}
	
	public void b�rskrasch(){
		styckpris = 0;		
	}

	@Override
	public double getValue() {		 		
		return styckpris * antal;
	}
	
}
