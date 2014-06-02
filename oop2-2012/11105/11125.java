
public class Weapon extends Item {

	private int damageMultiplier;
	
	public Weapon(String name, int damageMultiplier) {
		super(name);
		this.damageMultiplier = damageMultiplier;
	}
	
	public int getMultiplier() {
		return damageMultiplier;
	}
}
