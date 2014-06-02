public class Melee extends AttackType {

	//Constructor som tar en variabel atk. Denna variabel skickas in i metoden
	//setBaseDmg() som anvŠnder sig av denna int fšr att sŠtta basskadan.
	public Melee(int atk) { 
		setBaseDmg(atk);
	}

	//Metod som tar tvŒ objekt av klassen Creature som parametrar.
	public void attack(Creature attacker, Creature enemy){
		//Tar basskadan som sparats med hjŠlp av metoden setBaseDmg()
		//och slumpar fram skada baserat pŒ detta. 
		//Sedan lŠggs styrkan hos attackeraren till skadan, och fiendens 
		//defence dras bort. Denna utrŠkning sŠtter den slutgiltiga attackskadan.
		//Om skadan Šr mindre eller lika med 0 sŒ sŠtts attackskadan till 0.
		
		setAtkDmg((random.nextInt(getBaseDmg()) + attacker.getStr()) - enemy.getDef());
		
		if(getAtkDmg() <= 0){
			setAtkDmg(0);
		}
		enemy.setHealth(enemy.getHealth() - getAtkDmg());
	}
	
}
