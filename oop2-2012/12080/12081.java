public class Aktie extends Pryl {
	private int antal;
	private int pris;
	private int v�rde;

	Aktie(String namn, int antal, int pris) {
		super(namn);
		this.antal = antal;
		this.pris = pris;
	}

	public int h�mtaV�rde() {
		v�rde = (antal * pris);
		return v�rde;
	}

	public int h�mtaAntal() {
		return antal;
	}

	public int h�mtapris() {
		return pris;
	}

	public void nollst�llV�rde() {
		this.pris = 0;
	}

	public String toString() {
		return super.toString() + "		" + v�rde;
	}
}
