public class Jewelry extends Item {
	public static final int GOLD = 1;
	public static final int SILVER = 2;
	private int material;
	private int numberOfGemstones;

	public Jewelry(int material, int numberOfGemstones, String name) {
		this.material = material;
		this.numberOfGemstones = numberOfGemstones;
		this.name = name;
	}

	@Override
	public double calculateValue() {
		if (material == GOLD) {
			return 2000 + (500 * numberOfGemstones);
		} else {
			return 700 + (500 * numberOfGemstones);
		}
	}

}