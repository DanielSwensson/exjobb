
public abstract class Character {

	private String name;
	private int level;
	
	public Character(String name, int level) {
		this.name = name;
		this.level = level;
	}
	
	public String getName(){
		return name;
	}
	public int getLevel(){
		return level;
	}
	abstract int getMaxHP();
	abstract int getMaxMana();

}
