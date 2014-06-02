
public class Sword extends Weapon{
	
	public Sword (String name, int damage){
		super (name, damage);
		type = "Sword";
	}
	
	public int getDamage(){
		return super.getDamage()+12;
	}
	
	
	public String toString(){
		return super.getName()+", "+type+",  Damage: "+getDamage();
	}
}
