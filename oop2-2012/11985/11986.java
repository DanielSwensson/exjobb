
public class Coin extends GoldTreasure {

	private int points = 10;
	private String type;
	
	public int getPoints(){
		return this.points;
	}
	
	Coin(){
		this.type = "Coin";
		this.points = 10;
	}
	
	public void addPoints(int p){
		this.points += p;
	}
	
	public String toString(){
		return type+" "+points;
	}
}
