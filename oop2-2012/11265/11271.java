public class Smycke extends pryl {
	private int stones;
	private boolean gold;

	public Smycke(String name, boolean g, int s) {
		super(name);
		gold = g;
		stones = s;
	}

	public double getValue() {
		if (gold == true) {
			return (2000 + (stones * 500));
		} else {
			return (700 + (stones * 500));
		}
	}

	public String toString() {
		return super.toString() + getValue();
	}
}
