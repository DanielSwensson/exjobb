
public class Class_Gadget extends Class_Stuff {
	
	private int gadgetCondition;
	
	public int getCondition() {
		return this.gadgetCondition;
	}
	
	public Class_Gadget(int ownerId, String name, int condition, int valueOfItem) {		
		super(name, (int)(((double)valueOfItem/10d)*(double)condition), ownerId);
		this.gadgetCondition = condition;		
	}
}
