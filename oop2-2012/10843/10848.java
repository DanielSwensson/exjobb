
public class ChestArmor extends Armor {
	
	
	public ChestArmor (String name, int defense){
		super (name, defense);
		equipmentSlot = 1;
		type = "Chest armor";
		
	}
	
	
	public String toString(){
		return super.toString();
	}
}
