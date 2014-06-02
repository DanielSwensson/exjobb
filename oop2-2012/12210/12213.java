import java.io.*;
import java.util.ArrayList;

/**
 * @author Fredrika St�hl, 2012-12-25
 */

public class Person implements Serializable
{

	private static final long serialVersionUID = -2611781304901202345L;
	private String name; 
	private ArrayList<Valuable> bank = new ArrayList<Valuable>();					// En lista d�r man sparar undan alla v�rdesaker tillh�randes en person.
	private int wealth = 0;
	private Valuable valuable;
	private int valueOfValuable = 0;												// En ensklids v�rdesaks v�rde.
	
	public Person(String name) 
	{
		this.name = name;
	}
	
	public void setValuable(Valuable valuable)
	{
		bank.add(valuable);
	}
	
	public String getName()
	{
		return name;
	}


	public int getTotalWealth()
	{
		for(int i = 0; i < bank.size(); i++)
		{
			valuable = bank.get(i);
			if(valuable instanceof Share)
			{
				valueOfValuable = ((Share)valuable).getValue();
			}
			else if(valuable instanceof Jewelery)
			{
				valueOfValuable = ((Jewelery)valuable).getValue();
			}
			else if(valuable instanceof Appliance)
			{
				valueOfValuable = ((Appliance)valuable).getValue();
			}
			wealth = wealth + valueOfValuable;

		}
		return wealth;
	}
	
	public ArrayList<Valuable> getBank()
	{
		return bank;
	}
	
	/*
	 * Metod f�r att nollst�lla priset hos alla aktier i alla personer olika banker f�r v�rdesaker. 
	 */
	public void resetAllShares()
	{
		for(int i = 0; i < bank.size(); i++)
		{
			valuable = bank.get(i);
			if(valuable instanceof Share)
			{
				((Share)valuable).setSharePrice(0);
			}
		}
	}
	
	/*
	 * Metod f�r att g�ra det m�jligt f�r anv�ndare att �ndra en akties pris. 
	 */
	public void setSharePrice(String shareName, int sharePrice)
	{
		for(int i = 0; i < bank.size(); i++)
		{
			valuable = bank.get(i);
			if( (valuable instanceof Share) && (((valuable.getName()).toLowerCase() ).equals(shareName.toLowerCase())) )
			{
				((Share)valuable).setSharePrice(sharePrice);
			}
		}
	}
}
