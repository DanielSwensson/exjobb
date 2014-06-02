public class Aktier extends Prylar {
	private double antal;
	private double pris;
	private double varde2;

	public double getVarde() {
		return varde2;
	}

	public void börskrasch() {
		pris = 0;
		varde2 = 0;
	}

	public Aktier(String so, String namn, double antal, double pris) {
		super(namn);
		this.antal = antal;
		this.pris = pris;

		varde2 = antal * pris;
	}
}