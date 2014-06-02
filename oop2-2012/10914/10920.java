import java.io.Serializable;
import java.util.ArrayList;

public class PersonRegister implements Serializable {
	
	private ArrayList<Person> persons;
	public PersonRegister(ArrayList<Person> persons) {
		this.persons = persons;
	}
	public PersonRegister() {
		this(new ArrayList<Person>());
	}
	
	public Person getPersonByName(String name) {
        for(Person p : persons) {
            if(p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
		return null;
	}
	
	public Person addPerson(String name) {
		if(getPersonByName(name) == null) {
			Person newPerson = new Person(name);
			persons.add(newPerson);
			return newPerson;
		} else {
			return null;
		}
	}
	
	public ArrayList<Person> getAllPersons() {
		sortPersonsByValueDesc();
		return persons;
	}
	
	public void sortPersonsByValueDesc() {
		Person tmp;
		for(int a = 0; a < persons.size(); a++) {
			for(int b = a + 1; b < persons.size(); b++) {
				if(persons.get(b).getTotalValue() > persons.get(a).getTotalValue()) {
					tmp = persons.get(a);
					persons.set(a, persons.get(b));
					persons.set(b, tmp);
				}
			}
		}
	}
	
	public ArrayList<Person> getRichestPerson() {
		sortPersonsByValueDesc();
		ArrayList<Person> richestPersons = new ArrayList<Person>();
		richestPersons.add(persons.get(0));
		for(int i = 1; i < persons.size(); i++) {
			if(persons.get(0).getTotalValue() == persons.get(i).getTotalValue()) {
				richestPersons.add(persons.get(i));
			}
		}
		return richestPersons;
	}
}
