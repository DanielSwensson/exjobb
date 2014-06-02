import java.util.ArrayList;

public class Register {
	private ArrayList<Person> persons;

	public Register() {
		persons = new ArrayList<Person>();
	}

	public void addPerson(Person p) {
		persons.add(p);
	}

	public Person findPerson(String name) {
		for (Person t : persons) {
			if (t.getName().equals(name)) {
				return t;
			}
		}
		return null;
	}

	public Person findRichest() {
		Person richest = null;

		for (Person p : persons) {
			if (richest == null || p.getNetworth() > richest.getNetworth()) {
				richest = p;
			}
		}
		return richest;
	}

	public ArrayList<Person> getPersons() {
		return persons;
	}

	public void affectByStockcrash() {
		for (Person p : persons) {
			p.affectByStockcrash();
		}
	}
}
