abstract class Valuable {
	protected String name;

	public Valuable(String n) {
		name = n;
	}

	abstract public double getValue();

	public String toString2() {
		return name + ", " + getValue();
	}
}
