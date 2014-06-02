import java.util.ArrayList;

public class Person {

	// attributes:
	private String name;

	/* When creating a Person object an ArrayList is created in this class */
	private ArrayList<Valuable> allValuables = new ArrayList<Valuable>();

	// constructor:
	Person(String name) {
		this.name = name;
	}

	// methods:
	public String getName() {
		return name;
	}

	public void addValuable(Valuable v) {
		allValuables.add(v);
	}

	public String toString() {
		return name + allValuables;
	}

	public double getTotalValue() {
		double totalValue = 0;

		for (int x = 0; x < allValuables.size(); x++) {
			totalValue = totalValue + allValuables.get(x).calculateValue();
		}
		return totalValue;
	}

	public String getValuableInfo() {
		String valuableInfo = "";
		for (int x = 0; x < allValuables.size(); x++) {
			valuableInfo += allValuables.get(x);
			valuableInfo += "\n";
		}
		return valuableInfo;
	}

	public void stockMarketCrash() {
		for (Valuable v : allValuables) {
			if (v instanceof Stock) {
				Stock s = (Stock) v;
				s.setPricePerQuantity(0);
			}//if
		}//for
	}//stockMarketCrash

}
