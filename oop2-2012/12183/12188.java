import java.util.ArrayList;
import java.io.*;

public class Person implements Serializable
{
	private ArrayList<Pryl> belongings;
	private String name;
	
	public Person (String name)
	{
		this.name = name;
		belongings = new ArrayList<Pryl>();
	}
					
	public String getName()
	{
		return name;
	}
	
	public void addToBelongings(Pryl a)
	{
		belongings.add(a);
	}

	public void prylMarketCrash()
	{
		for (Pryl a : belongings)
		{
			if (a instanceof Aktie)
			{
				((Aktie)a).marketCrash();
			}
		}
	}
	
	public ArrayList<Pryl> getBelongings()
	{
		return belongings;
	}
	
	public int getWealth()
	{
		int wealth = 0;
		for (Pryl a : belongings)
		{
			wealth += a.getValue();
		}
		return wealth;
	}
	
	public void deletePryl(Pryl a)
	{
		belongings.remove(a);
	}
	
	public String toString()
	{
		return name + ", vars totala förmögenhet är " + getWealth() + " kronor.";
	}
	
}
