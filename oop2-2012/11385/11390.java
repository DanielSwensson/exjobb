public abstract class Item {
	private String itemName;

	abstract public double getValue();

	public Item(String itemName) {
		this.itemName = itemName;
	}

	public String getItemName() {
		return itemName;
	}

	public String toString() {
		return itemName + "		" + getValue();
	}
}
