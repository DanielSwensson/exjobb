import java.io.Serializable;


public abstract class Item implements Serializable
{
	private String name;
	private double baseValue;
	
	public Item(String name)
	{
		this.name = name;
	}
	public Item(String name, double value)
	{
		this.name = name;
		this.baseValue = value;
	}
	public String getName()
	{
		return name;
	}
	public void setBaseValue(double newValue)
	{
		baseValue = newValue;
	}
	public double getValue()
	{
		return baseValue;
	}
}
