public abstract class Item {
	private String itemName;

	public Item(String itemName) {
		this.itemName = itemName;

	}

	abstract public double getWorth(); {

	}

	public String getItemName() {
		return itemName;
	}
}
