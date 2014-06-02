import java.io.Serializable;
import java.util.ArrayList;


public class Person implements Serializable
{
	private String name;
	
	private ArrayList<Item> items = new ArrayList<Item>();
	
	public Person(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	public void addItem(Item i)
	{
		items.add(i);
	}
	public String getAllItemsInfo(boolean showNumber)
	{
		String text = "";
		String number = "";
		for(int i = 0; i < items.size(); i++)
		{
			number = "";
			if(showNumber)
			{
				number = "" + (i + 1) + ": ";
			}
			text += number + items.get(i).getName() + "\t\t" + items.get(i).getValue() + "\n";
		}
		return text;
	}
	public ArrayList<Item> getAllItems()
	{
		return items;
	}
	public double getTotalValue()
	{
		double totalValue = 0;
		for(Item i: items)
		{
			totalValue += i.getValue();
		}
		return totalValue;
	}
}
