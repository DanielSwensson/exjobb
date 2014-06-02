public class Smycke extends Pryl {

	private int antal�delstenar;
	private String typAvMetall;

	public Smycke(String prylNamn, int antalStenar, String metallTyp) {
		super(prylNamn);
		antal�delstenar = antalStenar;
		typAvMetall = metallTyp;
	}

	public int f�Stenar() {
		return this.antal�delstenar;
	}

	public double f�V�rde() {
		if (typAvMetall.equalsIgnoreCase("guld")) {
			return 2000.0 + (f�Stenar() * 500);
		} else if (typAvMetall.equalsIgnoreCase("silver")) {
			return 700.0 + (f�Stenar() * 500);
		}
		return 0;
	}

	public String toString() {
		return getNamn() + "\t" + " v�rde: " + f�V�rde();
	}

	public static void main(String[] args) {

	}

}