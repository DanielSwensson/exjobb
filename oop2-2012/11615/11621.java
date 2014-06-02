package valuables;

public class Stock extends Valuable {
	private int price;
	private final int quantity;

	public Stock(String name, int price, int quantity) {
		super(name);
		this.price = price;
		this.quantity = quantity;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	@Override
	public int getValue() {
		return getPrice() * getQuantity();
	}

	public void setStockMarketCrash() {
		setPrice(0);
	}
}
