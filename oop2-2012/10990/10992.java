import java.util.*;

public class Person {
	private String name;

	private ArrayList<Item> allBelongings = new ArrayList<Item>();

	public Person(String name) {
		this.name = name;

	}

	public void addBelongings(Item s) {
		allBelongings.add(s);
	}

	public String listAllBelongings() {
		String theList = "";
		for (int i = 0; i < allBelongings.size(); i++) {
			theList += " " + allBelongings.get(i).getItemName() + " "
					+ allBelongings.get(i).getWorth() + "\n";
		}
		return theList;

	}

	public String getName() {
		return name;

	}

	public double getWorth() {
		int totalSum = 0;
		for (int x = 0; x < allBelongings.size(); x++)
			totalSum += allBelongings.get(x).getWorth();

		return totalSum;

	}

	public void getStockMarketCrash() {

		for (int i = 0; i < allBelongings.size(); i++) {
			if (allBelongings.get(i) instanceof Stock) {
				((Stock) allBelongings.get(i)).crashedStockMarket();
			}

		}

	}
}
