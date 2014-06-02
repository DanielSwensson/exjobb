import java.util.ArrayList;

public class User {

	private String name;
	private ArrayList<Item> allItems = new ArrayList<Item>();
	
	User(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public double getValue() {
		double value = 0;
		for (Item i : allItems) value += i.getValue();
		return value;
	}

	public void addItem(Item i) {
		allItems.add(i);
	}
	
	public void stockExchangeCrash() {
		for (Item i : allItems) {
			i.stockExchangeCrash();
		}
	}
	
	public String toString() {
		String text = name+"\t"+getValue()+" kr.\n";
		for (Item i : allItems) {
			text += i.toString();
			text += "\n";
		}
		return text;
	}
}
