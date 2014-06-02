class Aktie extends Pryl {
	private int antalAktier;
	private int pris;
	private int värde;

	Aktie(String namn, int antalAktier, int pris) {
		super(namn);
		this.antalAktier = antalAktier;
		this.pris = pris;

	}

	public void setVärde(int pris) {
		this.pris = pris;
	}

	public double getVärde() {
		värde = antalAktier * pris;
		return värde;

	}

}
