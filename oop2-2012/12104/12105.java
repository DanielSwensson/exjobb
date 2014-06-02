class Apparat extends Vardesak {
	private int ink�pspris;
	private int slitage;

	public Apparat(String namn, int ink�pspris, int slitage) {
		super(namn);

		setInk�pspris(ink�pspris);
		setSlitage(slitage);
	}

	public int getV�rde() {
		return getSlitage() * getInk�pspris() / 10;
	}

	public int getInk�pspris() {
		return ink�pspris;
	}

	public int getSlitage() {
		return slitage;
	}

	public void setInk�pspris(int ink�pspris) {
		if (ink�pspris < 0)
			throw new IllegalArgumentException();

		this.ink�pspris = ink�pspris;
	}

	public void setSlitage(int slitage) {
		if (slitage < 1 || slitage > 10)
			throw new IllegalArgumentException();

		this.slitage = slitage;
	}
}
