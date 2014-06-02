
public class List {
	
		// List all persons
			public void listAllPerson() {
				boolean empty = true;
				for(Person p : AddTo.all) {
					System.out.println(p.getName() + "     " + p.getTotalValue());
					empty = false;
				}
				if (empty) {
					System.out.println("Tyvärr, listan innehåller inga personer.");
				}
			}
	
		// List all persons in a numeric list
		public int listAllPerson(int numList) {
			boolean empty = true;
			int i = 1;
			for(Person p : AddTo.all) {
				System.out.println(i + ".   " + p.getName() + "     " + p.getTotalValue());
				empty = false;
				i++;
			}
			if (empty) {
				System.out.println("Tyvärr, listan innehåller inga personer.");
			}
			return AddTo.all.size();
		}
		
		// List person with the largest value. Returns an Array with name and totalValue		
		public String[] listPersonMostValue() {
			String name = null;
			int totValue = 0;
			for(Person p : AddTo.all) {
				if(totValue <= p.getTotalValue()) {
					totValue = p.getTotalValue();
					name = p.getName();
				}
			}
			String[] returnMostValue = {name, "" + totValue};
			return returnMostValue;
			
		}
		
		// List one persons all gadgets
		public void listPersonGadget(String name) {
			for(Person p : AddTo.all) {
				if(p.getName().equalsIgnoreCase(name)) {
					p.getGadgetList();
				}
			}
		}
		
		// List one persons all gadgets in a numeric list
				public Gadget[] listPersonGadget(String name, int numList) {
					Gadget[] stuffArray = null;
					for(Person p : AddTo.all) {
						if(p.getName().equalsIgnoreCase(name)) {
							stuffArray = p.getGadgetList(1);
						}												
					}
					return stuffArray;
				}
}
