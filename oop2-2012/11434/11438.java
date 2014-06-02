
public class Magic extends AttackType{
	
	private int manaCost;
	
	//Constructor som tar tv� variabler. Den ena (pwr) skickas in i metoden
	//setBaseDmg() som anv�nder sig av denna int f�r att s�tta basskadan. 
	//Mana ger ett v�rde till inten manaCost.
	public Magic(int pwr, int mana) {
		setBaseDmg(pwr);
		manaCost = mana;
	}
	
	//metod som returnera attributet manaCost
	public int getManaCost(){
		return manaCost;
	}

	//Metod som tar tv� objekt av klassen Creature som parametrar.
	public void attack(Creature attacker, Creature enemy){
		//Tar basskadan som sparats med hj�lp av metoden setBaseDmg()
		//och slumpar fram skada baserat p� detta. 
		//Sedan l�ggs intelligensen hos attackeraren till skadan, och fiendens 
		//halva defence dras bort. Denna utr�kning s�tter den slutgiltiga attackskadan.
		//Om skadan �r mindre eller lika med 0 s� s�tts attackskadan till 0.
		//Om attackeraren har tillrc�kligt med mana f�r denna magiattack s� uts�tts fienden f�r denna skada.
		//Sedan dras manan fr�n attackeraren.
		
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
