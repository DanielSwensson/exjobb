package p2;

public class JewelleryItem extends Asset {

	private boolean isGold;
	private int noOfGems;

	public JewelleryItem(String name, boolean isGold, int noOfGems) {
		super(name);
		this.isGold = isGold;
		this.noOfGems = noOfGems;
	}

	public double getValue() {
		if (isGold)
			return 2000+(noOfGems*500);
		else
			return 700+(noOfGems*500);	
	}
	
}
