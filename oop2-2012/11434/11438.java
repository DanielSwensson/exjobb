
public class Magic extends AttackType{
	
	private int manaCost;
	
	//Constructor som tar tvŒ variabler. Den ena (pwr) skickas in i metoden
	//setBaseDmg() som anvŠnder sig av denna int fšr att sŠtta basskadan. 
	//Mana ger ett vŠrde till inten manaCost.
	public Magic(int pwr, int mana) {
		setBaseDmg(pwr);
		manaCost = mana;
	}
	
	//metod som returnera attributet manaCost
	public int getManaCost(){
		return manaCost;
	}

	//Metod som tar tvŒ objekt av klassen Creature som parametrar.
	public void attack(Creature attacker, Creature enemy){
		//Tar basskadan som sparats med hjŠlp av metoden setBaseDmg()
		//och slumpar fram skada baserat pŒ detta. 
		//Sedan lŠggs intelligensen hos attackeraren till skadan, och fiendens 
		//halva defence dras bort. Denna utrŠkning sŠtter den slutgiltiga attackskadan.
		//Om skadan Šr mindre eller lika med 0 sŒ sŠtts attackskadan till 0.
		//Om attackeraren har tillrcškligt med mana fšr denna magiattack sŒ utsŠtts fienden fšr denna skada.
		//Sedan dras manan frŒn attackeraren.
		
		setAtkDmg(((random.nextInt(getBaseDmg())+2) + attacker.getIntel()) - (enemy.getDef()/2));
		
		if(getAtkDmg() <= 0){
			setAtkDmg(0);
		}
		
		if (attacker.enoughMana(this)) {
			enemy.setHealth(enemy.getHealth() - this.getAtkDmg());
			attacker.consumeMana(this);
		}
	}
}
