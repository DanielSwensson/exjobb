
import java.util.ArrayList;

public class Person {

	private ArrayList<Thing> things = new ArrayList<Thing>();

	private String name;
	private double wealth;

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public double getWealth() {
		wealth = 0;
		for (Thing t : things) {
			wealth += t.getValue();
		}
		return wealth;
	}

	public void addThing(Thing t) {
		things.add(t);
	}

	public String getThings() {
		String allThings = "";
		for (Thing t : things) {
			allThings += t;
		} 
		return allThings;
	}

	public void stockMarketCrash() {
		for (Thing t : things) {
			if (t instanceof Share) {
				((Share)t).setPrice(0);
			}
		}
	}

	public String toString() {
		return "Name: " + name + "\tWealth: " + getWealth();
	}

}