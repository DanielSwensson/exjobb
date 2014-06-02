
public class Jewelry extends Item {

	private boolean gold;
	private int gems;
	
	Jewelry(String name, boolean gold, int gems) {
		super(name);
		this.gold = gold;
		this.gems = gems;
	}
	
	public double getValue() {
		double value;
		if (gold) value = 2000;
		else value = 700;
		value += gems*500;
		return value;
	}
}
