
public class Stock extends Property
{
	private int price;
	private int number;
	
	public Stock(String name, int price, int number)
	{
		super(name);
		this.price = price;
		this.number = number;
	}
	
	public void setPrice(int newPrice)
	{
		price = newPrice;
	}
	
	public int value()
	{
		return  number * price;
	}
}
