
public class Mob extends Monster{

	public Mob(String name, int level){
		super(name, level);
	}
	public int getMaxHP() {
		return getLevel() * 1000;
	}
	public int getMaxMana() {
		return getLevel() * 750;
	}
	public String toString(){
		try{
			return "\n" + getName() + " Level: " + getLevel() + "\n   HP: " + getMaxHP() + "\n   Mana: " + getMaxMana();
		}
		catch(NullPointerException e){
			return "No mobs found.";
		}
	}
}
