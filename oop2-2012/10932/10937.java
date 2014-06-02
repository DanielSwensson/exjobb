public class Electronics extends Item {
	private double initialPrice;
	private double itemCondition = 10;

	public Electronics(String name, int initialPrice, int itemCondition) {
		if (itemCondition > 10) {
			itemCondition = 10;
		} else if (itemCondition < 1) {
			itemCondition = 1;
		}
		this.name = name;
		this.initialPrice = initialPrice;
		this.itemCondition = itemCondition;
	}

	@Override
	public double calculateValue() {
		return initialPrice * (itemCondition / 10);
	}
}
