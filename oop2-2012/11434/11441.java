
public class Warlock extends Creature {

	private final int MAX_MP;
	
	//En konstruktor f�r att skapa ett objekt av klassen Warlock. Tar ett antal heltal som parametrar f�r attributen.
	public Warlock (int intel, int def, int hp, int mp) {
		super (1, intel, def, hp, mp); //Skickar vidare attributen till superklassens konstruktor.
		setName("Warlock");
		MAX_MP = mp;
	}
	
	//En metod f�r Warlocks specifika attackm�nster.
	public void racialAtk(Creature enemy, AttackType att){
		
		//Tar en Creature (den som blir attackerad) och en attacktyp som parametrar.
		//Om Warlock inte har tillr�ckligt med magipo�ng och nuvarande magipo�ng inte �verstiger Warlockens maximala magipo�ng,
		//s� �terst�lls Warlockens magipo�ng (successivt). Annars attackerar Warlocken fiende med.
		
		if (!enoughMana((Magic) att) && getMana() <= MAX_MP) {
			System.out.println("Warlock is out of mana, and unable to attack!\n*uses round to recover mana*");
			setMana(getMana() + 10);
		}else{
			att.attack(this, enemy);
			att.printDamageReceivedFrom(this);
		}
	}
}