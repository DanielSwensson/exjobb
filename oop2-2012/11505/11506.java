package HABLO2;

public class BlackDragon extends Monster {

	public BlackDragon(int lvl, int loot) {
		super((lvl+1)*15, (lvl+2) * 5, (lvl+1)*40, lvl+1, "Black Dragon", (loot+1)*50, lvl, (lvl+1) * 40, (lvl+1) *100);
	}
	
	public void dead(){
		super.dead();
		System.out.println("\n\nYou crushed the dragons brains with your mighty battle-axe of doom, you and the mysteries man live happy ever after thanks to the magic item\n\nConglaturations, you have completed a great game!");
		System.exit(0);
	}
}
