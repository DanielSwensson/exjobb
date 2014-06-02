import java.io.*;

/**
 * @author Fredrika St�hl, 2012-12-25
 */

public class Share extends Valuable implements Serializable
{

	private static final long serialVersionUID = -2611781304901202345L;
	private int numberOfShares;
	private int price;

	public Share(String shareName, int sharePrice, int numberOfShares) 
	{
		setName(shareName); 											// Eftersom Share extendar Valuable s� sparar vi aktiens namn i superklassen Valuable.
		this.numberOfShares = numberOfShares;
		price = sharePrice;
	}
	
	/*
	 * �ndrar en akties pris.
	 */
	public void setSharePrice(int sharePrice) 						
	{
		price = sharePrice;
	}
	
	public int getValue()
	{
		return getValue(numberOfShares, price);							
	}
}
