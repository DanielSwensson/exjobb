public class Stock extends Item {
	private int amount;
	private int price;

	public Stock(String name, int amount, int price) {
		this.name = name;
		this.amount = amount;
		this.price = price;
	}

	@Override
	public double calculateValue() {
		return amount * price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
