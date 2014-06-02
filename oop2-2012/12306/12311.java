
import java.util.List;
import java.util.ArrayList;
public class Person {
	
	private String name;
	
	List<Item> itemList = new ArrayList<Item>();

	public Person(String name){
		this.name = name;
	}
	
	public double calculateNetWorth(){
		double total = 0;
		for(Item item : itemList){
		 total += item.calculateValue();
		}
		return total;
	}
	
	public void addItem(Item item){
		itemList.add(item);
	}

	public List<Item> getItemList(){
		return itemList;
	}
	
	public void initiateStockCrash(){
		for(Item i : itemList){
			i.affectedStockCrash();
		}
	}
	
	public String toString(){
		return name;
	}
	
	public String getName(){
		return name;
	}
}
