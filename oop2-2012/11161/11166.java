import java.io.Serializable;

public abstract class Thing implements Serializable{
	private static final long serialVersionUID = -5262899035200238915L;

	//Instance variables
	private String name;
	
	//Constructor
	public Thing(String startName) {
		name = startName;		
	}

	public String getName() {
		return name;
	}

	abstract int getValue();
		
	public void setCost(int i) {
		return;
	}
	
} //Class
