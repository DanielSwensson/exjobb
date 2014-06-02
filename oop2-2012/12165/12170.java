
public class TechnicalDevice extends Valuable 
{
	private double purchasePrice;
	private int condition;
	private double value;

//______________________________________________________________________________________________________________
	TechnicalDevice (String valuableName, int valuableID, Currency currency, Owner owner,
			double purchasePrice, int condition)
	{
		super(valuableName, valuableID, currency, owner);
		this.purchasePrice = purchasePrice*currency.getCurrencyRatio();
		this.condition = condition;
		value = purchasePrice*condition/10;
	}
	
//______________________________________________________________________________________________________________	
	public double getValue()
	{
		return value;
	}
	
//______________________________________________________________________________________________________________
	public String toString()
	{
		return "Värdeföremålets namn: " + getValuableName() + "\n"
				+ "Typ av värdesak: teknikprodukt \n"
				+ "Inköpspris: " + purchasePrice + " " + super.getCurrencyName() + "\n" 
				+ "Skick: " + condition + "/10 \n"
				+ "Sammanlagt värde: " + value + " " + super.getCurrencyName() + "\n"
				+ "Värdeföremåls-ID: " + getValuableID() + "\n"
				+ "Ägare: " + super.getOwnerName() + ", ägar-ID " + super.getOwnerID() + "\n";
	}
	
//______________________________________________________________________________________________________________
}
