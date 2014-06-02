
public class Jewelry extends Item {
	
	private boolean gold;
	private int numberOfGems;
	
	public Jewelry(String name,boolean gold,int numberOfGems) {
		super(name);
		this.gold = gold;
		this.numberOfGems = numberOfGems;
		}


	
	public double calculateValue(){
		return (gold ? 2000 : 700) + numberOfGems * 500;
	}

}
