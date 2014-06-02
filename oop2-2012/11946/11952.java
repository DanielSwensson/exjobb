public class Stock extends Accessorie {
	private int amount;
	private int price;

	Stock(String name, int amount, int price) {
		super(name);
		this.amount = amount;
		this.price = price;
		setValue(getValue());

	}

	public String setName(String name) {
		return name;
	}

	public int setAmount(int amount1) {
		return amount;

	}

	public void setPrice(int price) {
		this.price = price;
		System.out.println("setPrice!! " + this.price);
	}

	public void crash() {
		setValue(0);
	}

	public String getNamne(String name) {
		return name;
	}

	public int getAmount() {
		return amount;

	}

	public int getPrice() {
		return price;
	}

	public void stockCrash() {
		price = 0;
	}

	public double getValue() {
		double tempValue = (double) amount * price;
		return tempValue;

	}

}
