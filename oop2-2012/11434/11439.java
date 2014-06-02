public class Melee extends AttackType {

	//Constructor som tar en variabel atk. Denna variabel skickas in i metoden
	//setBaseDmg() som anv�nder sig av denna int f�r att s�tta basskadan.
	public Melee(int atk) { 
		setBaseDmg(atk);
	}

	//Metod som tar tv� objekt av klassen Creature som parametrar.
	public void attack(Creature attacker, Creature enemy){
		//Tar basskadan som sparats med hj�lp av metoden setBaseDmg()
		//och slumpar fram skada baserat p� detta. 
		//Sedan l�ggs styrkan hos attackeraren till skadan, och fiendens 
		//defence dras bort. Denna utr�kning s�tter den slutgiltiga attackskadan.
		//Om skadan �r mindre eller lika med 0 s� s�tts attackskadan till 0.
		
		setAtkDmg((random.nextInt(getBaseDmg()) + attacker.getStr()) - enemy.getDef());
		
		if(getAtkDmg() <= 0){
			setAtkDmg(0);
		}
		enemy.setHealth(enemy.getHealth() - getAtkDmg());
	}
	
}
