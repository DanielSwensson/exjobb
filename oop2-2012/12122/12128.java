import java.io.Serializable;


public class Person implements Serializable {
	private String name;
	private int idNr;
	
	Person (String name) {
		this.idNr = Inlupp2.personList.size() + 1;
		if (personExists(name)) {
			this.name = name + this.idNr;
		}
		else this.name = name;
	}
	
	public int getIdNr() {
		return this.idNr;
	}
	
	public String getName() {
		return this.name;
	}
	
	public static boolean personExists(String name) {
		for(int x=0; x < Inlupp2.personList.size(); x ++) {
			if (Inlupp2.personList.get(x).getName().equalsIgnoreCase(name))
				return true; 
		}
		return false;
	}
	
	public double getItemsValue() {
		double totalValue = 0;
		for(int x=0; x < Inlupp2.itemList.size(); x ++) {
			if (Inlupp2.itemList.get(x).getOwner() == this) {
				totalValue += Inlupp2.itemList.get(x).getValue();
			}
		}
		return totalValue;
	}
	
	public static Person findPerson(String name) {
		for(int x=0; x < Inlupp2.personList.size(); x ++) {
			if (Inlupp2.personList.get(x).getName().equalsIgnoreCase(name)) return Inlupp2.personList.get(x); 
		}
		return null;
	}
	
	public static String findRichesPerson() {
		double personsValue = 0;
		double richesValue = 0;
		String richesPerson = "";
		for (int x=0; x < Inlupp2.personList.size(); x++) {		
			String[][] personsItems = Person.personsItem(Inlupp2.personList.get(x).getName());
			for (int y=0; y < personsItems.length; y++) {
				personsValue += Double.parseDouble(personsItems[y][3]);
			}
			if (personsValue > richesValue) {
				richesValue = personsValue;
				richesPerson = Inlupp2.personList.get(x).getName();
			}
			personsValue = 0;
		}
		return richesPerson;
	}
	
	public static String[][] personsItem(String person) {
		int itemIdNr;
		String itemName;
		String itemType = null;
		String itemValue;
		Person personObj = (Person) Person.findPerson(person);
		int count = 0;
		int arrSize = 0;
		for (int x=0; x < Inlupp2.itemList.size(); x ++) {
			if (Inlupp2.itemList.get(x).getOwner().equals(personObj)) {
				arrSize ++;
			}
		}
		String tempArr[][] = new String[arrSize][];
		for (int x=0; x < Inlupp2.itemList.size(); x ++) {
			if (Inlupp2.itemList.get(x).getOwner().equals(personObj)) {
				itemIdNr = Inlupp2.itemList.get(x).getIdNr();
				itemName = Inlupp2.itemList.get(x).getName();
				if (Inlupp2.itemList.get(x) instanceof Jewelery) itemType = "Jeweleery";
				else if (Inlupp2.itemList.get(x) instanceof Share) itemType = "Share";
				else if (Inlupp2.itemList.get(x) instanceof Appliance) itemType = "Appliance";
				itemValue = "" + Inlupp2.itemList.get(x).getValue();
				String[] rowArr = new String[4];
				
				rowArr[0] = "" + itemIdNr;
				rowArr[1] = itemName;
				rowArr[2] = itemType;
				rowArr[3] = itemValue;
				tempArr[count] = rowArr;
				count ++;
			}
		}
		return tempArr;
	}
}
