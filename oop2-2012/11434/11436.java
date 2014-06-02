
public class Character extends Creature {

	//Konstruktor f�r att skapa ett objekt av klassen Character (spelaren). Tar ett antal heltal som parametrar f�r attributen.
	public Character(String name, int str, int intel, int def, int hp, int mp) {
		super(name, intel, str, def, hp, mp);//Skickar vidare attributen upp till superklassens konstruktor.
	}
		
	//En metod f�r spelarens specifika attackm�nster.
		public void racialAtk(Creature enemy, AttackType att){
				
				//Tar en Creature (den som blir attackerad) och en attacktyp som parametrar.
				//Om attacktypen �r en magi s� anropas enoughMana() f�r att kolla om man har tillr�ckligt med magipo�ng
				//f�r att utf�ra magin. Sedan utf�rs denna attack. Attacken skrivs ut. Om attacktypen d�remot inte �r en magi s� m�ste den
				//vara en melee-attack, och denna utf�rs. Attacken skrivs ut.
				
				if(att instanceof Magic){
					if (enoughMana((Magic)att)) {
						att.attack(this, enemy);
						att.printDamageInducedOn(enemy);
					}
				}else {
					att.attack(this, enemy);
					att.printDamageInducedOn(enemy);
				}
			}
}

