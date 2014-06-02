public abstract class Item {
	protected String name;

	public String getName() {
		return name;
	}

	public abstract double getValue();

	public String toString() {
		return name + " " + getValue();
	}

	public void affectByStockcrash() {

	}
}