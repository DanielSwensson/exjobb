public class Jewel extends Belongings {

	private int gems;
	private boolean gold;
	
	Jewel(int gems, boolean gold, String name) {
		super(name, 0);
		this.gems = gems;
		this.gold = gold;
		setValue(calcValue());
	}

	public String toString() {
		return getName()+ ", Antal stenar: " + gems +  ", Värde: " + getValue();
	}
	
	public int calcValue() {
		int value = 0;

		if (gold) {
			value = 2000 + 500 * gems;
			return value;
		}
		else {
			value = 700 + 500 * gems;
			return value;
		}
	}
}
