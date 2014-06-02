
public class Car extends Vehicle	
{
	
	
	
	public Car(String brand, String colour, int buyingPrice, int sellingPrice)
	{
		
		super(brand, colour, buyingPrice, sellingPrice);
		
		
	}
	
	public String toString()
	{
		
		return  "\tVechicle type: Car " + super.toString();
		
	}
	
	
}
