public class Aktie extends Pryl {
	private int antal;
	private int pris;
	private int värde;

	Aktie(String namn, int antal, int pris) {
		super(namn);
		this.antal = antal;
		this.pris = pris;
	}

	public int hämtaVärde() {
		värde = (antal * pris);
		return värde;
	}

	public int hämtaAntal() {
		return antal;
	}

	public int hämtapris() {
		return pris;
	}

	public void nollställVärde() {
		this.pris = 0;
	}

	public String toString() {
		return super.toString() + "		" + värde;
	}
}
