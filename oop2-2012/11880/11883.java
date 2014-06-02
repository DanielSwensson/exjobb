import java.util.ArrayList;

public class Person {

	private String personName;
	private ArrayList<Possession> allPossessions = new ArrayList<Possession>();

	public Person(String peNa) {
		personName = peNa;
	}

	public String getPersonName() {
		return personName;
	}

	public int getTotalWorth() {
		int totalWorth = 0;
		for (Possession po : allPossessions) {
			totalWorth += po.getWorth();
		}
		return totalWorth;
	}

	public void newPossession(Possession newPossession) {
		allPossessions.add(newPossession);
	}

	public String toString() {
		return personName;
	}
	
	public void printPossessions() {
		for (Possession po : allPossessions) {
			System.out.println(po.getPossessionName() + " " + po.getWorth() + "kr");
		}
	}

	public void resetAllStock() {
		for (Possession po : allPossessions) {
			if (po instanceof Stock) {
				((Stock) po).resetStock();
			}
		}
	}
}
