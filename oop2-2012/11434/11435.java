import java.util.Random;


abstract public class AttackType {
	
	//en nytt Random-objekt som Šr statiskt. Detta betyder att den Šr gemensam fšr alla objekt i klassen (det skapas inte
	//ett nytt random-objekt fšr varje attackType-objekt).
	static Random random = new Random();

	//atkDmg Šr den slutgiltiga attackskadan fšr en attack.
	private int atkDmg;
	//baseDmg anvŠnds fšr att slumpa fram ett tal som anvŠnds fšr att rŠkna ut attackskadan vid en attack.
	private int baseDmg;
	
	//en metod som ger atkDmg ett vŠrde, med hjŠlp av en inskickad int.
	public void setAtkDmg(int dmg){
		atkDmg = dmg;
	}
	
	//metod som hŠmtar atkDmg
	public int getAtkDmg(){
		return atkDmg;
	}
	
	//metod som ger baseDmg ett vŠrde med hjŠlp av en inskickad int.
	public void setBaseDmg(int dmg){
		baseDmg = dmg;
	}
	
	//metod som hŠmtar baseDmg.
	public int getBaseDmg(){
		return baseDmg;
	}
	
	//metod som ger info om vilken creature man attackerar och hur mycket skada creature tar. 
	//Om creature dšr av attacken sŒ skrivs bara detta ut.
	public void printDamageInducedOn(Creature creature){
		if(!creature.isAlive()){
			System.out.println("You killed " + creature.getName() + ".");
		}else{
			System.out.println("You induced " + getAtkDmg() + " points of damage to " + creature.getName() + ".");
		}
	}
	
	//Skriver ut vad creature ger spelaren i skada (och hur stor skadan Šr).
	public void printDamageReceivedFrom(Creature creature){
		System.out.println(creature.getName() + " attacked you for " + getAtkDmg() + " points of damage.");
	}
	
	//abstrakt metod som anvŠnds i melee och magic.
	abstract public void attack(Creature attacker, Creature enemy);

}
