public class Jewelery extends Thing {
	private int numberOfStones;
	private Boolean gold;

	public Jewelery(String owner, int sort, String thingName, double value,
			Boolean gold, int numberOfStones) {
		super(owner, sort, thingName, value);
		this.gold = gold;
		this.numberOfStones = numberOfStones;
	}

	public Boolean getColor() {
		return gold;
	}
	
	public int getNumberOfStones(){
		return numberOfStones;
	}

	public static int getJeweleryValue(Boolean gold, int numberOfStones) {
		if (gold == true) {
			return (2000 + (numberOfStones * 500));

		} else {
			return (700 + (numberOfStones * 500));
		}

	}
}

