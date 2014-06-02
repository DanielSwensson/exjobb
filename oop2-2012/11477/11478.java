public class Smycke extends Pryl {

	private String metall;
	private int antalStenar;

	public Smycke(String namn, String metall, int antalStenar) {
		super(namn);

		this.metall = metall;
		this.antalStenar = antalStenar;

	}

	public double getV�rde() {
		double v�rde = 0.0;
		if (metall.equalsIgnoreCase("guld"))

			v�rde += 2000 + antalStenar * 500;

		else
			v�rde += 700 + antalStenar * 500;

		return v�rde;

	}

	public String toString() {
		return namn + " v�rde " + getV�rde();

	}

}
