import java.util.ArrayList;

public class Person {
	
	private int totalValue;
	ArrayList<Item> itemList = new ArrayList<Item>();
	private String name;
	
	public Person(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void nullifyStock(){
		for(Item item : itemList){
			if(item instanceof Stock){
				((Stock) item).setPrice(0);
			}
		}
	}
	
	public void addItem(Item i){
		itemList.add(i);
	}

	public int getItemSize(){
		return itemList.size();
	}
	
	public int getTotalValue(){
		totalValue = 0;
		for(int i=0; i<itemList.size();i++){
			totalValue += itemList.get(i).getValue();
		}
		return totalValue;
	}
	
	public void printAllItem(){
		for(int i=0; i<itemList.size(); i++){
			System.out.println(itemList.get(i).toString());
		}
	}
	

}