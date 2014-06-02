public class Smycke extends Pryl {

	private String metall;
	private int guld, silver, sten, antal;

	public Smycke(String namn, String metall, int antal) {
		super(namn);
		this.metall = metall;
		this.antal = antal;
	}

	public int getVärde() {
		guld = 2000;
		silver = 700;
		sten = 500;
		if (metall.equalsIgnoreCase("ja")) {
			return sten * antal + guld;
		} else {
			return sten * antal + silver;
		}
	}
}