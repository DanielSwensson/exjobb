package valuables;

import java.util.ArrayList;

public class Person {
	private final String name;
	private ArrayList<Valuable> valuables;
	
	public Person(String name) {
		this.name = name;
		this.valuables = new ArrayList<Valuable>();
	}
	
	public String getName() {
		return name;
	}

	public void addValuable(Valuable v) {
		valuables.add(v);
	}

	@Override
	public boolean equals(Object person) {
		if (person == null || !(person instanceof Person)) {
			return false;
		}
		return ((Person) person).getName().equals(getName());
	}

	public ArrayList<Valuable> getValuables() {
		return valuables;
	}

	public int getValue() {
		int sum = 0;
		for (Valuable v : valuables) {
			sum += v.getValue();

		}
		return sum;
	}

}
