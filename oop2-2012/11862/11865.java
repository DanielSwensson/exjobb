abstract class Item {
	private String name;

	abstract public double getValue();

	Item(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return name + " " + getValue();
	}

}
