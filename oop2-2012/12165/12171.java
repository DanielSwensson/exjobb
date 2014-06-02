
public abstract class Valuable 
{
	private String valuableName;
	private int valuableID;
	private Currency currency;
	private Owner owner;
	abstract public double getValue();
	abstract public String toString();
	
//______________________________________________________________________________________________________________
	Valuable (String valuableName, int valuableID, Currency currency, Owner owner) 
	{
		this.valuableName = valuableName;
		this.valuableID = valuableID;
		this.currency = currency;
		this.owner = owner;
	}

//______________________________________________________________________________________________________________			
	public String getCurrencyName()
	{
		return currency.getCurrencyName();
	}	
	
//______________________________________________________________________________________________________________
	public double getCurrencyRatio()
	{
		return currency.getCurrencyRatio();	
	}
	
//______________________________________________________________________________________________________________
	public Owner getOwner()
	{
		return owner;
	}

//______________________________________________________________________________________________________________
	public int getOwnerID()
	{
		return owner.getOwnerID();
	}
		
//______________________________________________________________________________________________________________
	public String getOwnerName()
	{
		return owner.getOwnerName();
	}

//______________________________________________________________________________________________________________	
	public int getValuableID()
	{
		return valuableID;
	}

//______________________________________________________________________________________________________________	
	public String getValuableName()
	{
		return valuableName;
	}

//______________________________________________________________________________________________________________		
	//Method for changing the valuables's currency (not used in the current version of the program):
	public void setCurrency(Currency currency)
	{
		this.currency = currency;
	}
	
//______________________________________________________________________________________________________________

}	

