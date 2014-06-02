import java.util.ArrayList;

public class Person {
	
	private ArrayList<Valuable> allValuables = new ArrayList<Valuable>();

	private String name;
	
	// Konstruktor
	public Person(String name) {
		this.name = name;
	}
	
	// Skriver ut personen och dess värdesaker
	public String printPerson() {
		return toString() + " som äger följande föremål till ett sammanlagt värde av " + getTotalValue() + ":" + getValuables();
	}
	
	// Hämtar personens sammanlagda värde
	public int getTotalValue() {
		int totalValue = 0;
		for (int indexPos = 0; indexPos < allValuables.size(); indexPos++) {
			totalValue += allValuables.get(indexPos).value();
		}
		return totalValue;
	}
	
	// Hämtar personsens namn
	public String getName() {
		return name;
	}
	
	// Hämtar personens värdesaker
	private String getValuables() {
		String valuableList = "";
		for (int indexPos = 0; indexPos < allValuables.size(); indexPos++) {
				valuableList += allValuables.get(indexPos).toString();
		}
		return valuableList;
	}
	
	// Kraschar en aktie
	public void stockCrash () {
		for (int indexPos = 0; indexPos < allValuables.size(); indexPos++) {
			if (allValuables.get(indexPos) instanceof StockShare) {
				StockShare currentStockShare = (StockShare) allValuables.get(indexPos);
				currentStockShare.crashPrice();
			}
		}
	}
	
	// Lägger in värdesak i arrayen
	public void addValuable (Valuable valuable) {
		allValuables.add(valuable);
	}

	// toString
	public String toString() {
		return name;
	}
	
}
