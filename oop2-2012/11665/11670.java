import java.io.Serializable;

abstract public class Thing implements Serializable {
	private String name;

	public Thing(String n){
		name = n;
	}

	public String getName(){
		return name;
	}
	
	abstract public int getValue();
}
