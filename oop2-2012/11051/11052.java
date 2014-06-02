class Aktie extends Pryl {
	private int aktieVärde;
	private int antalAktier;

	Aktie(String nyTyp, int n, int i) {
		super(nyTyp);
		aktieVärde = n;
		antalAktier = i;

	}

	int totAktieVärdet;

	public int getValue() {
		totAktieVärdet = antalAktier * aktieVärde;
		return totAktieVärdet;
	}

	public void setAktieVärde(int nyttVärde) {
		aktieVärde = nyttVärde;
		// return aktieVärde;void
	}
}
