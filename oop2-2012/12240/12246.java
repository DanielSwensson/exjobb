public class Smycken extends Prylar {
	private double adelstenar;
	private String metall;
	private double guld;
	private double varde1;

	public double getVarde() {
		return varde1;
	}

	public Smycken(String so, String namn, double adelstenar, String metall) {
		super(namn);
		this.adelstenar = adelstenar;
		this.metall = metall;

		if (metall.equalsIgnoreCase("Ja")) {
			guld = 2000;
		} else {
			guld = 700;
		}
		varde1 = guld + (adelstenar * 500);
	}
}