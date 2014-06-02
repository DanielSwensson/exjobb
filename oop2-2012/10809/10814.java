import java.util.ArrayList;

public class Person {
	private String name;
	private ArrayList<Item> itemCollection;
	
	public Person(String name) {
		this.name = name;
		this.itemCollection = new ArrayList<Item>();
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Item> getItemCollection() {
		return itemCollection;
	}
	
	public void addItem(Item i) {
		itemCollection.add(i);
	}
	
	public int getItemCollectionValue() {
		int value = 0;
		
		for(Item i : itemCollection)
			value += i.getValue();
		
		return value;
	}
	
	public void stockMarketCrash() {
		for(Item i : itemCollection) {
			if(i instanceof Shares)
				i.setValue(0);
		}
	}
	
	public String toString() {
		return name +" - " +getItemCollectionValue() +"kr";
	}
}
