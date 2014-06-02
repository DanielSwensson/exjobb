
public class Apparat extends Pryl {

	private int slitageNivå;
	private double prisPåApparat;

	public Apparat(String apparatTyp, int apparatSlitage, double apparatPris) {
		super(apparatTyp);
		slitageNivå = apparatSlitage;
		prisPåApparat = apparatPris;
	}

	public double fåVärde() {
		if (slitageNivå == 10)
			return (prisPåApparat * 1.0);
		else
			return prisPåApparat * (slitageNivå * 0.1);
	}

	public String toString() {
		return getNamn() + "\t" + " värde: " + fåVärde();
	}

	public static void main(String[] args) {

	}

}
