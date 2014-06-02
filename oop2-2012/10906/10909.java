import java.util.ArrayList;

public class Person {

	private ArrayList<Thing> things;
	private String name;

	public Person(String name) {
		this.name = name;
		things = new ArrayList<Thing>();
	}

	public String getName() {
		return name;
	}

	public void addThing(Thing thing) {
		things.add(thing);
	}

	public double getTotalValue() {
		double totalValue = 0;
		for (Thing thing : things) {
			totalValue += thing.getValue();
		}
		return totalValue;
	}

	public String getAllThings() {
		String allThings = "";
		for (Thing thing : things) {
			allThings += thing.getName() + " " + thing.getValue() + "\n";
		}
		return allThings;
	}

	public void stockCrash() {
		for (Thing thing : things) {

			if (thing instanceof Share) {
				((Share) thing).setPrice(0);
			}

		}
	}
}
