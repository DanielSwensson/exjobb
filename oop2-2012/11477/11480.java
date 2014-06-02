public class Apparat extends Pryl {
	private int inköpspris;
	private int slitage;

	public Apparat(String namn, int inköpspris, int slitage) {
		super(namn);

		this.inköpspris = inköpspris;
		this.slitage = slitage;

	}

	public double getVärde() {
		return inköpspris * slitage / 10;

	}

	public String toString() {
		return namn + " värde " + getVärde();

	}

}
