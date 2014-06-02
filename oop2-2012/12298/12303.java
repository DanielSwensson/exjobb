package inlupp2;

public abstract class Pryl {

	/* ----------- Attributes ----------- */
	private String name; // prylar har ett namn/typ

	
	/* ----------- Construktor ----------- */
	public Pryl(String name) {
		this.name = name;
	}

	
	/* ----------- Methods ----------- */
	public String getName() {
		return name;
	}

	public abstract double getValue(); // prylar har ett värde

	public String toString() {
		return name + ": " + getValue() + " kronor\n";
	}
}