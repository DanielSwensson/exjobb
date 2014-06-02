
public class Appliance extends Valuable {

	private int purchasePrice;
	private int wear;
	
	public Appliance(String name, int purchasePrice, int wear) {
		super(name);
		
		this.purchasePrice = purchasePrice;
	    this.wear = wear;
		
	}
	
	public int getWear() {
	
		return wear;
	}
	
	public int getPurchasePrice() {
		
		return purchasePrice;
	}
	public double value() {
		
		return purchasePrice * (wear * 0.1);
	}
	public String toString() {
		
		return super.toString() + "Purchaseprice: " + purchasePrice + "kr. number of wear: " + wear + ".";
	}
}
