package inlupp2;

public class Aktie extends Pryl {
	/* ----------- Attributes ----------- */
	private int purchasePrice;
	private int amount;

	/* ----------- Construktor ----------- */
	public Aktie(String name, int purchasePrice, int amount) {
		super(name);
		this.purchasePrice = purchasePrice;
		this.amount = amount;
	}

	/* ----------- Methods ----------- */
	public int getPrice() { // hämtar priset
		return purchasePrice;
	}

	public int getAmount() { // hämtar antal
		return amount;
	}

	public double getValue() { // hämtar totala värdet
		return getPrice() * getAmount();
	}
	
	public void setValue(int i) {
		purchasePrice = i;
	}
	
	public void marketCrash() {
		setValue(0);
	}
}
