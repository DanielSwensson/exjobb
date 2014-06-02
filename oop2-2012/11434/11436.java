
public class Character extends Creature {

	//Konstruktor för att skapa ett objekt av klassen Character (spelaren). Tar ett antal heltal som parametrar för attributen.
	public Character(String name, int str, int intel, int def, int hp, int mp) {
		super(name, intel, str, def, hp, mp);//Skickar vidare attributen upp till superklassens konstruktor.
	}
		
	//En metod för spelarens specifika attackmönster.
		public void racialAtk(Creature enemy, AttackType att){
				
				//Tar en Creature (den som blir attackerad) och en attacktyp som parametrar.
				//Om attacktypen är en magi så anropas enoughMana() för att kolla om man har tillräckligt med magipoäng
				//för att utföra magin. Sedan utförs denna attack. Attacken skrivs ut. Om attacktypen däremot inte är en magi så måste den
				//vara en melee-attack, och denna utförs. Attacken skrivs ut.
				
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

