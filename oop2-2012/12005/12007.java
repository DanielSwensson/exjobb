
public class Apparat extends Pryl{
	private int inköpspris;
	private int slitage;
	
	public Apparat(String na, int in, int sl){
		super (na);
		inköpspris=in;
		slitage=sl;
	}
	public int getInköpspris(){
		return inköpspris;
	}
	public int getSlitage(){
		return slitage;
	}
	public double getVärde(){
		return inköpspris*(0.1*slitage);
	}

}
