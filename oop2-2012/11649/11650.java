
public class Apparatus extends Item
{
	private int wearing;
	
	public Apparatus(String name, double value, int wearing)
	{
		super(name, value);
		this.wearing = wearing;
	}

	@Override
	public double getValue()
	{
		return (super.getValue() * (wearing / 10.0));
	}
}