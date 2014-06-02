public class Apparat extends Pryl {
	private int inköpsPris;
	private int slitageNummer;

	public Apparat(String namn, int slitageNummer, int inköpsPris) {
		super(namn);
		this.inköpsPris = inköpsPris;
		this.slitageNummer = slitageNummer;
	}

	@Override
	public int hämtaVärde() {
		return (int) (inköpsPris * (slitageNummer / 10.0));
	}

}
