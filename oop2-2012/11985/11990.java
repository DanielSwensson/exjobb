
public class HealthPotion extends Treasure{
	
	private int health = 100;
	private String type = "Health Potion";
	
	public int getPotion(){
		return this.health;
	}
	
	public String toString(){
		return type+" "+health;
	}
}
