
public class Device extends Property
{
	private double price;
	private double wear;
	
	public Device(String name, double price, double wear)
	{
		super(name);
		this.price = price;
		this.wear = wear;
	}
	
	public int value()
	{
		return (int)(price * (wear/10));
	}
}
