abstract class Pryl {
	private String namn;

	public Pryl(String namn, int pris) {
		this.namn = namn;
	}
	public Pryl(String Pryl) {
		namn = Pryl;
	}
	abstract public int getValue();

	public String getnamn() {
		return namn;
	}
	public String toString() {
		return namn + " " + getValue();
	}
}
