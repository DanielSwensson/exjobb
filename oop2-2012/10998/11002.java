class Shareholding extends Valuable {
	private int amount;
	private int price;

	public Shareholding(String n, int a, int p) {
		super(n);
		amount = a;
		price = p;
	}

	public double getValue() {
		return amount * price;
	}

	public void setPriceToZero() {
		this.price = 0;
	}
}
