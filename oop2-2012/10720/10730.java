package Poppimon;

public class Predimon extends Unit {

	Poppimon target;

	public Predimon(int level) {
		if (level > 10) {
			this.vitality = level
					* (4 + (level / (10 / (1 + (difficulty * 2)))));
			this.strength = (level / 10) * ((level / 5) + level);
			this.armour = level * (1 + difficulty);
		} else {
			this.vitality = level * 4;
			this.strength = 1 + (level);
			this.armour = level;
		}

		this.health = vitality * 2;
		this.damage = strength * 2;
		this.gold = (strength * 2) + (level * (10 - difficulty));
		this.damageBonus = difficulty - 3 + (level * 2);
	}

	public int getDamage() {
		return damage + damageBonus;
	}

	public int getGold() {
		return gold;

	}

	public void setTarget(Poppimon theTarget) {
		target = theTarget;
	}

	public void attack() {
		target.setHealth(getDamage());
	}
}