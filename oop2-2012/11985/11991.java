
public class Hero {

	private String name;
	private int health;
	private int maxHealth;
	private int power;
	private int points;
	
	Hero(String n){
		this.name = n;
		this.health = 100;
		this.maxHealth = 100;
		this.power = 1;
		this.points = 0;	
	}
	
	private int x = 0;
	Treasure treasureArray[] = new Treasure[50];
	
	public void collectedTreasures(Treasure t){
	treasureArray[x] = t;
	x++;
	}
	
	public void printTreasures(){
		int potionCount = 0;
		int pileCount = 0;
		int coinCount = 0;
		for (int y=0 ; y<x ; y++){
			if (treasureArray[y] instanceof Coin){
				++coinCount;
			}
			else if (treasureArray[y] instanceof PileOfCoins){
				++pileCount;			
			}
			else{
				++potionCount;
			}
		}
		System.out.println("Coins found: "+coinCount+"\nPiles of coins found: "+pileCount+"\nPotions found: "+potionCount);
	}
	
	public int hitEnemy(){
		return power * 15;
	}
	
	public int getHit(int h){
		return this.health -= h;
	}
	
	public String getName(){
		return name;
	}
	
	public String getStatus(){
		return name + ": " + health + " healthpoints, " + power + " power, " + points + " points. Maximum health: " + maxHealth;
	}
	
	public void setPoints(int p){
		this.points += p;
	}
	
	public void setPointsToZero(){
		this.points = 0;
	}
	
	public int getPoints(){
		return points;
	}
	
	public void setHealth(int h){
		this.health += h;
	}
	
	public void setHealthOverflow(){
		this.health = this.maxHealth;
	}
	
	public int getHealth(){
		return health;
	}
	
	public int getMaxhealth(){
		return maxHealth;
	}
	
	public void setMaxhealth(int m){
		this.maxHealth += m;
	}
	
	public void setPower(int p){
		this.power += p;
	}
}
