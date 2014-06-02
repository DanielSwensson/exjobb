import java.io.Serializable;
import java.util.ArrayList;

public class Person implements Serializable{
	private static final long serialVersionUID = -373730635527775277L;
	
	//Instance variables
	private String name;
	private ArrayList<Thing> thingCollection = new ArrayList<Thing>();

	//Constructor
	public Person(String startName) {
		name = startName;
	}

	public void addThing(Thing t) {
		thingCollection.add(t);
	}
	
	public String getName() {
		return name;
	}
	
	public int getNetWorth() {
		int value = 0;
		for (Thing t : thingCollection) {
			value += t.getValue();
		}
		return value;
	}
	
	public ArrayList<Thing> getThingCollection() {
		return thingCollection;
	}
	
	public void removeThing(int i) {
		thingCollection.remove(i);
	}
	
	public String toString() {
		return name + "\t" + getNetWorth();
	}
	
	public String toString(ArrayList<Thing> al) {
		String stuff = "";
		for (Thing t : al) {
			stuff += t.getName() + "\t" + t.getValue() +"\n";
		}
		return stuff;
	}
		
} //Class
