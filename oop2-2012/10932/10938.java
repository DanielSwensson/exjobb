public abstract class Item {
	protected String name;
	public abstract double calculateValue();

	public String toString() {
		return String.format("%-10s", name) + " " + calculateValue();
	}

	public String getName() {
		return name;
	}
}
