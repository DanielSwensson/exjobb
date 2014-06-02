public class StockPost extends RegisteryObject {

	private int amount;
	private Stock stock = new Stock("X", 0);

	public StockPost(Stock stock, int amount) {
		this.amount = amount;
		this.stock = stock;
	}

	@Override
	public double getValue() {
		return amount * stock.getPrice();
	}

	@Override
	public String getName() {
		return stock.getName();
	}

}
