public class Apparat extends Pryl {
	private int ink�pspris;
	private int slitage;

	public Apparat(String namn, int ink�pspris, int slitage) {
		super(namn);

		this.ink�pspris = ink�pspris;
		this.slitage = slitage;

	}

	public double getV�rde() {
		return ink�pspris * slitage / 10;

	}

	public String toString() {
		return namn + " v�rde " + getV�rde();

	}

}
