class Forward extends Spelare {

	private int skott;

	public Forward(String na, String la, int al, int må, int as, int sk) {
		super(na, la, al, må, as);
		skott = sk;
	}

	public int getSkott() {
		return skott;
	}

	public double getSkottprocent() {
		return (double) mål / skott;
	}

	public int beräknaMarknadsvärde() {
		return (int) (getSkottprocent() * 100) * 50000 + mål * 2000;
	}

	public String toString() {
		return super.toString() + "\t" + skott + "\t-\t-\t-";
	}

	public int ändraSkott(int nyaSkott) {
		return skott += nyaSkott;
	}

	private static final long serialVersionUID = 1L;
}
