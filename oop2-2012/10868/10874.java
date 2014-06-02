import java.util.ArrayList;
public class Person {
	
	String personName;
	public ArrayList <Item> itemList = new ArrayList <Item>();
	
	public Person(String name){
		
		personName = name;
		System.out.println("A person with the name " + personName + " has been created.");
		
	}
	
	public String getName(){
		
		return personName;
		
	}
	
	public void addItem(Item newItem){
		
		itemList.add(newItem);
		
	}
	public int getTotalValue(){
		int totalValue = 0;
		for(Item i : itemList){
			totalValue += i.getValue();
		}
		return totalValue;
		
	}
	
	public void getItemName(){
		
		for(Item i : itemList){
			
			System.out.println(i.getName() + "\t" + i.getValue());
			
		}
		
	}
	
}
