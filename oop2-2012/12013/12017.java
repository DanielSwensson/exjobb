public abstract class Pryl {

	private String prylnamn;

	public Pryl(String prylnamn) {
		this.prylnamn = prylnamn;

	}

	public String getName() {
		return prylnamn;
	}

	public abstract int getV�rde();

	public String toString() {

		return (prylnamn + " \t " + getV�rde());
	}
}
