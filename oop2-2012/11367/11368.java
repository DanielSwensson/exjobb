public class Aktie extends Pryl {

	private int pris;
	private int antal;

	public Aktie(int pris, int antal, String namn) {
		super(namn);
		this.pris = pris;
		this.antal = antal;
	}

	public int v�rde() {
		return pris * antal;
	}

	public String toString() {
		return this.getNamn() + "  " + v�rde();
	}

	public void b�rskrasch() {
		this.pris = 0;
	}

}
