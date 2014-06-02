

public abstract class Accessorie {

	private String itemName;
	private double value;

	public Accessorie(String itemName) {
		this.itemName = itemName;

	}

	public String getItemName() {
		return this.itemName;
	}

	public String setItemName(String itemName) {
		this.itemName=itemName;
		return itemName;
	}

	public double getValue() {
		return this.value;
	}
	
	public double setValue(double value){
		this.value=value;
		return this.value;
	}
}
