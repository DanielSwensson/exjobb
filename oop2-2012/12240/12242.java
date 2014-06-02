public class Apparater extends Prylar {
	private double inkopspris;
	private double slitage;
	private double varde3;

	public double getVarde() {
		return varde3;
	}

	public Apparater(String so, String namn, double inkopspris, double slitage) {
		super(namn);
		this.inkopspris = inkopspris;
		this.slitage = slitage;

		varde3 = (slitage / 10) * inkopspris;
	}
}