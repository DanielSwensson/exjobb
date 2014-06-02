package HABLO2;

import java.util.Random;

public class Player extends Unit {

	private String name;
	private Item defItem;
	private Item dmgItem;
	private int currentExp;

	Random rnd = new Random();

	public Player(String name) {
		super(9, 1, 100, 3, "Human", 15, 0, 100);
		this.name = name;
		this.defItem = new Item();
		this.dmgItem = new Item();
		this.currentExp = 0;
	}

	public boolean firstBlood(Unit target) {
		boolean fb = true;

		if (this.dmgItem.getStrength() == 20){
			fb = false;
		}
		else{
			fb = super.firstBlood(target);
		}

		return fb;
	}

	public String getName() {
		return this.name;
	}

	public int getCurrentExp() {
		return this.currentExp;
	}

	public void setCurrentExp(int currentExp) {
		this.currentExp = currentExp;
	}

	public boolean flee(Unit target) {
		boolean flee = false;

		int nr = rnd.nextInt(10) + (this.getAgil() - target.getAgil());

		if (nr > 4) {
			flee = true;
		}

		return flee;
	}

	public void lvlUp() {
		if (this.currentExp >= this.getLvl() * 25 + 10) {
			this.currentExp = 0;
			this.setLvl(this.getLvl() + 1);

			this.setDmg(this.getLvl() * 2 + 9 + this.dmgItem.getStrength());
			this.setAgil(this.getLvl() + 3);
			this.setDef(this.getLvl() + 1 + this.defItem.getStrength());
			this.setMaxHp(this.getLvl() * 10 + 100);
			System.out.println("Conplatuilations! You gained an lvl up and you're now lvl "
							+ this.getLvl());
		}
	}

	public void changeCurrentExp(int newExp) {
		this.currentExp += newExp;
	}

	public void changeGold(int newGold) {
		this.setGold(this.getGold() + newGold);
	}

	public void changeDefItem(Item newItemDef) {
		this.setDef(this.getDef() + newItemDef.getStrength() - this.defItem.getStrength());
		this.defItem = newItemDef;
	}

	public void changeDmgItem(Item newItemDmg) {
		this.setDmg(this.getDmg() + newItemDmg.getStrength() - this.dmgItem.getStrength());
		this.dmgItem = newItemDmg;
	}
}
