public class Jewelry extends Property {

	private int metal; // 0 = guld, 1 = silver
	private int gems;

	public Jewelry(String name, int metal, int gems) {
		super(name);
		this.metal = metal;
		this.gems = gems;
	}

	public int getValue() {
		if (metal == 0) {
			return 2000 + (gems * 500);
		} else {
			return 700 + (gems * 500);

		}
	}

}
