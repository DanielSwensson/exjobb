import java.util.*;

public class Person {

	private String name;
	private ArrayList<Valuable> valuableRegister = new ArrayList<Valuable>();
	
	public Person(String name) {
	
		this.name = name;
	}
	
	public void addValuable(Valuable valuable) {
		
		this.valuableRegister.add(valuable);
		
	}
	
	public ArrayList<Valuable> getValuables() {
		
		return valuableRegister;
	
	}
	
	public String getName() {
		
		return name;
	}	
	

	public int getsumOfValuables() {
		int sum = 0;
		
		for (Valuable current : valuableRegister)
			sum += current.value();
		
		return sum;
	
	}
}