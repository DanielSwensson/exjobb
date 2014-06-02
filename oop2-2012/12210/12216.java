import java.io.*;

/**
 * @author Fredrika Ståhl, 2012-12-25
 */
public class Valuable implements Serializable
{

	private static final long serialVersionUID = -2611781304901202345L;
	private String name;
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getValue(int numberOf, int unitPrice)
	{
		return(numberOf * unitPrice);
	}
	
	public String getName()
	{
		return name;
	}
}
