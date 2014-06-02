
public class Device extends Valuable {

	private int purchasePrice;
	private int wear;
	
	// Konstruktor
	public Device (String itemName, int purchasePrice, int wear) {
		super(itemName);
		this.purchasePrice = purchasePrice;
		this.wear = wear;
	}
	

	// Ber�knar v�rdet av en apparat
	public int value() {
		return (purchasePrice/10)*wear;
	}

}
