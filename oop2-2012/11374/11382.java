
public abstract class Valuable {

	private String name;
	
	
	public Valuable(String name) {
		this.name=name;
	}
	
	public abstract double value();
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return "Owns (type of Valuable): " + name + ". "  ;
	}
	
}
