
public class Player extends Character {

	private Race race;
	private PlayerClass pc;
	private Spec spec;
	
	public Player(String name, int level, Race race, PlayerClass pc, Spec spec) {
		super(name, level);
		this.race = race;
		this.pc = pc;
		this.spec = spec;
	}
	public PlayerClass getPlayerClass(){
		return pc;
	}
	public Race getRace(){
		return race;
	}
	public String toString(){
		try{
			return "\n" + getName() + ", Level: " + getLevel() + "\n   Faction: " + getRace().getFaction() + "\n   " + race.getName() + ", " + pc.getName() + " Spec: " + spec.getName() + "\n   HP: " + getMaxHP() + "\n   Mana: " + getMaxMana() + "\n   Maximum damage output for current level: " + calculateDPS();
		}
		catch(NullPointerException e){
			return "No characters found.";
		}
	}
	public int getMaxHP() {
		int maxHP;
		if((pc.getName().equalsIgnoreCase("Mage")) || (spec.getName().equalsIgnoreCase("Balance")))//fixat till
			maxHP= getLevel()*1250;
		else
			maxHP=getLevel()*1500;
		return maxHP;
	}
	public int getMaxMana() {
		int maxPower;
		if((pc.getName().equalsIgnoreCase("Mage")) || (spec.getName().equalsIgnoreCase("Balance")))//fixat till
			maxPower= getLevel()*1250;
		else
			maxPower=getLevel()*1000;
		return maxPower;
	}
	public Spec getSpec(){
		return spec;
	}
	public int calculateDPS(){
		double i = Math.pow(((getLevel()+10)/100.0), 2);
		return ((int) (getSpec().getMaxSpecDps() * i));
	}
	

}
