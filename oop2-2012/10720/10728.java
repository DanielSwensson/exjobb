package Poppimon;

public class Player {

	protected String name;
	protected int gold;
	protected int addedGold;

	public int getGold() {
		return gold;
	}

	public void addGold(int addedGold) {
		gold += addedGold;
	}
}