public class Aktie extends Pryl {
	private double pris;
	private int antal;

	public Aktie(String namn, double pris, int antal) {
		super(namn);
		this.antal = antal;
		this.pris = pris;
	}

	@Override
	public int hämtaVärde() {
		return ((int) (antal * pris));
	}

	public void sättPrisTillNoll() {
		pris = 0;
	}

}
