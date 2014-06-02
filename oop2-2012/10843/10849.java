
public class HeadArmor extends Armor{
	
	
	public HeadArmor (String name, int defense){
		super (name, defense);
		equipmentSlot = 0;
		type = "Head armor";
	}
	

	public String toString(){
		return super.toString();
	}
}
