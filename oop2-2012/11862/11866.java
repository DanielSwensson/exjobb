public class Jewelery extends Item {
	private int golden;
	private int totalGemstones;

	Jewelery(String name, int golden, int totalGemstones) {
		super(name);
		this.golden = golden;
		this.totalGemstones = totalGemstones;
	}

	public double getValue() {

		int value = 0;

		if (golden == 1) {
			value = 2000;
		} else {
			value = 700;
		}

		value += (totalGemstones * 500);

		return value;

	}

}
