
public class Share extends Item {
	
	private int number;
	private double price;
	private double value;
	Share(Object owner, String name, int number, double price) {
		super(owner, name);
		this.number = number;
		this.price = price;
	}
	
	public double getValue() {		
		value = this.number * this.price;
		return value;
	}
	
	public void changePrice(double newPrice) {
		this.price = newPrice;
	}
	
	
	
}
