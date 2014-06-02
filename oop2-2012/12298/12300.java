package inlupp2;

public class Apparat extends Pryl {

	/* ----------- Attributes ----------- */
	private int purchasePrice, abrasion; // inköpspris och slitage

	
	/* ----------- Construktor ----------- */
	public Apparat(String name, int purchasePrice, int abrasion) {
		super(name);
		this.purchasePrice = purchasePrice;
		this.abrasion = abrasion;
	}

	
	/* ----------- Methods ----------- */
	public int getPrice() { // hämtar priset
		return purchasePrice;
	}

	public int getAbrasion() { // hämtar slitaget
		return abrasion;
	}

	public double getValue() { // hämtar totala värdet
		return (getPrice() * getAbrasion()) / 10;
	}
}
