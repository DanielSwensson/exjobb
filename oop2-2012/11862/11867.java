import java.util.ArrayList;

public class Person {
	private String name;
	private ArrayList<Item> itemList = new ArrayList<Item>();

	Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Item getItem(String name) {

		if (!itemList.isEmpty()) {
			for (Item temp : itemList) {
				if (temp.getName().equalsIgnoreCase(name)) {
					return temp;
				}
			}
		}
		return null;
	}


	public void listItems() {
		if (!itemList.isEmpty()) {
			for (Item temp : itemList) {
				System.out.println(temp);
			}
		}
	}

	public double totalValue() {

		double sum = 0;
		if (!itemList.isEmpty()) {
			for (Item temp : itemList) {
				sum += temp.getValue();
			}
		}
		return sum;
	}

	public void crashStocks() {
		for (Item temp : itemList) {
			if (temp instanceof Stock) {
				((Stock) temp).setUnitPrice(0);
			}
		}
	}

	public ArrayList<Item> getItemList() {
		return itemList;
	}

	public String toString() {
		return name + " " + totalValue();
	}
}
