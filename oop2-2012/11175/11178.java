
public class EliteMob extends Monster {

	public EliteMob(String name, int level){
		super(name, level);
	}
	public int getMaxHP() {
		return getLevel() * 1500;
	}
	public int getMaxMana() {
		return getLevel() * 1000;
	}
	public String toString(){
		try{
			return "\n" + getName() + " Level: " + getLevel() + " Elite" + "\n   HP: " + getMaxHP() + "\n   Mana: " + getMaxMana();
		}
		catch(NullPointerException e){
			return "No Elite-mobs found.";
		}
	}
	
}