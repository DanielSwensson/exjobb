public class Jewelry extends Thing {

	private String name;
	private int gemstones;
	private boolean gold;

	public Jewelry(String name, int gemstones, boolean gold) {
		this.name = name;
		this.gemstones = gemstones;
		this.gold = gold;

	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getValue() {
		double value = 0;

		if (gold == true) {
			value = 2000;
		}
		else {
			value = 700;
		}

		value += (gemstones * 500);
		return value;
	}

}
