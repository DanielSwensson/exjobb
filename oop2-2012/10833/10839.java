public class Smycke extends Pryl {

	private int antal�delstenar;
	private int material;

	public Smycke(String n, int a�, int m) {
		super(n);
		antal�delstenar = a�;
		material = m;

		if (m == 1) {
			material = 2000;

		} else {
			material = 700;
		}

	}

	public int getAntal�delstenar() {
		return antal�delstenar;
	}

	public int getV�rde() {
		return (antal�delstenar * 500) + material;
	}

	public int getMaterial() {
		return material;

	}
}
