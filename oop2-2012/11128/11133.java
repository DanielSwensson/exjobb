
public class NPC extends Character {
	
	private String gameMaster;
	
	public void setGameMaster(String newGameMaster){
		this.gameMaster = newGameMaster;
	}
	
	public String getGameMaster(){
		String gameMaster = this.gameMaster;
		return gameMaster;
	}
	
	public NPC(){
	}
	
	public NPC(int techLevel, String name, int strength, int dexterity, int intelligence, int health, String gameMaster){
		super(techLevel, name, strength, dexterity, intelligence, health);
		this.gameMaster = gameMaster;
	}
	
	public NPC(String name, String gameMaster){
		super(name);
		this.gameMaster = gameMaster;
	}
	
	public String getController(){
		return this.gameMaster;
	}
	
	public String toString(){
		return "The PC has the following stats:" + "\n" +
				"Name: " + getName() + "\n"+
				"Owner/Controller: " + this.gameMaster + "\n" +
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
