public class Gadget extends Item {
	private int purchasePrice;
	private int condition;

	Gadget(String itemName, int purchasePrice, int condition) {
		super(itemName);
		this.purchasePrice = purchasePrice;
		this.condition = condition;

	}

	public int getPurchasePrice() {
		return purchasePrice;
	}

	public int getCondition() {
		return condition;
	}

	public double getWorth() {
		return (condition / 10.0) * purchasePrice;
	}
}
