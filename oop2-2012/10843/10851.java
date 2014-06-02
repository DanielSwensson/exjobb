
public class LegArmor extends Armor {
	
	
	public LegArmor (String name, int defense){
		super (name, defense);
		equipmentSlot = 2;
		type = "Leg armor";
	}
	
	public String toString(){
		return super.toString();
	}
}
