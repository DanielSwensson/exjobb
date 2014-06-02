package p2;

public class Appliance extends Asset {
	
	private double buyingPrice;
	private int wearLevel;

	public Appliance(String name, double buyingPrice, int wearLevel) {
		super(name);
		this.buyingPrice = buyingPrice;
		this.wearLevel = wearLevel;
	}
	
	public double getValue() {
		return buyingPrice*(wearLevel*0.1);
	}
	
}
