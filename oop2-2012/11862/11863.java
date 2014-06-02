public class Stock extends Item {
	private int quantity;
	private int unitPrice;

	public Stock(String name, int quantity, int unitPrice) {
		super(name);
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public void setValue(int quantity, int unitPrice) {
		this.unitPrice = unitPrice;
		this.quantity += quantity;
	}

	public double getValue() {

		return quantity * unitPrice;
	}

}