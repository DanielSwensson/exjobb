
public class Jewellery extends Thing {

	private String material;
	private int gemstone;

	public Jewellery(String name, String material, int gemstone) {
		super(name);
		this.material = material;
		this.gemstone = gemstone;		
	}

	public double getValue() {
		if (material.equalsIgnoreCase("gold")) {
			return 2000 + (500 * gemstone);
		} else {
			return 700 + (500 * gemstone);
		}
	}

}