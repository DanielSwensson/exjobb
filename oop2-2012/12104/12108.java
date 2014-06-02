abstract class Vardesak {
	private String namn;

	public abstract int getV�rde();

	public Vardesak(String namn) {
		setNamn(namn);
	}

	public String getNamn() {
		return namn;
	}

	public void setNamn(String namn) {
		if (namn == null || namn.equals(""))
			throw new IllegalArgumentException();

		this.namn = namn;
	}

	public String toString() {
		return getNamn() + "\t" + getV�rde() + " kr";
	}
}
