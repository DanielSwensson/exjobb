package HABLO2;

public class Hydra extends Monster {

	public Hydra(int lvl, int loot){
		super(lvl*3+7, lvl+2, lvl*10+30, lvl, "Hydra", (loot+1)*15, lvl, lvl*10+30, lvl*10);
	}
}
