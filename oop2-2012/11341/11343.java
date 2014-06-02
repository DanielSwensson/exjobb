// Av Emil Isaksson & Oscar Larsson DSK:1 OOP HT12			

public class Apparat extends Pryl {
	private int ink�pspris;
	private int slitage;

	Apparat(String prylNamn, int ink�pspris, int slitage) {
		super(prylNamn);
		this.ink�pspris = ink�pspris;
		this.slitage = slitage;

	}

	public int getInk�pspris() {
		return ink�pspris;
	}

	public int getSlitage() {
		return slitage;
	}

	public double getV�rde() {
		return (slitage/10.0)*ink�pspris;
	}
}
