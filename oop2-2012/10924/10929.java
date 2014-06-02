public abstract class Pryl {

	private String namn;

	public Pryl(String namn) {
		this.namn = namn;
	}

	public abstract int h�mtaV�rde();

	public String h�mtaNamn() {
		return namn;
	}

	@Override
	public String toString() {
		return namn + " " + h�mtaV�rde() + "kr\n";
	}

}
