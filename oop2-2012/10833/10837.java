abstract class Pryl {

	private String namn;

	public Pryl(String n) {
		namn = n;

	}

	public void setNamn() {

	}

	public String getNamn() {
		return namn;
	}

	abstract public int getV�rde();
} // detta g�rs f�r att kunna komma �t metoden v�rde fr�n en prylreferens
// (eftersom arraylisten �r en prylarray)
