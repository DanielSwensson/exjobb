
public class Plane extends Vehicle
{
	
	
	
	public Plane(String brand, String colour, int buyingPrice, int sellingPrice)
	{
		
		super(brand, colour, buyingPrice, sellingPrice);
		
		
	}
	
	public String toString()
	{
		
		return "\tVechicle type: Plane" + super.toString();
		
	}
	
	
	
	

}
