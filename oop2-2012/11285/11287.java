import java.io.*;

public abstract class Item implements Serializable{
	protected int value;
	protected String name;
	
	abstract public int getValue();
	
	public String toString(){
		return (name+"               "+value);
	}
	
}
