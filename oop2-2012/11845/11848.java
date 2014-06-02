import java.util.ArrayList;

public class Person {

	private String name;
	ArrayList<RegisteryObject> ownedObjects = new ArrayList<RegisteryObject>();

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<RegisteryObject> getObjects() {
		return ownedObjects;
	}

	public void addObject(RegisteryObject object) {
		ownedObjects.add(object);
	}

	public double getTotalValue() {
		double total = 0;
		for (int i = 0; i < ownedObjects.size(); i++) {
			total += ownedObjects.get(i).getValue();
		}
		return total;
	}
}