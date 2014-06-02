package inlupp2;

public class Apparat extends Pryl {

	/* ----------- Attributes ----------- */
	private int purchasePrice, abrasion; // ink�pspris och slitage

	
	/* ----------- Construktor ----------- */
	public Apparat(String name, int purchasePrice, int abrasion) {
		super(name);
		this.purchasePrice = purchasePrice;
		this.abrasion = abrasion;
	}

	
	/* ----------- Methods ----------- */
	public int getPrice() { // h�mtar priset
		return purchasePrice;
	}

	public int getAbrasion() { // h�mtar slitaget
		return abrasion;
	}

	public double getValue() { // h�mtar totala v�rdet
		return (getPrice() * getAbrasion()) / 10;
	}
}
