import java.util.ArrayList;

public class person {
	private String name;
	private ArrayList<pryl> prylList = new ArrayList<pryl>();

	public person(String n) {
		name = n;
	}

	public void addPryl(pryl p) {
		prylList.add(p);
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return name + " " + getTotalValue();
	}

	public double getTotalValue() {
		double totalValue = 0;
		for (int i = 0; i < prylList.size(); i++) {
		}
		for (pryl i : prylList) {
			totalValue = totalValue + i.getValue();
		}
		return totalValue;
	}

	public void getBelongings() {

		for (pryl y : prylList) {
			System.out.println(y);
		}
	}

	public void stockCrash() {
		for (pryl y : prylList) {
			y.stockCrash();
		}
	}
}
