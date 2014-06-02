abstract public class Pryl {
	private String typ;

	Pryl(String nyTyp) {
		typ = nyTyp;

	}

	abstract public int getValue();

	public String getTyp() {
		return typ;
	}
}
