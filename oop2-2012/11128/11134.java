
public class PC extends Character {
	
	
	private String player;
	
	public void setPlayer(String newPlayer){
		this.player = newPlayer;
	}
	
	public String getPlayer(){
		String player = this.player;
		return player;
	}
	
	public PC(){		
	}
	
	public PC(int techLevel, String name, int strength, int dexterity, int intelligence, int health, String player){
		super(techLevel, name, strength, dexterity, intelligence, health);
		this.player = player;
	}
	
	public PC(String name, String player){
		super(name);
		this.player = player;
	}
	
	public String getController(){
		return this.player;
	}
	
	public String toString(){
		return "The PC has the following stats:" + "\n" +
				"Name: " + getName() + "\n"+
				"Owner/Controller: " + this.player + "\n" +
				"TechLevel: " + getTechLevel() + "\n" +
				"Strength: " + getStrength() + "\n" +
				"Dexterity: " + getDexterity() + "\n" +
				"Intelligence: " + getIntelligence() + "\n" +
				"Health: " + getHealth() + "\n" +
				"HitPoints: " + getHitPoints() + "\n" +
				"Will: " + getWill() + "\n" +
				"FatiguePoints: " + getFatiguePoints();
	}

}
