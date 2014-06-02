
public abstract class Creature {
	
	private String name;
	private int str;
	private int intel;
	private int def;
	private int health;
	private int mana;
	
	//konstruktor f�r att skapa ett objekt av klassen Creature.
	public Creature(String name, int strength, int intelligence, int defence, int hp, int mp) { 
		this.name = name;
		str = strength;
		intel = intelligence;
		def = defence;
		health = hp;
		mana = mp;
	}
	
	//En alternativ konstruktor f�r att skapa ett objekt av klassen Creature.
	public Creature(int strength, int intelligence, int defence, int hp, int mp) { 
		str = strength;
		intel = intelligence;
		def = defence;
		health = hp;
		mana = mp;
	}
	
	//En metod f�r att kolla om en Creature lever.
	public boolean isAlive(){
		if(health > 0){
			return true; //ITS ALIIIIVE!!
		}
		else{
			setHealth(0);
			return false;//D�d. :(
		}
	}
	
	//En metod som tar bort mana fr�n en Creature.  
	public void consumeMana(Magic magic){
		
		setMana(getMana()-magic.getManaCost());
	}
	
	//En metod som kollar om man har tillr�ckligt med mana f�r att utf�ra magic (ett objekt av klassen AttackType/Magic)
	public boolean enoughMana(Magic magic){ 
		if(getMana() >= magic.getManaCost()){
			return true;
		}
		else{
			return false;
		}
	}
	
	//Kan �ndra namnet f�r Creature.
	public void setName(String name){
		this.name = name;
	}
	
	//H�mtar namnet f�r Creature.
	public String getName(){
		return name;
	}
	
	//H�mtar styrkan f�r Creature.
	public int getStr(){
		return str;
	}
	
	//H�mtar intelligensen f�r Creature.
	public int getIntel(){
		return intel;
	}
	
	//H�mtar skydd f�r Creature.
	public int getDef(){
		return def;
	}
	
	//H�mtar nuvarande livspo�ng f�r Creature.
	public int getHealth(){
		return health;
	}
	
	//H�mtar nuvarande mana (magipo�ng) f�r Creature.
	public int getMana(){
		return mana;
	}
	
	//Best�mmer livspo�ng f�r Creature.
	public int setHealth(int health){
		this.health = health;
		return health;
	}
	
	//Best�mmer magipo�ng f�r Creature.
	public int setMana(int mana){
		this.mana = mana;
		return mana;
	}
	
	//En metod som endast anv�nds av subklasserna. 
	public abstract void racialAtk(Creature enemy, AttackType att);
		
	//�verskuggar den ursprungliga toString-metoden (som alla objekt har). Skriver ut information om objektet.
	public String toString(){
		return getName() + "\n--------------\nHP: " + getHealth() + " / MP: " + getMana();
	}
}
