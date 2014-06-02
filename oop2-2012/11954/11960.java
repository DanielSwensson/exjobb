class Smycken extends Pryl {
	private int antalÄdelstenar;
	private String typ = new String();

	public Smycken(String namn, int antal, String typ) {
		super(namn);
		this.antalÄdelstenar = antal;
		this.typ = typ;
	}

	public int getVärde() {
		if (typ.equalsIgnoreCase("Guld"))
			return (2000 + (antalÄdelstenar * 500));
		else if (typ.equalsIgnoreCase("silver"))
			return (700 + (antalÄdelstenar * 500));

		return 0;
	}
}