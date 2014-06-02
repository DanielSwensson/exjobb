class Device extends Valuable {
	private int wear;
	private int purchasePrice;

	public Device(String n, int w, int pp) {
		super(n);
		wear = w;
		purchasePrice = pp;
	}

	public double getValue() {
		return purchasePrice * (wear / 10.0);
	}

}