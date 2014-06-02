
public class Zombie extends Creature {

	//Konstruktor f�r att skapa ett objekt av klassen Zombie. Tar ett antal heltal som parametrar f�r attributen.
	public Zombie (int str, int def, int hp) { 
		super (str, 1, def, hp, 0); //Skickar vidare attributen upp till superklassens konstruktor.
		setName("Zombie");
	}
	
	//En metod f�r zombiens specifika attackm�nster.
	public void racialAtk(Creature enemy, AttackType att){
		
		//Tar en Creature (den som blir attackerad) och en attacktyp som parametrar.
		//om Zombiens liv �r 2 eller mindre s� s�tts basskadan f�r attacktypen till 15 och zombien "exploderar". Attacken skrivs ut.
		//Zombien d�r och livet s�tts allts� till 0.
		//Om livet �r 3 eller mer s� attackerar zombien med den basskada som specificerats i attacktypen (i main). Attacken skrivs ut.
		
		if(getHealth() <= 2){	
			att.setBaseDmg(15);
			att.attack(this, enemy);
			System.out.println("Zombie self-destructs, and you are hurt by " + att.getAtkDmg() + " points of damage in the explosion!!");

			setHealth(0);
		}
		
		else {
			att.attack(this, enemy);
			att.printDamageReceivedFrom(this);
		}
	}
}
