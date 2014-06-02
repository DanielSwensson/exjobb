
public abstract class Creature {
	
	private String name;
	private int str;
	private int intel;
	private int def;
	private int health;
	private int mana;
	
	//konstruktor fšr att skapa ett objekt av klassen Creature.
	public Creature(String name, int strength, int intelligence, int defence, int hp, int mp) { 
		this.name = name;
		str = strength;
		intel = intelligence;
		def = defence;
		health = hp;
		mana = mp;
	}
	
	//En alternativ konstruktor fšr att skapa ett objekt av klassen Creature.
	public Creature(int strength, int intelligence, int defence, int hp, int mp) { 
		str = strength;
		intel = intelligence;
		def = defence;
		health = hp;
		mana = mp;
	}
	
	//En metod fšr att kolla om en Creature lever.
	public boolean isAlive(){
		if(health > 0){
			return true; //ITS ALIIIIVE!!
		}
		else{
			setHealth(0);
			return false;//Dšd. :(
		}
	}
	
	//En metod som tar bort mana frŒn en Creature.  
	public void consumeMana(Magic magic){
		
		setMana(getMana()-magic.getManaCost());
	}
	
	//En metod som kollar om man har tillrŠckligt med mana fšr att utfšra magic (ett objekt av klassen AttackType/Magic)
	public boolean enoughMana(Magic magic){ 
		if(getMana() >= magic.getManaCost()){
			return true;
		}
		else{
			return false;
		}
	}
	
	//Kan Šndra namnet fšr Creature.
	public void setName(String name){
		this.name = name;
	}
	
	//HŠmtar namnet fšr Creature.
	public String getName(){
		return name;
	}
	
	//HŠmtar styrkan fšr Creature.
	public int getStr(){
		return str;
	}
	
	//HŠmtar intelligensen fšr Creature.
	public int getIntel(){
		return intel;
	}
	
	//HŠmtar skydd fšr Creature.
	public int getDef(){
		return def;
	}
	
	//HŠmtar nuvarande livspoŠng fšr Creature.
	public int getHealth(){
		return health;
	}
	
	//HŠmtar nuvarande mana (magipoŠng) fšr Creature.
	public int getMana(){
		return mana;
	}
	
	//BestŠmmer livspoŠng fšr Creature.
	public int setHealth(int health){
		this.health = health;
		return health;
	}
	
	//BestŠmmer magipoŠng fšr Creature.
	public int setMana(int mana){
		this.mana = mana;
		return mana;
	}
	
	//En metod som endast anvŠnds av subklasserna. 
	public abstract void racialAtk(Creature enemy, AttackType att);
		
	//…verskuggar den ursprungliga toString-metoden (som alla objekt har). Skriver ut information om objektet.
	public String toString(){
		return getName() + "\n--------------\nHP: " + getHealth() + " / MP: " + getMana();
	}
}
