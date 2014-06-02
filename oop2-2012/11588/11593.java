package p2;

public class ShareHolding extends Asset {
	
	private double price;
	private int noOfShares;
	
	public ShareHolding(String name, double price, int noOfShares) {
		super(name);
		this.price = price;
		this.noOfShares = noOfShares;
	}
	
	public void setPrice(double newPrice) {
		this.price = newPrice;
	}
	
	public double getValue() {
		return price*noOfShares;
	}
	

}
