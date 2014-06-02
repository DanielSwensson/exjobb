package valuables;

import java.util.ArrayList;

public class Register {
	private ArrayList<Person> persons;

	public Register() {
		persons = new ArrayList<Person>();
	}

	public void addPerson(String name) throws Exception {
		if (isPersonAlreadyRegistered(name)) {
			throw new Exception("Person already added!");
		}
		persons.add(new Person(name));
	}

	public Person findPerson(String name) throws Exception {
		for (Person p : persons) {
			if (p.getName().equals(name)) {
				return p;
			}
		}

		throw new Exception("Personen finns ej");
	}

	public void setStockMarketCrash() {
		for(Person p: persons){
			for(Valuable v:p.getValuables()){
				if(v instanceof Stock){
					((Stock) v).setStockMarketCrash();
				}
			}
		}
	}

	public ArrayList<Person> getAllPersons() {
		return persons;
	}

	private boolean isPersonAlreadyRegistered(String name) {
		try {
			return findPerson(name) != null;
		} catch (Exception e) {
			return false;
		}
	}
}
