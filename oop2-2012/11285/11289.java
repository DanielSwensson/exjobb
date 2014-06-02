import java.util.*;
import java.io.*;

public class Person implements Serializable{
	private String name;
	private ArrayList<Item> itemList = new ArrayList<Item>();
		
	public Person(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public int getItemListLength(){
		return itemList.size();
	}
	
	public void addItem(Item item){
		itemList.add(item);
	}
	
	public int getTotalValue(){
		int totalValue = 0;
		for(Item i:itemList){
			totalValue+=i.getValue();
		}
		return totalValue;
	}
	
	public void makeSharesWorthless(){
		for(Item i:itemList){
			if(i instanceof Share){
				((Share) i).makeWorthless();
			}
		}
	}
	
	public void removeItemAtIndex(int index){
		itemList.remove(index);
	}
	
	public String toString(){
		return name+"               "+getTotalValue();
	}
	
	public int getInventoryLength(){
		return itemList.size();
	}
	
	public String toStringInventoryLine(int index){
		if(itemList.get(index)!=null){
			return itemList.get(index).toString();
		}
		return "";
	}
	
}
