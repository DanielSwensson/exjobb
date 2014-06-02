import java.util.ArrayList;

public class Person {


	private String name;

	public Person (String name){
		this.name=name;
	}
	
	public void setName(String newName){
		name=newName;
	}
	
	public String getName(){
		return name;
	}
	
	private ArrayList<Thing> collection = new ArrayList<Thing>();

	public void addThing(Thing newThing){
		collection.add(newThing);
	}
	
	public void printCollection(){
		for (int i=0; i<collection.size(); i++){
			System.out.println(collection.get(i).toString());
		}
	}
	
	public double getTotalValue(){
		double totalValue=0;

		for (int i=0; i<collection.size(); i++){
			totalValue=totalValue + collection.get(i).getValue();
		}
		return totalValue;
	}
	
	public void stockMarketCrash(){
		for (int i=0; i<collection.size(); i++){
			if (collection.get(i) instanceof Stock){
				((Stock)collection.get(i)).setPrice(0);
			}

		}
	}
	
	public String toString(){
		return name;
	}
}



