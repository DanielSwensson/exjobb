
public class Jewellery extends Property
{
	private boolean gold = false;
	private int gems = 0;
	
	public Jewellery(String name, boolean gold, int gems)
	{
		super(name);
		this.gold = gold;
		this.gems = gems;
	}
	
	public int value()
	{
		if(gold)
		{
			return 2000 + (gems * 500);
		}
		else
		{
			return 700 + (gems * 500);
		}
	}
}