
public class Weapon extends Item{
	
	private int damage;
	
	public Weapon(String name, int damage){
		super(name);
		this.damage = damage;
		equipmentSlot = 4;
	}
	
	public int getDamage(){
		return damage;
	}
	
	public int getValue(){
		return getDamage()*10;
	}
	
	public String toString(){
		return super.toString()+", Damage: "+damage;
	}
}
