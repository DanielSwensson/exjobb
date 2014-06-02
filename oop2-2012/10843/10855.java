
public class Shield extends Armor {
	
	private int blockValue;
	
	public Shield (String name, int defense, int blockValue){
		super (name, defense);
		this.blockValue = blockValue;
		equipmentSlot = 3;
		type = "Shield";
	}
	
	public int getBlockValue(){
		return blockValue;
	}
	
	public int getValue(){
		return (getDefense()+blockValue)*5;
	}
	public String toString(){
		return super.toString()+", BlockValue: "+blockValue;
	}
}
