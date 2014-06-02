public abstract class Accessorie {

	private String itemName;
	private double value;

	private String type;

	public Accessorie(String itemName) {
		this.itemName = itemName;

	}

	public abstract double getValue();

	public String toString() {
		return type + ", Value:" + getValue() + ",";
	}

	public String getItemName() {
		return itemName;
	}

	public String setItemName(String itemName) {

		return itemName;
	}

	public double setValue(double value) {
		this.value = value;
		return this.value;
	}
}
