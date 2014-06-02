public class Apparat extends pryl {
	private double price;
	private double damage;

	public Apparat(String name, double p, double d) {
		super(name);
		price = p;
		damage = d;
	}

	public double getValue() {
		return (price * (damage / 10));
	}

	public String toString() {
		return super.toString() + getValue();
	}
}