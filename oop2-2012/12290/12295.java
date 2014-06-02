public class Class_Jewelry extends Class_Stuff {
	public enum enumMaterial {
		gold, silver
	}

	private enumMaterial material;
	private int gemCount = 0;

	public int getGemCount() {
		return this.gemCount;
	}

	public enumMaterial getMaterial() {
		return this.material;
	}

	public Class_Jewelry(int ownerId, String typeOfJewelry,
			enumMaterial material, int gemCount) {

		super(typeOfJewelry, (material == enumMaterial.gold ? 2000 : 700) + (500 * gemCount), ownerId);
		this.material = material;
		this.gemCount = gemCount;
	}

}
