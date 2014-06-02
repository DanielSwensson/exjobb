import java.util.ArrayList;

public class AddTo {
	
	public static ArrayList<Person> all = new ArrayList<Person>();
	
	// Create a new Person object
	public void addPerson(String name) {
			Person p = new Person(name);
			all.add(p);
	}
		
	
	// Method for adding jewelry
	public void addJewelry(String name, String jewType, int matter, int numGem) {
		for(Person p : all) {
			Gadget g = new Jewelry(jewType, matter, numGem);
			if (p.getName().equalsIgnoreCase(name)) {
				p.personArray.add(g);
			}		
		}
	}

	// Method for adding share
	public void addShare(String name, String shareType, int rate, int amount) {
		for(Person p : all) {
			Gadget g = new Share(shareType, amount, rate);
			if (p.getName().equalsIgnoreCase(name)) {
				p.personArray.add(g);
			}		
		}
	}
	
	// Method for adding appliance
	public void addAppliance(String name, String applianceType, int costPrice, int wear) {
		for(Person p : all) {
			Gadget g = new Appliance(applianceType, costPrice, wear);
			if (p.getName().equalsIgnoreCase(name)) {
				p.personArray.add(g);
			}		
		}
	}
	
	// Method for setting all shares to rate 0
	public void stockMarketChrash() {
		for(Person p : all) {
			int i = 0;
			for(Gadget g : p.personArray) {
				if(g.getTypeName().equals("Aktie")) {
					Gadget share = new Share(g.getName(), g.getAmount(), 0);
					p.personArray.set(i, share);
				}
				i++;
			}
		}
	}
}
