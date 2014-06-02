public class Stock extends Thing {
	private int number;
	private int price;

	public Stock(String owner, int sort, String thingName, double value, int number,
			int price) {
		super(owner, sort, thingName, value);
		this.number = number;
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public int getPrice() {
		return price;
	}

	public static int getStockValue(int number, int price) {
		return (number * price);
	}
}

