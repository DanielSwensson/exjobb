abstract class Property {

	private String name;

	public Property(String name) {
		this.name = name;
	}

	abstract public int getValue();

	public String toString() {
		return String.format("%-15s %-15d", name, getValue());
	}

}
