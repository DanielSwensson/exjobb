
public abstract class Vehicle 
{
	
	private String brand;
	private String colour;
	private int buyingPrice;
	private int sellingPrice;
	
	public Vehicle(String brand, String colour, int buyingPrice, int sellingPrice)
	{
		
		this.brand = brand;
		this.colour = colour;
		this.buyingPrice = buyingPrice;
		this.sellingPrice = sellingPrice;
		
	}
	
	public String getBrand()
	{
		
		return brand;
		
	}
	
	public String getColour()
	{
		
		return colour;
		
	}
	
	public int getBuyingPrice()
	{
		
		return buyingPrice;
		
	}
	
	public int getSellingPrice()
	{
		
		return sellingPrice;
		
	}
	
	public String toString()
	{
		
		return "	Brand: " + brand + "	Colour: " + colour + "	Price: " + buyingPrice + "	Sell price: " + sellingPrice;
		
	}

}
