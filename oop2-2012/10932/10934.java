import java.util.ArrayList;
import java.util.List;

public class Person {
	private String name;
	private List<Item> items = new ArrayList<Item>();

	public Person(String name) {
		this.name = name;
	}

	public void stockMarketCrash() {
		for (Item item : items) {
			if (item instanceof Stock) {
				Stock stock = (Stock) item;
				stock.setPrice(0);
			}
		}
	}

	public String toString() {
		return String.format("%-10s", name) + " " + calculateValueOfBelongings();
	}

	public String getName() {
		return name;
	}

	public void addItem(Item item) {
		items.add(item);
	}

	public List<Item> getItems() {
		return items;
	}

	public double calculateValueOfBelongings() {
		double sum = 0;
		for (Item item : items) {
			sum = sum + item.calculateValue();
		}
		return sum;
	}

	public boolean equals(Object otherPerson) {
		Person p = (Person) otherPerson;
		return name.equalsIgnoreCase(p.getName());
	}
}