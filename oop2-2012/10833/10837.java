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

	abstract public int getVŠrde();
} // detta gšrs fšr att kunna komma Œt metoden vŠrde frŒn en prylreferens
// (eftersom arraylisten Šr en prylarray)
