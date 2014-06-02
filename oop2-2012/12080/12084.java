public class Pryl {

	private String namn;

	protected Pryl(String namn) {
		this.namn = namn;
	}

	public String hämtaNamn() {
		return namn;
	}

	public int hämtaVärde() {
		return 0;
	}

	public String toString() {
		return namn;
	}
}
