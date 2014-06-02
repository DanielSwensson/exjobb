import java.io.*;

/**
 * @author Fredrika Ståhl, 2012-12-25
 */

public class Appliance extends Valuable implements Serializable
{
	private static final long serialVersionUID = -2611781304901202345L;
	private int retailPrice;
	private int wear; 																	// 1-10 där 10 är nyskick. 
	
	public Appliance(String applianceName , int applianceWear, int applianceRetailPrice)
	{
		setName(applianceName);															// Eftersom Appliance extendar Valuable så sparar vi apparatens namn i superklassen Valuable.
		wear = applianceWear;
		retailPrice = applianceRetailPrice;
	}

	public int getValue()
	{
		return(retailPrice * wear / 10);
	}
}
