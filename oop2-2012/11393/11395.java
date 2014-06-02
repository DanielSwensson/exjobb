package varderegister;

public class Apparat extends Pryl{
	
	private double inkopspris;
	private int skick;
	
	public Apparat(String namn, double inkopspris, int state){
		super(namn);
		this.inkopspris = inkopspris;
		this.skick = state;
		super.namn = namn;
	}
	
	public String getNamn(){
		return this.namn;
	}
	
	public double varde(){
		double varde = inkopspris*(this.skick/10.0);
		return varde;
	}

}
