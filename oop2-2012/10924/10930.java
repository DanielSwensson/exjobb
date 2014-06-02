public class Smycke extends Pryl {
	private int antalÄdelstenar;
	private int typ;

	public Smycke(String namn, int typ, int antalÄdelstenar) {
		super(namn);
		this.antalÄdelstenar = antalÄdelstenar;
		this.typ = typ;

	}

	@Override
	public int hämtaVärde() {
		if (typ == 1)
			return (2000 + antalÄdelstenar * 500);
		else
			return (700 + antalÄdelstenar * 500);
	}
}
