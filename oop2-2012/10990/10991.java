public class Jewelery extends Item {
	private int stoneAmount;
	private boolean gold;

	Jewelery(String itemName, int stoneAmount, boolean gold) {
		super(itemName);
		this.stoneAmount = stoneAmount;
		this.gold = gold;

	}

	public int getStoneAmount() {
		return stoneAmount;

	}

	public double getWorth() {

		if (gold) {
			return 2000 + (stoneAmount * 500);
		} else {
			return 700 + (stoneAmount * 500);
		}
	}
}
