
public abstract class Thing {

	private String name;

	public Thing(String name) {
		this.name = name;
	}

	public abstract double getValue();

	public String toString() {
		return name + "\t" + getValue() + "\n";
	}

}