public class Machine extends Property {

	private int purchasePrice;
	private int condition;

	public Machine(String name, int condition, int purchasePrice) {
		super(name);
		this.purchasePrice = purchasePrice;
		this.condition = condition;
	}

	public int getValue() {
		Double d = purchasePrice * (double)condition / 10;
		return d.intValue();
	}

}
