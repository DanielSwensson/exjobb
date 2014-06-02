abstract public class Pryl {

	private String namn;

	abstract public int getVärde();//poly

	public Pryl(String namn) {
		this.namn = namn;
	}

	public String getNamn() {
		return namn;
	}

	public String toString() {
		return getNamn() + " " + getVärde();
	}
}