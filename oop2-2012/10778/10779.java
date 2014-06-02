public class Aktie extends Pryl {

	private int aktieAntal, pris;

	public Aktie(String namn, int aktieAntal, int pris) {
		super(namn);
		this.aktieAntal = aktieAntal;
		this.pris = pris;
	}

	public int getVärde() {
		return aktieAntal * pris;
	}
	public void getKrasch() {
		pris = 0;
	}
}
