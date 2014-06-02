
public class Jewelry extends Valuable {

	private boolean gold;
	private int gemstones;
	
	// Konstruktor
	public Jewelry (String itemName, boolean gold, int gemstones) {
		super(itemName);
		this.gold = gold;
		this.gemstones = gemstones;
	}

	// Beräknar värdet av ett smycke
	public int value() {
		if (gold == true) {
			return 2000+(gemstones*500);
		} else { 	
			return 700+(gemstones*500);
		}
	}

}

