public class Smycke extends Pryl {

	private String material;
	private int stenar;
	private String prylnamn;

	public Smycke(String prylnamn, String material, int stenar) {
		super(prylnamn);
		this.material = material;
		this.stenar = stenar;
		this.prylnamn = prylnamn;

	}

	public int getVärde() {
		if (material.equalsIgnoreCase("guld")) {
			return (2000 + (stenar * 500));

		} else if (material.equalsIgnoreCase("silver")) {
			return (700 + (stenar * 500));
		}
		return 0;

	}

	public String toString() {

		return (prylnamn + " har värdet " + getVärde());
	}

}
