import java.util.*;
public class Person implements Comparable<Person>  {

	private String name;
	public String getInfo() {
String grej="";

	grej +="Namn: " + this.name + "\n"; 
	grej +="-------" + "\n";
		for(int i=0;i<getValuables().size();i++){

			grej += getValuables().get(i).getClass().getName()+ ": " +  valuables.get(i).getName() + "\n";

			grej +="Värdet: " + valuables.get(i).getValue() + " kr" + "\n";

			grej +="-------" + "\n";
			 
		}
		return grej;
		
	}



	// Matar in stringen name i systemet för senare användning 

	private ArrayList<Varden> valuables = new ArrayList<Varden>();
	// Använder arraylist för att kunna göra en lista o referera till den via en integer 

	public void setName(String name) {
		this.name = name; 
	}
	public void addVarden(Varden varden) {
		valuables.add(varden);
		// Läger till värden i systemet som kommer användas senare 
	}

	public ArrayList<Varden> getValuables() {
		return this.valuables;
	}

	public String getName() {
		return this.name;
	}
	public float getTotalWelth() {
		float welth = 0.0f;
		// Används för att bestämma det totala värdet av värdena 

		for(Varden varden : valuables)
			welth += varden.getValue();

		return welth;
	}

	public int compareTo(Person obj) {
		Person tmp = (Person)obj;
		//Jämföra olika personer 
		if(this.getTotalWelth() > tmp.getTotalWelth()) {
			return -1;
		} else if(this.getTotalWelth() < tmp.getTotalWelth()) {
			return 1;
		} else {
			return 0;

		}

	}
	public String toString() {
		return this.name +  "\t" + this.getTotalWelth();
	}//namn på person samt totala värdet av produkterna 
}


