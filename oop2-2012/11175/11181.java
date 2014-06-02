
public abstract class Monster extends Character {

	public Monster(String name, int level) {
		super(name, level);
	}
	abstract int getMaxHP();
	abstract int getMaxMana();

}
