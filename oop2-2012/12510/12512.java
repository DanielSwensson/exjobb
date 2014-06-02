import java.io.Serializable;

// Class declaration
public abstract class Item implements Serializable{
	
	// Randomly generated serialVersionUID
	private static final long serialVersionUID = -3280745744799488317L;
	
	// Attributes
	protected String name;
	protected double value;
	
	protected abstract void calcValue();

	
	public String getName(){
		return name;
	}
	
	public double getValue(){
		return value;
	}
}
