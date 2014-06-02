public class Device extends Item {
	private int purchasePrice;
	private int wear;

	public Device(String name, int purchasePrice, int wear) {
		super(name);
		this.purchasePrice = purchasePrice;
		this.wear = wear;
	}

	public double getValue() {

		return (purchasePrice * (wear / 10.0));
	}

}
