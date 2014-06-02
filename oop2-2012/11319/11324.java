package valueables;

import java.util.ArrayList;
import valueables.items.Item;

public class Person {

	private String name;
	private ArrayList<Item> items = new ArrayList<Item>();
	
	public Person(String name){
		this.name = name;
	}
	
	/*
	 * Get Person name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/*
	 * Assign an item to person
	 * @param i item
	 */
	public void addItem(Item i){
		items.add(i);
	}
	
	/*
	 * Retrieve total financial assets
	 * @return total assets
	 */
	public int getAssets(){
		int assets = 0;
		
		for(Item i : items){
			assets+= i.getValue();
		}
		return assets;
	}
	public void marketCrash(){
		for(Item i : items){
			i.marketCrash();
		}
	}
	
	public String getItemList(){
		String list = "";
		for(Item i : items){
			list+="\n"+i.toString();
		}
		return list;
	}
	
	public String toString(){
		
		return name+"\t\t"+getAssets();
	}
}
