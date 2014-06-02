// Av Emil Isaksson & Oscar Larsson DSK:1 OOP HT12			

public class Apparat extends Pryl {
	private int inköpspris;
	private int slitage;

	Apparat(String prylNamn, int inköpspris, int slitage) {
		super(prylNamn);
		this.inköpspris = inköpspris;
		this.slitage = slitage;

	}

	public int getInköpspris() {
		return inköpspris;
	}

	public int getSlitage() {
		return slitage;
	}

	public double getVärde() {
		return (slitage/10.0)*inköpspris;
	}
}
