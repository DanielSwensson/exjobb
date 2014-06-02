public class Jewelry extends Possession {
	private int material;
	private int jewels;

	public Jewelry(String poNa, int mat, int jew) {
		super(poNa);
		material = mat;
		jewels = jew;
	}
	
	public int getMaterial() {
		return material;
	}
	
	public int getJewels() {
		return jewels;
	}
	
	public int getWorth() {
		if (material == 1) {
			return 2000 + (500 * jewels);
		}
		else {
			return 700 + (500 * jewels);
		}
	}
	
}
