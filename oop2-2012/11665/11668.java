import java.io.Serializable;
import java.util.ArrayList;

public class Person implements Serializable{
	private String name;
	private ArrayList<Thing> allThings;

	Person(String n){
		name = n;
		allThings = new ArrayList<Thing>();
	}
	
	public void addThing(Thing t){
		allThings.add(t);
		return;
	}

	public String getName() {
		return name;
	}
	
	public ArrayList<Thing> getThings(){
		return allThings;
	}

	public int getTotalValue() {
		int totalValue = 0;
		for(Thing t : allThings){
			totalValue += t.getValue();
		}
		return totalValue;
	}
	
	public void printThings(){
		for(Thing t : allThings){
			System.out.println(" " + t.getName() + "  " + t.getValue());
		}
		return;
	}
	
	public void removeThing(int i){
		allThings.remove(i);
		return;
	}
}
