public class Apparat extends Pryl {
	private int ink�psPris;
	private int slitageNummer;

	public Apparat(String namn, int slitageNummer, int ink�psPris) {
		super(namn);
		this.ink�psPris = ink�psPris;
		this.slitageNummer = slitageNummer;
	}

	@Override
	public int h�mtaV�rde() {
		return (int) (ink�psPris * (slitageNummer / 10.0));
	}

}
