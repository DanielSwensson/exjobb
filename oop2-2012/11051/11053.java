class Apparat extends Pryl {
	private int condition;
	private int nyPris;

	Apparat(String nyTyp, int i, int n) {
		super(nyTyp);
		nyPris = i;
		condition = n;

	}

	public int getValue() {

		return (nyPris / 10) * condition;
	}

}
