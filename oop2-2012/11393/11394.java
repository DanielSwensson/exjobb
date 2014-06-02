package varderegister;

public class Aktie extends Pryl{
	
	private int antal;
	private double pris;

	public Aktie(String namn, int antal, double pris){
		super(namn);
		this.antal = antal;
		this.pris = pris;
		super.namn = namn;
	}
	
	public void setPris(double pris){
		this.pris=pris;
	}
	
	public double varde(){
		return pris*antal;
	}
	
	public String getNamn(){
		return super.namn;
	}
}
