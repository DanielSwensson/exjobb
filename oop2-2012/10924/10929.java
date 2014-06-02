public abstract class Pryl {

	private String namn;

	public Pryl(String namn) {
		this.namn = namn;
	}

	public abstract int hämtaVärde();

	public String hämtaNamn() {
		return namn;
	}

	@Override
	public String toString() {
		return namn + " " + hämtaVärde() + "kr\n";
	}

}
