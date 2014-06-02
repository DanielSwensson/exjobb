
public class Enemy {

	protected String name;
	protected int power;
	protected int health;
	
	Enemy(){
		
	}
	
	public int getHit(int h){
		return this.health -= h;
	}
	
	public int getHealth(){
		return health;
	}
	
	public String encounter(){
		return null;
	}
	
	public int hitHero(){
		return this.power * 10;
	}
	
}
