
import java.io.*;

public class Aktie extends Pryl implements Serializable
{
	private int amount;
	private int pricePerShare;
	
	public Aktie (String name, int amount, int pricePerShare)
	{
		super(name);
		this.amount = amount;
		this.pricePerShare = pricePerShare;
	}
	
	public void marketCrash()
	{
		this.pricePerShare = 0;
	}
	
	public int getValue()
	{
		return amount*pricePerShare;
	}
}
