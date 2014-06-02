public class Aktie extends Pryl {
	private double pris;
	private int antal;

	public Aktie(String namn, double pris, int antal) {
		super(namn);
		this.antal = antal;
		this.pris = pris;
	}

	@Override
	public int h�mtaV�rde() {
		return ((int) (antal * pris));
	}

	public void s�ttPrisTillNoll() {
		pris = 0;
	}

}
