
public abstract class Character extends GURPS {
	
	
	private String name;
	private int strength;
	private int dexterity;
	private int intelligence;
	private int health;
	private int hitPoints;
	private int will;
	private int perception;
	private int fatiguePoints;
	private int thrustDamageDie;
	private int thrustDamageMod;
	private int swingDamageDie;
	private int swingDamageMod;
	private int submachineGunLevel;
	private int hikingLevel;
	private int intimidationLevel;
	private int broadswordLevel;
	
	
	public void setName(String newName){
		this.name = newName;
	}
	
	public String getName(){
		String name = this.name;
		return name;
	}
	
	public void setStrength(int newStrength){
		this.strength = newStrength;
		this.thrustDamageDie = calcThrustDamageDie(newStrength);
		this.thrustDamageMod = calcThrustDamageMod(newStrength);
		this.swingDamageDie = calcSwingDamageDie(newStrength);
		this.swingDamageMod = calcSwingDamageMod(newStrength);
	}
	
	public int getStrength(){
		int strength = this.strength;
		return strength;
	}
	
	public void setDexterity(int newDexterity){
		this.dexterity = newDexterity;
	}
	
	public int getDexterity(){
		int dexterity = this.dexterity;
		return dexterity;
	}
	
	public void setIntelligence(int newIntelligence){
		this.intelligence = newIntelligence;
	}
	
	public int getIntelligence(){
		int intelligence = this.intelligence;
		return intelligence;
	}
	
	public void setHealth(int newHealth){
		this.health = newHealth;
	}
	
	public int getHealth(){
		int health = this.health;
		return health;
	}
	
	public void setHitPoints(int newHitPoints){
		this.hitPoints = newHitPoints;
	}
	
	public int getHitPoints(){
		int hitPoints = this.hitPoints;
		return hitPoints;
	}
	
	public void setWill(int newWill){
		this.will = newWill;
	}
	
	public int getWill(){
		int will = this.will;
		return will;
	}
	
	public void setPerception(int newPerception){
		this.perception = newPerception;
	}
	
	public int getPerception(){
		int perception = this.perception;
		return perception;
	}
	
	public void setFatiguePoints(int newFatiguePoints){
		this.fatiguePoints = newFatiguePoints;
	}
	
	public int getFatiguePoints(){
		int fatiguePoints = this.fatiguePoints;
		return fatiguePoints;
	}
	
	public int getThrustDamageDie(){
		int thrustDamageDie = this.thrustDamageDie;
		return thrustDamageDie;
	}
	
	public int getThrustDamageMod(){
		int thrustDamageMod = this.thrustDamageMod;
		return thrustDamageMod;
	}
	
	public int getSwingDamageDie(){
		int swingDamageDie = this.swingDamageDie;
		return swingDamageDie;
	}
	
	public int getSwingDamageMod(){
		int swingDamageMod = this.swingDamageMod;
		return swingDamageMod;
	}
	
	public void setSubmachineGunLevel(int newSubmachineGunLevel){
		this.submachineGunLevel = newSubmachineGunLevel;
	}
	
	public int getSubmachineGunSkill(){
		return this.dexterity + this.submachineGunLevel;
	}
	
	public void setHikingLevel(int newHikingLevel){
		this.hikingLevel = newHikingLevel;
	}
	
	public int getHikingSkill(){
		return this.health + this.hikingLevel;
	}
	
	public void setIntimidationLevel(int newIntimidationLevel){
		this.intimidationLevel = newIntimidationLevel;
	}
	
	public int getIntimidationSkill(){
		return this.will + this.intimidationLevel;
	}
	
	public void setBroadswordLevel(int newBroadswordLevel){
		this.broadswordLevel = newBroadswordLevel;
	}
	
	public int getBroadswordskill(){
		return this.dexterity + this.broadswordLevel;
	}
	
	public Character(){
		
	}
	
	public Character(int techLevel, String name, int strength, int dexterity, int intelligence, int health){
		super(techLevel);
		this.name = name;
		this.strength = strength;
		this.dexterity = dexterity;
		this.intelligence = intelligence;
		this.health = health;
		this.hitPoints = strength;
		this.will = intelligence;
		this.perception = intelligence;
		this.fatiguePoints = health;
		this.thrustDamageDie = calcThrustDamageDie(strength);
		this.thrustDamageMod = calcThrustDamageMod(strength);
		this.swingDamageDie = calcSwingDamageDie(strength);
		this.swingDamageMod = calcSwingDamageMod(strength);
	}
	
	public Character(String name){
		this.name = name;
	}
	
	public int calcThrustDamageDie(int strength){
		if(strength<=18){
			return 1;
		}else if(strength<=26){
			return 2;
		}else if(strength<=34){
			return 3;
		}else{
			return 4;
		}
	}
	
	public int calcThrustDamageMod(int strength){
		if(strength<=2){
			return -6;
		}else if(strength == 3||strength == 4){
			return -5;
		}else if(strength == 5||strength == 6){
			return -4;
		}else if(strength == 7||strength == 8){
			return -3;
		}else if(strength == 9||strength == 10){
			return -2;
		}else if(strength == 11||strength == 12||strength == 19||strength == 20||strength == 27||strength == 28||strength == 35||strength == 36){
			return -1;
		}else if(strength == 13||strength == 14||strength == 21||strength == 22||strength == 29||strength == 30){
			return 0;
		}else if(strength == 15||strength == 16||strength == 23||strength == 24||strength == 31||strength == 32){
			return 1;
		}else{
			return 2;
		}
	}
	
	public int calcSwingDamageDie(int strength){
		if(strength <= 12){
			return 1;
		}else if(strength <= 16){
			return 2;
		}else if(strength <= 20){
			return 3;
		}else if(strength <= 24){
			return 4;
		}else if(strength <= 30){
			return 5;
		}else{
			return 6;
		}
	}
	
	public int calcSwingDamageMod(int strength){
		if(strength <= 2){
			return -5;
		}else if(strength <= 4){
			return -4;
		}else if(strength <= 6){
			return -3;
		}else if(strength <= 8){
			return -2;
		}else if(strength == 9||strength == 13||strength == 17||strength == 21||strength == 25){
			return -1;
		}else if(strength == 10||strength == 14||strength == 18||strength == 22||strength == 26){
			return 0;
		}else if(strength == 11||strength == 15||strength == 19||strength == 23||strength == 27||strength == 28){
			return 1;
		}else{
			return 2;
		}
	}
	
	
	public abstract String getController();

}
