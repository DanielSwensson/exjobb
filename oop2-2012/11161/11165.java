
public class Stock extends Thing {
	private static final long serialVersionUID = 7288621894052087074L;

	//Instance variables
	private int cost;
	private int number;

	//Constructor
	public Stock(String startName, int startNumber, int startCost) {
		super(startName);
		number = startNumber;
		cost = startCost;
	}
	
	public int getValue() {
		return number * cost;
	}

	public void setCost(int newCost) {
		cost = newCost;
	}
	
	public String toString() {
		return super.getName() + " " + number + " " + cost;    
    }

} //Class
