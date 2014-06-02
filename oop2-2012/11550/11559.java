import java.util.ArrayList;
import java.io.Serializable;

public class Person implements Serializable{

	private String name;
	protected ArrayList<Gadget> personArray = new ArrayList<Gadget>();
	
	public Person(String name) {				
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void getNamePrint() {
		System.out.println(name);
	}
	
	// Method for listing a persons gadgets, printing the result
	public void getGadgetList() {
		for (Gadget g : personArray) {
			System.out.println(g.getTypeName() + "    " + g.getName() + "    " + g.getValue());
		}
	}
	
	// Method for listing a persons gadgets, returning an array
	public Gadget[] getGadgetList(int array) {
		int k = personArray.size();
		Gadget[] stuff = new Gadget[k];
		int i = 0;
		for (Gadget g : personArray) {
			stuff[i] = g;
			i++;
		}	
		return stuff;
	}
	
	public int getTotalValue() {
		int totalValue = 0;
		for (Gadget g : personArray) {
			totalValue += g.getValue(); 
		}
		return totalValue;
	}
	
	public String toString() {
		return "Personen heter " + name;
	}
}
