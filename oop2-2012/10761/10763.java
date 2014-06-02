import java.util.ArrayList;

public class Person {
	private String name;
	private ArrayList<Valuable> valuables = new ArrayList<Valuable>();
	
	Person (String Name) {
		name=Name;
	}

	Person () {
		//case only used for test, invoke with no argument to generate a Torsten Testare, or TT for short object
		name="TT";
		Valuable stuff = new Stock("test AB",11,11);
		valuables.add(stuff);
		stuff = new Jewelry("testRing",true,11);
		valuables.add(stuff);
		stuff = new Device("TestTV", 11,9);
		valuables.add(stuff);
	}

	public String getName(){
		return name;
	}
	
	public ArrayList<Valuable>  getValuables(){
		return valuables;
	}

	public int getWelth(){
		int sum=0;
		for (Valuable valuable : valuables) {
			sum+=valuable.getValue() ;
		}
		return sum;
	}

	public void addValuable(Valuable valuable) {
		this.valuables.add(valuable);
	}
	
	public String toString(){
		return "name:"+name + "  welth:"+getWelth();
	}
}
