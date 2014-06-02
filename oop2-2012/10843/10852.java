
public class Mace extends Weapon {
	
	public Mace (String name, int damage){
		super (name, damage);
		type = "Mace";
	}
	
	public int getDamage(){
		return super.getDamage()+3;
	}
	
	public String toString(){
		return super.getName()+", "+type+", Damage: "+getDamage();
	}
}
