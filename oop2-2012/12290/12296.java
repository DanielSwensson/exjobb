import java.util.ArrayList;

public class Class_People {

	private static ArrayList<Class_People> listPeople = new ArrayList<Class_People>();

	private static int idCount = 0;

	private int idOfPerson;
	private String nameOfPerson;

	public static ArrayList<Class_People> getList() {
		return listPeople;
	}

	public Class_People(String name) {

		this.idOfPerson = ++idCount;
		this.nameOfPerson = name;
	}

	public int getId() {

		return this.idOfPerson;
	}

	public String getName() {

		return this.nameOfPerson;
	}
	
	public int getTotalWealth() {
		
			int wealth = 0;
			
			for (Class_Stuff s : Class_Stuff.getStuff()) {
				
				if (s.getOwnerId() == this.idOfPerson) wealth += s.getValue();
			}
			
			return wealth;

	}

	public static int getPersonId(String name) {

		name = name.trim();

		for (Class_People p : listPeople)
			if (p.getName().equalsIgnoreCase(name))
				return p.getId();

		return -1;
	}

	public static String getPersonName(int id) {

		for (Class_People p : listPeople)
			if (p.idOfPerson == id)
				return p.getName();

		return null;
	}

	public static void addPerson(String name) {

		if (getPersonId(name) == -1)
			listPeople.add(new Class_People(name));

	}

}
