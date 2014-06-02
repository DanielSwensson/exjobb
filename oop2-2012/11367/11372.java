public class Smycke extends Pryl {

	private int �delstenar;
	private int metall;

	public Smycke(int �delstenar, String metall, String namn) {
		super(namn);
		this.�delstenar = �delstenar;
		if (metall.equalsIgnoreCase("guld")) {
			this.metall = 2000;
		} else if (metall.equalsIgnoreCase("silver")) {
			this.metall = 700;
		}
	}

	public int v�rde() {
		return metall + (�delstenar * 500);
	}

	public String toString() {
		return this.getNamn() + "  " + v�rde();
	}
}
