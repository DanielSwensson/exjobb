public class Smycke extends Pryl {

	private String metall;
	private int antalStenar;

	public Smycke(String namn, String metall, int antalStenar) {
		super(namn);

		this.metall = metall;
		this.antalStenar = antalStenar;

	}

	public double getVärde() {
		double värde = 0.0;
		if (metall.equalsIgnoreCase("guld"))

			värde += 2000 + antalStenar * 500;

		else
			värde += 700 + antalStenar * 500;

		return värde;

	}

	public String toString() {
		return namn + " värde " + getVärde();

	}

}
