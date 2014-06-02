
public class Boat extends Vehicle
{
	
	
	
	public Boat(String brand, String colour, int buyingPrice, int sellingPrice)
	{
		
		super(brand, colour, buyingPrice, sellingPrice);
		
	}
	
	
	public String toString()
	{
		
		return "\tVechicle type: Boat" + super.toString();
		
	}
	
	

}
