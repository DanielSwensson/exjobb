
public class Apparat extends Pryl{
	private int ink�pspris;
	private int slitage;
	
	public Apparat(String na, int in, int sl){
		super (na);
		ink�pspris=in;
		slitage=sl;
	}
	public int getInk�pspris(){
		return ink�pspris;
	}
	public int getSlitage(){
		return slitage;
	}
	public double getV�rde(){
		return ink�pspris*(0.1*slitage);
	}

}
