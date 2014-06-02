
abstract class Pryl {
	private String typ;

	public Pryl (String typ) {
		this.typ=typ;	
	}

	public String getType1() {
		return typ;
	}

abstract public double value();
}