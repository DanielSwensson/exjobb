public class Device extends Item {
	private int newPrice;
	private double wear;

	public Device(String itemName, int newPrice, double wear) {
		super(itemName);
		this.newPrice = newPrice;
		this.wear = wear;
	}

	public double getValue() {
		return newPrice * wear;
	}
}
