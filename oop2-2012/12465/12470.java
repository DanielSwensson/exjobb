public class Thing {
	private String thingName;
	private int sort;
	private String owner;
	private double value;

	public Thing(String owner, int sort, String thingName, double value) {
		this.sort = sort;
		this.thingName = thingName;
		this.owner = owner;
		this.value = value;
	}

	public String getThingName() {
		return thingName;
	}

	public int getSort() {
		return sort;
	}

	public double getValue() {
		return value;
	}

	public String getOwner() {
		return owner;
	}

	public String toString() {
		return thingName + "     " + value + " kr";
}
	
	public void changeValue(int newValue) {
		value = newValue;
	}
	
}
