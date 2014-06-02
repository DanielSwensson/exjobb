
public abstract class Property
{
	private String name;
	abstract int value();
	
	public Property(String name)
	{
		this.name = name;
	}
	
	public void setName(String s)
	{
		name = s;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String toString()
	{
		return "   " + getName() + " " + value();
	}
}
