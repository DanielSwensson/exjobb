public class Smycke extends Pryl {

	private int antal€delstenar;
	private int material;

	public Smycke(String n, int aŠ, int m) {
		super(n);
		antal€delstenar = aŠ;
		material = m;

		if (m == 1) {
			material = 2000;

		} else {
			material = 700;
		}

	}

	public int getAntal€delstenar() {
		return antal€delstenar;
	}

	public int getVŠrde() {
		return (antal€delstenar * 500) + material;
	}

	public int getMaterial() {
		return material;

	}
}
