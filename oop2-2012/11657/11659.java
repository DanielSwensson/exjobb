
abstract public class Item {

	private String itemName;
	
	public Item (String itemName) {
		this.itemName = itemName;
	}
	
	public String getName(){
		return itemName;
	}
	
	abstract public int getValue();

}
