import java.util.ArrayList;

public class Person {
	private String name;

	private ArrayList<Item> itemList = new ArrayList<Item>();

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public ArrayList<Item> getItemList() {
		return itemList;
	}

	public double getTotalValue() {
		double totalValue = 0;
		for (Item i : itemList) {
			totalValue += i.getValue();
		}
		return totalValue;
	}

	public void listItems() {
		for (Item newItem : itemList) {
			System.out.print("\n" + "	>" + newItem);
		}
	}

	public String toString() {
		return name + " with a total value of " + getTotalValue();
	}
}
