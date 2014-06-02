public class Smycke extends Pryl {

	private int antalÄdelstenar;
	private String typAvMetall;

	public Smycke(String prylNamn, int antalStenar, String metallTyp) {
		super(prylNamn);
		antalÄdelstenar = antalStenar;
		typAvMetall = metallTyp;
	}

	public int fåStenar() {
		return this.antalÄdelstenar;
	}

	public double fåVärde() {
		if (typAvMetall.equalsIgnoreCase("guld")) {
			return 2000.0 + (fåStenar() * 500);
		} else if (typAvMetall.equalsIgnoreCase("silver")) {
			return 700.0 + (fåStenar() * 500);
		}
		return 0;
	}

	public String toString() {
		return getNamn() + "\t" + " värde: " + fåVärde();
	}

	public static void main(String[] args) {

	}

}