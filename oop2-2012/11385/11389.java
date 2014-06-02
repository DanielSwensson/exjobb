public class Jewelry extends Item {
	private int jewelryType;
	private int gemstones;

	public Jewelry(String itemName, int jewelryType, int gemstones) {
		super(itemName);
		this.jewelryType = jewelryType;
		this.gemstones = gemstones;
	}

	public double getValue() {
		return jewelryType + gemstones;
	} 
}
