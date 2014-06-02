public class Apparat extends Pryl {

	private int inkšpspris;
	private int slitage;

	public Apparat(String n, int i, int s) {
		super(n);
		inkšpspris = i;
		slitage = s;
	}

	public int getInkšpspris() {
		return inkšpspris;
	}

	public int getSlitage() {
		return slitage;
	}

	public int getVŠrde() {
		return (int) ((slitage / 10.0) * inkšpspris);
	}
}
