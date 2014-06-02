class Aktie extends Vardesak {
	private int antal;
	private int pris;

	public Aktie(String namn, int antal, int pris) {
		super(namn);

		setAntal(antal);
		setPris(pris);
	}

	public int getVärde() {
		return getAntal() * getPris();
	}

	public int getAntal() {
		return antal;
	}

	public int getPris() {
		return pris;
	}

	public void setAntal(int antal) {
		if (antal < 0)
			throw new IllegalArgumentException();

		this.antal = antal;
	}

	public void setPris(int pris) {
		if (pris < 0)
			throw new IllegalArgumentException();

		this.pris = pris;
	}
}
