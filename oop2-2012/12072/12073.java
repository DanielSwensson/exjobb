class Aktie extends Pryl {
	private int antalAktier;
	private int pris;
	private int v�rde;

	Aktie(String namn, int antalAktier, int pris) {
		super(namn);
		this.antalAktier = antalAktier;
		this.pris = pris;

	}

	public void setV�rde(int pris) {
		this.pris = pris;
	}

	public double getV�rde() {
		v�rde = antalAktier * pris;
		return v�rde;

	}

}
