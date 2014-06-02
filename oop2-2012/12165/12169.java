import java.util.ArrayList;

public class Owner 
{
	private String ownerName;
	private int ownerID;
	private long nationalIdentityNumber;
	private ArrayList<Valuable> ownerAllValuables = new ArrayList<Valuable>();
	private Currency systemCurrency;
	
//______________________________________________________________________________________________________________
	Owner(String ownerName, long nationalIdentityNumber, int ownerID)
	{
		this.ownerName = ownerName;
		this.ownerID = ownerID;
		this.nationalIdentityNumber = nationalIdentityNumber;
	}
	
//______________________________________________________________________________________________________________
	Owner()
	{
		ownerName = null;
		ownerID = 0;
		nationalIdentityNumber = 0L;
	}
	
//______________________________________________________________________________________________________________	
	public int getOwnerID()
	{
		return ownerID;
	}
	
//______________________________________________________________________________________________________________
	public String getOwnerName()
	{
		return ownerName;
	}
	
//______________________________________________________________________________________________________________	
	public long getNationalIdentityNumber()
	{
		return nationalIdentityNumber;
	}
	
//______________________________________________________________________________________________________________	
	public void addValuable(Valuable valuable)
	{
		ownerAllValuables.add(valuable);
	}
	
//______________________________________________________________________________________________________________
	public String getOwnerTotalValue()
	{
		double ownerTotalValue = 0;
		
		for (Valuable valuable : ownerAllValuables)
		{
			ownerTotalValue += valuable.getValue();
		}
		
		return ("Det sammanlagda värdet för samtliga värdesaker som " 
				+ ownerName + "för närvarande äger är " + ownerTotalValue + " " 
				+ systemCurrency.getCurrencyName() + ".");
	}
	
//______________________________________________________________________________________________________________
	public void listOwnerAllValuables()
	{
		if (ownerAllValuables.size() == 0)
		{
			System.out.println("Det finns inga värdemål registrerade på ägaren.\n");
		}
		else
		{
			System.out.println("Följande värdeföremål finns registrerade på ägaren:\n");
			
			for (Valuable valuable : ownerAllValuables)
			{
				System.out.println(valuable.toString() + "\n");
			}
		}		
	}
	
//______________________________________________________________________________________________________________
	public String toString()
	{
		return "Ägarens namn: " + ownerName + "\n"
				+ "Personnummer: " + nationalIdentityNumber + "\n"
				+ "Ägar-ID: " + ownerID + "\n"
				+ "Förmögenhet: " + getWealth() + "\n";
	}

//______________________________________________________________________________________________________________	
	public double getWealth()
	{
		double wealth = 0;
		
		for (Valuable valuable : ownerAllValuables)
		{
			wealth += valuable.getValue();
		}
		
		return wealth;
	}

//______________________________________________________________________________________________________________
	public String crashOwnerStockMarket()
	{
		for (Valuable valuable : ownerAllValuables)
		{
			if (valuable instanceof BlockOfShares)
			{	
				((BlockOfShares)valuable).setPricePerShare(0);
			}
		}
		
		return "Priset på alla aktier tillhörande " + getOwnerName() + " har nu nollställts.\n";		
	}
	
//______________________________________________________________________________________________________________
	public void removeValuable(Valuable valuable)
	{
		ownerAllValuables.remove(valuable);
	}
	
//______________________________________________________________________________________________________________
	public void clearAllValuables()
	{
		ownerAllValuables.clear();
	}
	
//______________________________________________________________________________________________________________
}