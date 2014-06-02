import java.util.ArrayList;

public class Person {
	private String name;
	private ArrayList<Item> items;

	public Person(String name) {
		this.name = name;
		items = new ArrayList<Item>();
	}

	public void addItem(Item x) {
		items.add(x);
	}

	public String toString() {
		return name + "\t" + getNetworth();
	}

	public double getNetworth() {
		double sum = 0;

		for (Item i : items) {
			sum += i.getValue();
		}
		return sum;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public String getName() {
		return name;
	}

	public void affectByStockcrash() {
		for (Item i : items) {
			i.affectByStockcrash();
		}
	}

}
