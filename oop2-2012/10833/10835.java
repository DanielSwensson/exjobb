public class Apparat extends Pryl {

	private int ink�pspris;
	private int slitage;

	public Apparat(String n, int i, int s) {
		super(n);
		ink�pspris = i;
		slitage = s;
	}

	public int getInk�pspris() {
		return ink�pspris;
	}

	public int getSlitage() {
		return slitage;
	}

	public int getV�rde() {
		return (int) ((slitage / 10.0) * ink�pspris);
	}
}
