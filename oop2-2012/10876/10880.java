public class Pryl {

	protected String prylNamn;
	protected int v�rde;

	public Pryl(String prylNamn) {
		this.prylNamn = prylNamn;
	}

	public String getnamn() {
		return prylNamn;
	}

	public int getv�rde() {
		return v�rde;
	}

	public String toString() {
		return prylNamn+"\t" + v�rde+"\n";
	}
}