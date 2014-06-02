class Forward extends Spelare {

	private int skott;

	public Forward(String na, String la, int al, int m�, int as, int sk) {
		super(na, la, al, m�, as);
		skott = sk;
	}

	public int getSkott() {
		return skott;
	}

	public double getSkottprocent() {
		return (double) m�l / skott;
	}

	public int ber�knaMarknadsv�rde() {
		return (int) (getSkottprocent() * 100) * 50000 + m�l * 2000;
	}

	public String toString() {
		return super.toString() + "\t" + skott + "\t-\t-\t-";
	}

	public int �ndraSkott(int nyaSkott) {
		return skott += nyaSkott;
	}

	private static final long serialVersionUID = 1L;
}
