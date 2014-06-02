	import java.io.Serializable;
import java.util.ArrayList;

// Class declaration
public class Person implements Serializable{
	
	// Randomly generated serialVersionUID
	private static final long serialVersionUID = -6259068026126444018L;
	
	// Attributes
	private String name;
	private ArrayList<Item> items;
	
	// Constructor
	Person(String name){
		this.name = name;
		items = new ArrayList<Item>();
	}
	
	// Method for adding items to the persons ArrayList of items
	public void addItem(Item x){
		items.add(x);
	}	
	
	// Method returning the name
	public String getName(){
		return name;
	}
	
	// Method returning item name
	public void printAllItems(){
		for (Item x : items){
			System.out.println("* " + x.getName() + "\n\t\t\t\t" + x.getValue()); 
		}
	}
	
	// Get-method for the persons ArrayList containing all the items
	public ArrayList<Item> getAllItems(){
		return items;
	}
	
	// Method returning total value of all registered items
	public double getTotalValue(){
		double value = 0;
		for (Item x : items){
			value += x.value;
		}
		return value;
	}
}