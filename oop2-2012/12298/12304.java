package inlupp2;

public class Smycke extends Pryl {
	/* ----------- Attributes ----------- */
	private final static int GOLD = 2000;
	private final static int SILVER = 700;
	private int gemstones;
	private String material;

	
	/* ----------- Construktor ----------- */
	public Smycke(String name, int gemstones, String material) {
		super(name);
		this.gemstones = gemstones;
		this.material = material;
	}

	
	/* ----------- Methods ----------- */
	private int gemAmount() {
		return gemstones;
	}

	public double getValue() { // hämtar totala värdet av material och ädelstenar
		if (material.equalsIgnoreCase("ja")) {
			return GOLD + (gemAmount() * 500);
		} else {
			return SILVER + (gemAmount() * 500);
		}
	}
}
