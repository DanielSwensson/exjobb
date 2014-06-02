
public class Bling extends Valuable
{
	private String material;
	private int stones;
	private double value;

//______________________________________________________________________________________________________________
	Bling (String valuableName, int valuableID, Currency currency, Owner owner, 
			String material, int stones)
	{
		super(valuableName, valuableID, currency, owner);
		this.material = material;
		this.stones = stones;
		
		if (material.equalsIgnoreCase("guld"))
		{
			value = (double) (2000+getStones()*500);
		}
		
		else if (material.equalsIgnoreCase("silver"))
		{
			value = (double) (700+getStones()*500);
		}
	}

//______________________________________________________________________________________________________________
	public String getMaterial()
	{
		return material;
	}
	
//______________________________________________________________________________________________________________
	public int getStones()
	{
		return stones;
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
				+ "Typ av värdesak: smycke" + "\n" 
				+ "Material: " + material + "\n"
				+ "Antal stenar: " + stones + "\n"
				+ "Sammanlagt värde: " + value/super.getCurrencyRatio() + " " 
				+ super.getCurrencyName() + "\n"
				+ "Värdeföremåls-ID: " + getValuableID() + "\n"
				+ "Ägare: " + super.getOwnerName() + ", ägar-ID " + super.getOwnerID() + "\n";
	}
	
//______________________________________________________________________________________________________________
}

