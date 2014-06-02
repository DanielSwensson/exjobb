public class Smycke extends Pryl {

	private int antalStenar;
	private String guld;
	private int värde;

	Smycke(String namn, int antalStenar, String guld) {
		super(namn);
		this.antalStenar = antalStenar;
		this.guld = guld;

	}

	public int hämtaVärde() {
		if (guld.equalsIgnoreCase("ja")) {
			värde = 2000 + (antalStenar * 500);
		} else {
			värde = 700 + (antalStenar * 500);
		}
		return värde;
	}

	public String toString() {
		return super.toString() + "		" + hämtaVärde() + "kr";
	}

}
