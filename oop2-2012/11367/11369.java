public class Apparat extends Pryl {

	private int slitage;
	private int pris;

	public Apparat(int slitage, int pris, String namn) {
		super(namn);
		this.slitage = slitage;
		this.pris = pris;
	}

	public int värde() {
		return ((slitage * pris) / 10);
	}

	public String toString() {
		return this.getNamn() + "  " + värde();
	}

}
