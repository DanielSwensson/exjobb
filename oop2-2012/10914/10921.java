
public class Share extends Item {
	
	private int quantity;
	private double price;
	
	public Share(String name, int quantity, double price) {
		super(name);
		this.quantity = quantity >= 0 ? quantity : 0;
		this.price = price >= 0 ? price : 0;
	}
	
	public Share(String name) {
		this(name, 0, 0);
	}
	
	public Share(String name, int quantity) {
		this(name, quantity, 0);
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public double getPrice() {
		return price;
	}
	
	public double getValue() {
		return getQuantity() * getPrice();
	}
	
	public void setPrice(double newPrice) {
		price = newPrice >= 0 ? newPrice : 0;
	}

}
