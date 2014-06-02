public class Pryl {

	protected String prylNamn;
	protected int värde;

	public Pryl(String prylNamn) {
		this.prylNamn = prylNamn;
	}

	public String getnamn() {
		return prylNamn;
	}

	public int getvärde() {
		return värde;
	}

	public String toString() {
		return prylNamn+"\t" + värde+"\n";
	}
}