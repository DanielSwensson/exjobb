public class Apparat extends Pryl {

	private int slitage;
	private int inkopspris;
	private String prylnamn;

	public Apparat(String prylnamn, int slitage, int inkopspris) {
		super(prylnamn);
		this.slitage = slitage;
		this.inkopspris = inkopspris;
		this.prylnamn = prylnamn;
	}

	public int getVärde() {
		return (int) (inkopspris * (slitage / 10.0));

	}

	public String toString() {

		return (prylnamn + " har värdet " + getVärde());
	}
}
