abstract public class Pryl {

	private String namn;

	abstract public int getV�rde();//poly

	public Pryl(String namn) {
		this.namn = namn;
	}

	public String getNamn() {
		return namn;
	}

	public String toString() {
		return getNamn() + " " + getV�rde();
	}
}