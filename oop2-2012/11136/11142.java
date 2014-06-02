
public class Share extends Thing {

	private int amount;
	private double price;

	public Share(String name, int amount, double price) {
		super(name);
		this.amount = amount;
		this.price = price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getValue() {
		return amount * price;
	}

}