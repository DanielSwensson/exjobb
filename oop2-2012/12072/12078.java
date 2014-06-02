class Smycke extends Pryl {
	private boolean guld;
	private int antal�delstenar;
	int v�rde;

	Smycke(String namn, boolean guld, int antal�delstenar) {
		super(namn);
		this.guld = guld;
		this.antal�delstenar = antal�delstenar;
	}

	public boolean getguld() {
		return guld;
	}

	public int getAntal�delstenar() {
		return antal�delstenar;
	}

	public double getV�rde() {

		if (guld)
			v�rde = 2000;
		else
			v�rde = 700;

		v�rde += antal�delstenar * 500;

		return v�rde;

	}

}
