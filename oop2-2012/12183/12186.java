import java.io.*;

public class Apparat extends Pryl implements Serializable
{
	private int purchasePrice;
	private int condition;
	
	public Apparat (String name, int purchasePrice, int condition)
	{
		super(name);
		this.purchasePrice = purchasePrice;
		this.condition = condition;
	}
	
	public int getValue()
	{
		return (condition*purchasePrice)/10;
	}
}
