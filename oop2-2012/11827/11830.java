import java.util.ArrayList;

public class Person {
	private String name;
	private ArrayList<Property> allProperty = new ArrayList<Property>();
	private int allValue = 0;
	
	public Person(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public ArrayList<Property> getAllProperty()
	{
		return allProperty;
	}
	
	public int calculateValue()
	{
		allValue = 0;
		for (Property propertyValue : allProperty)
		{
			allValue += propertyValue.value();
		}
		return allValue;
	}
	
	public void addProperty(Property newProperty)
	{
		allProperty.add(newProperty);
	}
	
	public void showTotal()
	{
		for (Property propertyList : allProperty)
		{
			System.out.println(propertyList);
		}
	}
	
	public String toString()
	{
		return name + " " + calculateValue();
	}
}
