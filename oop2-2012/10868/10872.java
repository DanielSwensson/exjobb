
public abstract class Item {

	private String itemName;
	
	public Item(String name){
		
		itemName = name;
		
	}
	
	public abstract int getValue();
	
	public String getName(){
		return itemName;
	}
	
}
