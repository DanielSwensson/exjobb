
public class Remove {
	
	private List li = new List();
	
	// Method for removing a person with ArrayList index number
	public void removePerson(int numPerson) {
		AddTo.all.remove(numPerson-1);
	}
	
	// Method for removing a person by name
	public void removePerson(String name) {
		int i = 0;
		int j = -1;
		for(Person p : AddTo.all) {
			if(p.getName().equalsIgnoreCase(name)) {
				j = i;
			}
			i++;
		}
		if(j > -1) {
			AddTo.all.remove(j);
		}
	}
	
	// Method for removing a specific gadget
	public void removeGadget(int gadget, String name) {
		
		for(Person p : AddTo.all) {
			if(p.getName().equalsIgnoreCase(name)) {
				p.personArray.remove(gadget-1);
			}												
		}
	}
	
}
