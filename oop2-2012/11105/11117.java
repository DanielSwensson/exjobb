
public abstract class Living {
	
	private int healthPoints;
	private String name;
	private boolean dead = false;
	
	public Living(int healthPoints){
		this.healthPoints = healthPoints;
	}
	
	public void takeDamage(int damageTaken){

		healthPoints -= damageTaken;
		if(healthPoints <= 0)
			die();
	}
	
	public boolean isDead() {
		return dead;
	}
	
	public void die(){
		dead = true;
	}
	
	public int getHealth(){
		return healthPoints;
	}
	
	public String getName(){
		return name;
	}
	
	public void setHealth(int health){
		healthPoints = health;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void eat(Food food){
		healthPoints+=food.getFoodValue();

	}

}
