
public class Apparat extends Pryl {

	private int slitageNiv�;
	private double prisP�Apparat;

	public Apparat(String apparatTyp, int apparatSlitage, double apparatPris) {
		super(apparatTyp);
		slitageNiv� = apparatSlitage;
		prisP�Apparat = apparatPris;
	}

	public double f�V�rde() {
		if (slitageNiv� == 10)
			return (prisP�Apparat * 1.0);
		else
			return prisP�Apparat * (slitageNiv� * 0.1);
	}

	public String toString() {
		return getNamn() + "\t" + " v�rde: " + f�V�rde();
	}

	public static void main(String[] args) {

	}

}
