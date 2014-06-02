
public class Stock extends Item
{
	private int amount;
	
	public Stock(String name, double value, int amount)
	{
		super(name, value);
		this.amount = amount;
	}

	@Override
	public double getValue()
	{
		double d = super.getValue();
		return d * amount;
	}
}
