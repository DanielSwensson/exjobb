
abstract public class Item {
	private int value;
	private String itemName;
	
	public Item(String name){
		this.itemName = name;
	}

	public int getValue(){
		return value;
	}
	
	public void setPrice(){
	
	}
	
	public String getName(){
		return itemName;
	}
	
	public String toString(){
		return "\t "+ getName() + " " + getValue();
	}

}