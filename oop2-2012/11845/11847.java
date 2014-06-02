public class Jewlery extends RegisteryObject {

	private String namn;
	private boolean gold;
	private int gem;

	public Jewlery(String namn, boolean gold, int gem) {
		this.setNamn(namn);
		this.gold = gold;
		this.gem = gem;
	}

	@Override
	public double getValue() {
		int x;
		if (gold) {
			x = 2000;
		} else {
			x = 700;
		}
		return x + (gem * 500);
	}

	public String getName() {
		return namn;
	}

	public void setNamn(String namn) {
		this.namn = namn;
	}

}
