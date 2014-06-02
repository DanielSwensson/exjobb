import java.io.*;

/**
 * @author Fredrika Ståhl, 2012-12-25
 */

public class Jewelery extends Valuable implements Serializable
{

	private static final long serialVersionUID = -2611781304901202345L;
	private String preciousMetal; 													// Ädelmetal, guld eller silver?
	private int numberOfStones;
	private int metalValue;
	
	public Jewelery(String jeweleryName, String preciousMetal, int numberOfStones)
	{
		setName(jeweleryName);														// Eftersom Jewelery extendar Valuable så sparar vi smycktes namn i superklassen Valuable.
		this.preciousMetal = preciousMetal;
		this.numberOfStones = numberOfStones;
	}
	
	public int getValue()
	{
		if( preciousMetal.equalsIgnoreCase("guld"))
			metalValue = 2000;
		else
			metalValue = 700;
		
		return(metalValue + numberOfStones * 500);
	}
}
