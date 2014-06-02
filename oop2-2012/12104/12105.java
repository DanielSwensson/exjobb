class Apparat extends Vardesak {
	private int inköpspris;
	private int slitage;

	public Apparat(String namn, int inköpspris, int slitage) {
		super(namn);

		setInköpspris(inköpspris);
		setSlitage(slitage);
	}

	public int getVärde() {
		return getSlitage() * getInköpspris() / 10;
	}

	public int getInköpspris() {
		return inköpspris;
	}

	public int getSlitage() {
		return slitage;
	}

	public void setInköpspris(int inköpspris) {
		if (inköpspris < 0)
			throw new IllegalArgumentException();

		this.inköpspris = inköpspris;
	}

	public void setSlitage(int slitage) {
		if (slitage < 1 || slitage > 10)
			throw new IllegalArgumentException();

		this.slitage = slitage;
	}
}
