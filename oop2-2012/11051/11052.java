class Aktie extends Pryl {
	private int aktieV�rde;
	private int antalAktier;

	Aktie(String nyTyp, int n, int i) {
		super(nyTyp);
		aktieV�rde = n;
		antalAktier = i;

	}

	int totAktieV�rdet;

	public int getValue() {
		totAktieV�rdet = antalAktier * aktieV�rde;
		return totAktieV�rdet;
	}

	public void setAktieV�rde(int nyttV�rde) {
		aktieV�rde = nyttV�rde;
		// return aktieV�rde;void
	}
}
