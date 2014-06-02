package valuables;

public class Jewelry extends Valuable {
	enum Material {
		SILVER, GOLD
	}
	private final int numberOfGems;
	private final Material material;

	public Jewelry(String name, int numberOfGems, Material material) {
		super(name);
		this.numberOfGems = numberOfGems;
		this.material = material;
	}

	@Override
	public int getValue() {
		return (material == Material.GOLD ? 2000 : 700) + (500 * numberOfGems);
	}

	@Override
	public String toString() {
		return getName();
	}

}
