abstract class Item {

	private String name;
	private int value;

	//Constructor
	public Item(String name, int value) {
		this.name = name;
		this.value = value;
	}
	public void setValue(){
		this.value=0;
	}
	public String toString() {
		return name + "	Value: " + value;
	}

}
