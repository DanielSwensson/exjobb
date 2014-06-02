
public class Stock extends Item {
	private int stockAmount;
	private int stockPrice;

	public Stock(String itemName, int stockAmount, int stockPrice) {
		super(itemName);
		this.stockAmount = stockAmount;
		this.stockPrice = stockPrice;
	}

	public int getStockAmount() {
		return stockAmount;
	}

	public int getStockPrice() {
		return stockPrice;
	}

	public double getWorth() {
		return stockAmount * stockPrice;
	}

	public int crashedStockMarket() {
		return stockPrice = 0;
	}
}
