public class Share extends Thing {

	private String name;
	private int amount;
	private double price;

	public Share(String name, int amount, double price) {
		this.name = name;
		this.amount = amount;
		this.price = price;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getValue() {
		return price * amount;
	}

	public void setPrice(double newPrice) {
		price = newPrice;
	}

}
