import java.util.ArrayList;
import java.io.*;

public class Character implements Serializable {
	private String name;
	private ArrayList<Item> inventory = new ArrayList<Item>();
	private Item [] equipment = new Item [5];
	
	public Character (String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public int getDamage(){
		int damage = 0;
		if(equipment[4] != null){
			if (equipment[4] instanceof Weapon){
				damage = ((Weapon)equipment[4]).getDamage();
			} else{
				damage = -1;
			}
		}		
		return damage;
	}
	
	public int getDefense(){
		int totalDefense = 0;
		for(int x=0; x<equipment.length-1; x++){
			if(equipment[x] != null){
				if(equipment[x] instanceof Armor){
					totalDefense = ((Armor)equipment[x]).getDefense();
				}else {
					totalDefense = -1;
				}
			}
		}
		if(equipment[3] != null){
			if(equipment[3] instanceof Shield){
				totalDefense = (((Shield)equipment[3]).getBlockValue())*2;
			}
		}
		
		return totalDefense;
	}
	
	public Item getItem(String itemName){
		Item i = null;
		for (int x=0; x<inventory.size(); x++){
			if(inventory.get(x).getName().equalsIgnoreCase(itemName)){
				i = inventory.get(x);
			}
		}
		return i;
	}
	
	public void addItem(Item newItem){
		inventory.add(newItem);
	}
	
	public void equipItem(String itemName){
		for (int x=0; x<inventory.size(); x++){
			if(inventory.get(x).getName().equalsIgnoreCase(itemName)){
				equipment[inventory.get(x).getEquipmentSlot()] = inventory.get(x);
			}
		}
	}
	
	public void showEquipment(){
		for(int x=0; x<equipment.length; x++){
			if(equipment[x] != null){
				System.out.println(equipment[x]);
			}
		}
	}
	
	public void showAllItems(){
		for (int x=0; x<inventory.size(); x++){
			System.out.println(inventory.get(x)+", Value: "+inventory.get(x).getValue());
		}
	}
	
	public int getTotalValue(){
		int totalValue =0;
		for (int x=0; x<inventory.size(); x++){
			totalValue = totalValue+inventory.get(x).getValue();
		}
		return totalValue;
	}
	
	public String toString(){
		return name;
	}
}
