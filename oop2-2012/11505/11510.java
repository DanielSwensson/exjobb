package HABLO2;

public class Leprecon extends Monster {


		public Leprecon(int lvl, int loot){
			super(lvl*2+5, lvl/2, lvl*2+5, lvl*10, "Leprecon", (loot+3)*100, lvl, lvl*2+5, lvl);
		}
}
