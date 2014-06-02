
public class Share extends Item{
//	private int quantity;
	
	public Share(String name, int quantity, int price){
		this.name = name;
		value = quantity * price;
	}
	
	public int getValue() {
		return value;
	}
	
	public void makeWorthless(){
		value = 0;
	}
	
}
