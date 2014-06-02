class Smycke extends Pryl {
	private boolean guld;
	private int antalÄdelstenar;
	int värde;

	Smycke(String namn, boolean guld, int antalÄdelstenar) {
		super(namn);
		this.guld = guld;
		this.antalÄdelstenar = antalÄdelstenar;
	}

	public boolean getguld() {
		return guld;
	}

	public int getAntalÄdelstenar() {
		return antalÄdelstenar;
	}

	public double getVärde() {

		if (guld)
			värde = 2000;
		else
			värde = 700;

		värde += antalÄdelstenar * 500;

		return värde;

	}

}
