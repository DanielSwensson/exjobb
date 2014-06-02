package Poppimon;

public class Unit {
	protected int vitality;
	protected int strength;
	protected String name;
	protected int health;
	protected int damage;
	protected int gold;
	protected int armour;
	protected static int difficulty;
	protected Weapon ownedWeapon;
	protected int damageBonus;
	private String weaponType;

	public static void setDifficulty(int difficultyInput) {
		difficulty = difficultyInput;
	}

	public static int getDifficulty() {
		return difficulty;
	}

	public void addDamageBonus(int dmg) {
		damageBonus += dmg;
	}

	public String getOwnedWeaponType() {

		if (ownedWeapon instanceof Fist) {
			weaponType = "fists";
		}
		if (ownedWeapon instanceof Sword) {
			weaponType = "sword";
		}
		if (ownedWeapon instanceof Mace) {
			weaponType = "mace";
		}
		if (ownedWeapon instanceof Axe) {
			weaponType = "axe";
		}
		if (ownedWeapon instanceof Pike) {
			weaponType = "pike";
		}
		if (ownedWeapon instanceof Halberd) {
			weaponType = "halberd";
		}
		if (ownedWeapon instanceof Godslayer) {
			weaponType = "godsword";
		}

		return weaponType;
	}

	public int getHealth() {
		return health;
	}

	public int getStrength() {
		return strength;
	}

	public void setHealth(int damageAmount) {
		if (damageAmount - armour <= 0) {
			health -= 1;

		} else {
			health -= damageAmount - armour;
		}
	}

	public void setOwnedWeapon(Weapon weapon) {
		ownedWeapon = weapon;
	}

	public Weapon getOwnedWeapon() {

		return ownedWeapon;
	}

	public void addHealth(int amount) {

		health = health + amount;

	}

	public int getGold() {
		return gold;
	}

	public void addStrength(int strengthPotion) {
		strength += strengthPotion;
	}

	public int getArmour() {
		return armour;
	}

	public String toString() {
		return weaponType;
	}

}
