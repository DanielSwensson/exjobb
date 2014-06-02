package HABLO2;

public abstract class Monster extends Unit {
	
	private int expOnKill;
	
	
	
	public Monster(int dmg, int def, int currentHp, int agil, String type, int gold, int lvl, int maxHp, int expOnKill){
		super(dmg, def, currentHp, agil, type, gold, lvl, maxHp);
		this.expOnKill=expOnKill;
	}
	
	public int getExpOnKill(){
		return this.expOnKill;
	}
	
	public void setExpOnKill(int newExpOnKill){
		this.expOnKill = newExpOnKill;
	}
	
	public void dead(){
		System.out.println("You slayed the " + this.getType()
				+ " you gained " + this.getGold() + " gold and "
				+ this.expOnKill + " exp.");
	}
	
	public int loot(){
		return this.getGold();
	}
	
}
