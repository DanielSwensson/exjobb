import java.io.*;

abstract public class Pryl implements Serializable
{
	public String name;
	
	public Pryl (String name)
	{
		this.name = name;
	}
	
	abstract public int getValue();
	
	public String getName()
	{
		return name;
	}
	
	public String toString()
	{
		return name + ", värde " + getValue() + " kronor.";
	}
}
