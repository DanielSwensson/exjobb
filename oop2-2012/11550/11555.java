import java.io.Serializable;

public abstract class Gadget implements Serializable{
	
	private String name;
	private String typeName;
	
	public Gadget(String name, String typeName) {
		this.typeName = typeName;
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public String getTypeName() {
		return typeName;
	}
	
	public int getAmount() {
		return 1;
	}
	
	public int getValue() {
		return 0;
	}
	
	public String toString() {
		return name + " Šr en " + typeName;
	}
}
