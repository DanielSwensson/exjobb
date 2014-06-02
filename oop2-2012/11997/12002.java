package Inlupp2;

public abstract class Item {

	protected String itemName; 
	
	public Item (String itemName) {

		this.itemName = itemName;  
	
	}
	
	public String getItemName() {
		return itemName; 
	}
	
	public abstract double getItemValue();
	
	public String toString() {
		return getItemName() + " " + getItemValue(); 
	}
	
}
