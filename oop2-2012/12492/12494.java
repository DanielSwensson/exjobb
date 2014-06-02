package Inlupp2;

public class Jewelry extends Valuable {

	private String metal;
	private int gemstone;

	public Jewelry(String name, String metal, int gemstone) {
		super(name);
		this.metal=metal;
		this.gemstone=gemstone;
	}
	public double getWorth(){
		int worth = 0;
		boolean metalIsGold = false;
		if (metal  .equalsIgnoreCase ("ja")){
			worth=2000+(500*gemstone);
			metalIsGold = true;					
		}
		if (!metalIsGold){
			worth=700+(500*gemstone);
		}
		return worth;
	}

}


