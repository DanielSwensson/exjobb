import java.util.ArrayList;

public class Inventory {
	
	private ArrayList<Item> itemList = new ArrayList<Item>();

	public Inventory() {
		
	}
	
	public void add(Item newLoot) {
		System.out.println("You have picked up " + newLoot.getName() + "!");
		itemList.add(newLoot);

	}
	
	public void printInv() {
		System.out.println("-----INVENTORY-----");
		
		for (Item i: itemList) {
			System.out.println(i);
			}
		
		if(size()==0)
			System.out.println("Empty");
		System.out.println("-------------------");
	}
	
	public int size(){
		return itemList.size();
	}
	
	public Item getItem(int positionInArray){
		return itemList.get(positionInArray);
	}
	
	public Weapon getWeapon(){
		
		for(Item item: itemList){
			if (item instanceof Weapon){
				return (Weapon)item;
			}
		}
		return null;
	}

}
