public class Apparatus extends Item {
	private int purchasePrice;
	private int levelOfWear;
	
	public Apparatus(String type, int purchasePrice, int levelOfWear) {
		setType(type);
		this.purchasePrice = purchasePrice;
		this.levelOfWear = levelOfWear;
		setValue();
	}
	
	public void setValue() {
		float value = ((float)levelOfWear/10)*purchasePrice;
		setValue(Math.round(value));
	}
}
