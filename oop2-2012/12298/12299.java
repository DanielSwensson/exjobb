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
	public int getPrice() { // h�mtar priset
		return purchasePrice;
	}

	public int getAmount() { // h�mtar antal
		return amount;
	}

	public double getValue() { // h�mtar totala v�rdet
		return getPrice() * getAmount();
	}
	
	public void setValue(int i) {
		purchasePrice = i;
	}
	
	public void marketCrash() {
		setValue(0);
	}
}
