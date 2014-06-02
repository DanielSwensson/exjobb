public class Smycke extends Pryl {

	private int antalStenar;
	private String guld;
	private int v�rde;

	Smycke(String namn, int antalStenar, String guld) {
		super(namn);
		this.antalStenar = antalStenar;
		this.guld = guld;

	}

	public int h�mtaV�rde() {
		if (guld.equalsIgnoreCase("ja")) {
			v�rde = 2000 + (antalStenar * 500);
		} else {
			v�rde = 700 + (antalStenar * 500);
		}
		return v�rde;
	}

	public String toString() {
		return super.toString() + "		" + h�mtaV�rde() + "kr";
	}

}
