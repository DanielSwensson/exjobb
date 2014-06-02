import java.util.Random;


abstract public class AttackType {
	
	//en nytt Random-objekt som �r statiskt. Detta betyder att den �r gemensam f�r alla objekt i klassen (det skapas inte
	//ett nytt random-objekt f�r varje attackType-objekt).
	static Random random = new Random();

	//atkDmg �r den slutgiltiga attackskadan f�r en attack.
	private int atkDmg;
	//baseDmg anv�nds f�r att slumpa fram ett tal som anv�nds f�r att r�kna ut attackskadan vid en attack.
	private int baseDmg;
	
	//en metod som ger atkDmg ett v�rde, med hj�lp av en inskickad int.
	public void setAtkDmg(int dmg){
		atkDmg = dmg;
	}
	
	//metod som h�mtar atkDmg
	public int getAtkDmg(){
		return atkDmg;
	}
	
	//metod som ger baseDmg ett v�rde med hj�lp av en inskickad int.
	public void setBaseDmg(int dmg){
		baseDmg = dmg;
	}
	
	//metod som h�mtar baseDmg.
	public int getBaseDmg(){
		return baseDmg;
	}
	
	//metod som ger info om vilken creature man attackerar och hur mycket skada creature tar. 
	//Om creature d�r av attacken s� skrivs bara detta ut.
	public void printDamageInducedOn(Creature creature){
		if(!creature.isAlive()){
			System.out.println("You killed " + creature.getName() + ".");
		}else{
			System.out.println("You induced " + getAtkDmg() + " points of damage to " + creature.getName() + ".");
		}
	}
	
	//Skriver ut vad creature ger spelaren i skada (och hur stor skadan �r).
	public void printDamageReceivedFrom(Creature creature){
		System.out.println(creature.getName() + " attacked you for " + getAtkDmg() + " points of damage.");
	}
	
	//abstrakt metod som anv�nds i melee och magic.
	abstract public void attack(Creature attacker, Creature enemy);

}
