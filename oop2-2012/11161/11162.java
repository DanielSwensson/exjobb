
public class Gadget extends Thing {
	private static final long serialVersionUID = 1606401038325469525L;

	//Instance variables
	private int cost;
	private int wear;
	
	//Constructor
	public Gadget(String startName, int startCost, int startWear) {
		super(startName);
		cost = startCost;
		wear = startWear;
	}
	
	public int getValue() {
		return (int) (cost * (wear / 10.0 ));
	}
	
	public String toString() {
		return super.getName() + " " + cost + " " + wear;    
    }

} //Class
