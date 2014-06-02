public class Aktiepost extends Pryl {
	private int pris;
	private int antal;

	public Aktiepost(String namn, int pris, int antal) {
		super(namn);

		this.pris = pris;
		this.antal = antal;

	}

	public void setCrash() {
		this.pris = 0;

	}

	public double getVärde() {
		return pris * antal;

	}

	public String toString() {
		return namn + " värde " + getVärde();

	}

}
