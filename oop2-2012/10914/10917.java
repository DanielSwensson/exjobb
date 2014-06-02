import java.io.Serializable;

public abstract class Item implements Serializable {

	private String name;
	
	public Item(String name) {
		this.name = name;
	}
	
	public Item() {
		this(null);
	}
	
	public String getName() {
		return name;
	}
	
	public String toString(){
		return name + "\t" + getValue();
	}
	
	public abstract double getValue();
	
}
