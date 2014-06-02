import java.io.Serializable;
import java.util.ArrayList;


public class Person implements Serializable {
	
	private String name;
	private ArrayList<Item> items = new ArrayList<Item>();
	private static int anonymousPersonCounter;
	
	public Person(String name) {
		this.name = name != null && !name.equals("") ? name : "Anonym Person#" + ++anonymousPersonCounter;
	}
	
	public Person() {
		this(null);
	}
	
	public String getName() {
		return name;
	}
	
	public void addItem(Item i) {
		items.add(i);
	}
	
	public double getTotalValue() {
		double totalValue = 0;
		if(items.size() > 0) {
			for(Item i : items) {
				totalValue += i.getValue();
			}
		}
		return totalValue;
	}
	
	public ArrayList<Item> getItems() {
		return items;
	}
	
	public String toString() {
		return "Namn: " + name + " Värde: " + getTotalValue();
	}

}
