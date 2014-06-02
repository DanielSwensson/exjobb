public class Smycke extends Pryl {

	private int ädelstenar;
	private int metall;

	public Smycke(int ädelstenar, String metall, String namn) {
		super(namn);
		this.ädelstenar = ädelstenar;
		if (metall.equalsIgnoreCase("guld")) {
			this.metall = 2000;
		} else if (metall.equalsIgnoreCase("silver")) {
			this.metall = 700;
		}
	}

	public int värde() {
		return metall + (ädelstenar * 500);
	}

	public String toString() {
		return this.getNamn() + "  " + värde();
	}
}
