public class Smycke extends Pryl {
	private int antal�delstenar;
	private int typ;

	public Smycke(String namn, int typ, int antal�delstenar) {
		super(namn);
		this.antal�delstenar = antal�delstenar;
		this.typ = typ;

	}

	@Override
	public int h�mtaV�rde() {
		if (typ == 1)
			return (2000 + antal�delstenar * 500);
		else
			return (700 + antal�delstenar * 500);
	}
}
