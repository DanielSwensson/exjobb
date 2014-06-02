
public class Jewelery extends Item
{
	private boolean gold;
	private int stones;
	
	public Jewelery(String name, boolean gold, int stones)
	{
		super(name);
		this.gold = gold;
		this.stones = stones;
	}
	@Override
	public double getValue()
	{
		return gold ? (2000 + (stones * 500)) : (700 + (stones * 500));
	}
}
