public abstract class Pryl {

	private String prylnamn;

	public Pryl(String prylnamn) {
		this.prylnamn = prylnamn;

	}

	public String getName() {
		return prylnamn;
	}

	public abstract int getVärde();

	public String toString() {

		return (prylnamn + " \t " + getVärde());
	}
}
