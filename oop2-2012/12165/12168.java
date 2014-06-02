
public class Currency 
{
	private String currencyName;
	private double currencyRatio;
	
//______________________________________________________________________________________________________________	
	Currency()
	{
		currencyName = null;
		currencyRatio = 0;
	}
//______________________________________________________________________________________________________________	
	Currency(String currencyName, double currencyRatio)
	{
		this.currencyName = currencyName;
		this.currencyRatio = currencyRatio;
	}
	
//______________________________________________________________________________________________________________		
	public String getCurrencyName()
	{
		return currencyName;
	}
	
//______________________________________________________________________________________________________________
	public double getCurrencyRatio()
	{
		return currencyRatio;
	}
	
//______________________________________________________________________________________________________________	
	public String setCurrency(String newCurrencyName)
	{
		currencyName = newCurrencyName;
		return currencyName;
	}
				
//______________________________________________________________________________________________________________
	public String toString()
	{		
		return "Valuta: " + currencyName + "\n" 
				+ "Värderatio (i förhållande till systemets defaultvaluta): " + currencyRatio + "\n";
	}
	
//______________________________________________________________________________________________________________
}
