public class Aktie extends Pryl {

	// private String aktieNamn;
	private int aktiePris;
	private int aktieAntal;
	private int aktieVarde;

	public Aktie(String prylSort, String aktieNamn, int aktiePris,
			int aktieAntal) {
		super(prylSort, aktieNamn);
		// this.aktieNamn = aktieNamn;
		this.aktiePris = aktiePris;
		this.aktieAntal = aktieAntal;
		aktieVarde = aktieAntal * aktiePris;
	}

	public int getVarde() {
		return aktieVarde;
	}

	public void setVarde(int nyttVarde) {
		aktieVarde = nyttVarde;
	}

}
