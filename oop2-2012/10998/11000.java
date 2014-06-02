class Jewelery extends Valuable {
	private String metal;
	private int jewels;

	public Jewelery(String n, String m, int j) {
		super(n);
		metal = m;
		jewels = j;

	}

	public double getValue() {

		if (metal.equalsIgnoreCase("guld")) {
			return 2000 + (jewels * 500);
		}
		
		if (metal.equalsIgnoreCase("silver")) {
			return 700 + (jewels * 500);
		
		} else {
			return 0;

		}
	}
}