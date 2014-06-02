
public class GoldTreasure extends Treasure {

	public int getCoin(){
		Coin coin1 = new Coin();
		return coin1.getPoints();
	}
	
	public int getPile(){
		PileOfCoins pile1 = new PileOfCoins();
		return pile1.getPoints();
	}
}
