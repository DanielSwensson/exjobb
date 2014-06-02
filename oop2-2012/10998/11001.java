import java.util.ArrayList;

public class Person {
	private String personName;

	Person(String n) {
		personName = n;
	}

	ArrayList<Valuable> allValuables = new ArrayList<Valuable>();

	public String getPersonName() {
		return personName;
	}

	public String toString() {
		return personName + ", äger prylar till ett värde av " + totalValue();
	}

	public void showAllValuables() {

		for (Valuable v : allValuables) {
			System.out.println(v.toString2());

		}
	}

	public void valuableToPerson(Valuable x) {
		allValuables.add(x);
		System.out.println("Prylen är registrerad :)");
	}

	public double totalValue() {
		double value = 0;

		for (Valuable x : allValuables) {
			value += x.getValue();
		}
		return value;
	}

	public void shareholdingToZero() {
		for (Valuable v : allValuables)
			if (v instanceof Shareholding) {
				((Shareholding)v).setPriceToZero();
			}
	}

}