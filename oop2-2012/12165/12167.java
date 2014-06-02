
public class BlockOfShares extends Valuable
{
	private int numberOfShares;
	private double pricePerShare;
	private double value;
	
//______________________________________________________________________________________________________________
	BlockOfShares(String valuableName, int valuableID, Currency currency, Owner owner, 
			int numberOfShares, double pricePerShare)
	{
		super(valuableName, valuableID, currency, owner);
		this.numberOfShares = numberOfShares;
		this.pricePerShare = pricePerShare*currency.getCurrencyRatio();
		value = numberOfShares*pricePerShare;
	}

//______________________________________________________________________________________________________________
	public void editNumberOfShares(int addedNumberOfShares)
	{
		numberOfShares += addedNumberOfShares;
		value = numberOfShares*pricePerShare;
		String typeOfChange = null;
		
		if (addedNumberOfShares >= 0)
		{	
			typeOfChange = "ökat";
		}
		else
		{
			typeOfChange = "minskat";
		}
		
		System.out.println("Du har nu " +  typeOfChange + " antalet aktier i " + getValuableName() 
				+ " med " + Math.abs(addedNumberOfShares) + ".\n"		
				+ "Totalt antal aktier i aktieposten efter ändringen: " 
				+ numberOfShares + "\n"
				+ "Aktuellt värde på aktieposten " + getValuableName() + ": "
				+ value + " " + super.getCurrencyName() + "\n");
	}	
	
//______________________________________________________________________________________________________________
	public double getValue()
	{
		return value;
	}

//______________________________________________________________________________________________________________
	public void setPricePerShare(double pricePerShare)
	{
		this.pricePerShare = pricePerShare;
		value = numberOfShares*pricePerShare;
	}

//______________________________________________________________________________________________________________
	public String toString()
	{
		return "Värdeföremålets namn: " + getValuableName() + "\n"
				+ "Typ av värdesak: aktiepost" + "\n"
				+ "Antal aktier: " + numberOfShares + "\n"
				+ "Aktuell kurs: " + pricePerShare + " " + getCurrencyName() + "\n"
				+ "Sammanlagt värde: " + value + " " + getCurrencyName() + "\n"
				+ "Värdeföremåls-ID: " + getValuableID() + "\n"
				+ "Ägare: " + super.getOwnerName() + ",  ägar-ID" + super.getOwnerID() + "\n";
	}
	
//______________________________________________________________________________________________________________

}
