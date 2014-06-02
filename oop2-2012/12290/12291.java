public class Class_Stock extends Class_Stuff {

	private int amountOfStocks;

	public int getAmountOfStocks() {
		return amountOfStocks;
	}

	public int getStockValue() {

		return this.getValue() / amountOfStocks;
	}

	public void crashValue() {

		this.setValue(0);
	}

	public Class_Stock(int ownerId, String name, int amountOfStocks, int valueOfSingleStock) {

		super(name, valueOfSingleStock * amountOfStocks, ownerId);
		this.amountOfStocks = amountOfStocks;
	}

}
