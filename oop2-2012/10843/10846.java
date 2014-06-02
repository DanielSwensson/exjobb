
public class Axe extends Weapon {
	
	public Axe (String name, int damage){
		
		super (name, damage);
		type = "Axe";
	}
	
	public int getDamage(){
		return super.getDamage()+8;
	}
	
	
	public String toString(){
		return super.getName()+", "+type+", Damage: "+getDamage();
	}
}
