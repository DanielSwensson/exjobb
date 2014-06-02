import java.util.ArrayList;
import java.util.List;


public class Register {

	ArrayList<Person> personList = new ArrayList<Person>();
	
	public void initiateStockCrash(){
		for(Person p : personList){
			p.initiateStockCrash();
		}
	}
	
	public List<Item> getSpecificItemList(String name){
		Person p = findPerson(name);
		if(p ==  null){
			return null;
		}
		return p.getItemList();
	}
	
	public List<Person> getPersonList(){
		return personList;
	}
	
	public Person getRichestPerson() {
		Person candidate = null;
		for(Person p: personList) {
			if(candidate == null || p.calculateNetWorth() > candidate.calculateNetWorth()) {
				candidate = p;
			}
		}
		return candidate;
	}

	public boolean createPerson(String name){
		if(findPerson(name) != null){
			return false;
			}
		Person p = new Person(name);
		personList.add(p);
		return true;
	}

	private void addItemToPerson(Item i, Person p) {
		p.addItem(i);
	}

	private Person findPerson(String name) {
		for(Person p : personList){
			if(p.getName().equalsIgnoreCase(name)){
				return p;
			}
		}
		return null;
	}

	public boolean createJewelry(String name, boolean gold, int numberOfGems, String personName){
		Person p = findPerson(personName);
		
		if(p == null){
			return false;
		}
		
		Jewelry j = new Jewelry(name, gold, numberOfGems);
		addItemToPerson(j, p);
		return true;
	}
	
	public boolean createStock(String name, int numberOf, int price, String personName){
		Person p = findPerson(personName);
		
		if(p == null){
			return false;
		}

		Stock s = new Stock(name, numberOf, price);
		addItemToPerson(s, p);
		return true;
	}
	
	public boolean createElectronicProduct(String name, int priceNew, int condition, String personName){
		Person p = findPerson(personName);
		
		if(p == null){
			return false;
		}

		ElectronicProduct e;
		try {
			e = new ElectronicProduct(name, priceNew, condition);
		} catch (IllegalArgumentException ex) {
			return false;
		}
		
		addItemToPerson(e, p);
		return true;
	}
	
}
