abstract class Item {
	private String type;
	private int value;
	abstract void setValue();
	
	public int getValue() {
		return value;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public String toString() {
		return type +" - " +value +"kr";
	}
}
