public class Aktie extends Pryl {

	private String prylnamn;
	private int pris;
	private int antal;

	public Aktie(String prylnamn, int pris, int antal) {
		super(prylnamn);
		this.pris = pris;
		this.antal = antal;
		this.prylnamn = prylnamn;
	}

	public int getV�rde() {
		return (antal * pris);
	}

	public int setPris() {
		pris = 0;
		return pris;
	}

	public String toString() {

		return (prylnamn + " har v�rdet " + getV�rde());
	}
}
