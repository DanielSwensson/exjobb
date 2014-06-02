public abstract class pryl {
	private String name;

	public pryl(String n) {
		name = n;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return getName() + " ";
	}

	public void stockCrash() {

	}

	public double getValue() {
		return 0;
	}
}
