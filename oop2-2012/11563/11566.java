import java.util.*;

public class Person {

	private ArrayList<Property> property;
	private String name;

	public Person(String name) {
		property = new ArrayList<Property>();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		name = newName;
	}

	public void addProperty(Property thing) {
		property.add(thing);
	}

	public int sumOfProperty() {
		int totalSum = 0;
		for (Property thing : property) {
			totalSum += thing.getValue();
		}
		return totalSum;
	}

	public void stockCrash() {
		for (Property p : property) {
			if (p instanceof Stock) {
				((Stock) p).setPrice(0);
			}
		}
	}

	public void printProperty() {
		for (Property p : property) {
			System.out.println("  " + p);
		}
	}

	public String toString() {
		return String.format("%-15s %d", name, sumOfProperty());
	}
}
