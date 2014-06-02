public class Aktie extends pryl {
	private int price;
	private int number;

	public Aktie(String name, int p, int n) {
		super(name);
		price = p;
		number = n;
	}

	public double getValue() {
		return (price * number);
	}

	public String toString() {
		return super.toString() + getValue();
	}

	public void stockCrash() {
		price = 0;
	}
}
