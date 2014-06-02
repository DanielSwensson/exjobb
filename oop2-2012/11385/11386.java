public class Stock extends Item {
	private double stockValue;
	private int stockAmount;

	public Stock(String itemName, double stockValue, int stockAmount) {
		super(itemName);
		this.stockValue = stockValue;
		this.stockAmount = stockAmount;
	}

	public double getValue() {
		return stockValue * stockAmount;
	}
	
	public void setStockAmount(int stockAmount) {
		this.stockAmount += stockAmount;
	}
	
	public void setStockValue(double stockValue) {
		this.stockValue = stockValue;
	}
}
