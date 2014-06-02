
public class PileOfCoins extends GoldTreasure {

	private int points = 100;
	private String type = "Pile of Coins";
	
	public int getPoints(){
		return this.points;
	}
	
	public String toString(){
		return type+" "+points;
	}
}
