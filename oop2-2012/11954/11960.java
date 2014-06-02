class Smycken extends Pryl {
	private int antal�delstenar;
	private String typ = new String();

	public Smycken(String namn, int antal, String typ) {
		super(namn);
		this.antal�delstenar = antal;
		this.typ = typ;
	}

	public int getV�rde() {
		if (typ.equalsIgnoreCase("Guld"))
			return (2000 + (antal�delstenar * 500));
		else if (typ.equalsIgnoreCase("silver"))
			return (700 + (antal�delstenar * 500));

		return 0;
	}
}