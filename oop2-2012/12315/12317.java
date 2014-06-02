public class Apparat extends Pryl {

	private int inkopsPris;
	private int apparatSlitage;
	private int apparatVarde;

	public Apparat(String prylSort, String apparatNamn, int inkopsPris,
			int apparatSlitage) {
		super(prylSort, apparatNamn);
		this.inkopsPris = inkopsPris;
		this.apparatSlitage = apparatSlitage;
	}

	public int getVarde() {
		apparatVarde = inkopsPris / 10 * (apparatSlitage);
		return apparatVarde;
	}

}
