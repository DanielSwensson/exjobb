public class Aktie extends Pryl {

	private int pris;
	private int antal;

	public Aktie(int pris, int antal, String namn) {
		super(namn);
		this.pris = pris;
		this.antal = antal;
	}

	public int värde() {
		return pris * antal;
	}

	public String toString() {
		return this.getNamn() + "  " + värde();
	}

	public void börskrasch() {
		this.pris = 0;
	}

}
