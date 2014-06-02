import java.util.ArrayList;
public class People {
	
	private ArrayList <Item> allItem;
	private String name;
	
	public People (String name) {
		allItem = new ArrayList<Item>();
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public ArrayList <Item> getItem(){
		return allItem;
	}
	
	public int getTotalValue(){
		int totalValue = 0;
		for (Item i : allItem){
			totalValue = totalValue + i.getValue();
		}
		return totalValue;
	}
	
	public void addItem(Item i){
		allItem.add(i);
		return;
	}

        
    

	
}
