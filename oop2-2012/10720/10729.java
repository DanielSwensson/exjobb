package Poppimon;

public class Poppimon extends Unit {

	Predimon target;

	public Poppimon(String input) {
		this.name = input;
		this.vitality = 8;
		this.health = vitality * 2;
		this.strength = 2;
		this.armour = 0;
		this.ownedWeapon = new Fist();

	}

	public String getName() {
		return name;
	}

	public void setName(String input2) {
		this.name = input2;
	}

	public int getDamage() {
		
		return strength * 2 + ((strength * ownedWeapon.damageBonus()));
	}

	public void setTarget(Predimon theTarget) {
		target = theTarget;
	}

	public void attack() {
		target.setHealth(getDamage());
	}

	public String toString() {
		return name;
	}

	public void setArmour(int armourValue) {
		this.armour = armourValue;
	}
}
