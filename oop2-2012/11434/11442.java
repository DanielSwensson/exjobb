
public class Zombie extends Creature {

	//Konstruktor fšr att skapa ett objekt av klassen Zombie. Tar ett antal heltal som parametrar fšr attributen.
	public Zombie (int str, int def, int hp) { 
		super (str, 1, def, hp, 0); //Skickar vidare attributen upp till superklassens konstruktor.
		setName("Zombie");
	}
	
	//En metod fšr zombiens specifika attackmšnster.
	public void racialAtk(Creature enemy, AttackType att){
		
		//Tar en Creature (den som blir attackerad) och en attacktyp som parametrar.
		//om Zombiens liv Šr 2 eller mindre sŒ sŠtts basskadan fšr attacktypen till 15 och zombien "exploderar". Attacken skrivs ut.
		//Zombien dšr och livet sŠtts alltsŒ till 0.
		//Om livet Šr 3 eller mer sŒ attackerar zombien med den basskada som specificerats i attacktypen (i main). Attacken skrivs ut.
		
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
