abstract public class Pryl {
	private String namn;

	public Pryl(String namn) {
		this.namn = namn;
	}

	abstract double getVärde();

	public String PrylNamn() {
		return namn;
	}

	public String toString() {
		return namn + "\t" + getVärde() + "\n";

	}
}
