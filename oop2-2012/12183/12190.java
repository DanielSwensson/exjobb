import java.io.*;

public class Smycke extends Pryl implements Serializable
{
	private String goldOrSilver;
	private int gems;
	
	public Smycke (String name, String goldOrSilver, int gems)
	{
		super(name);
		this.goldOrSilver = goldOrSilver;
		this.gems = gems;
	}
	
	public int getValue()
	{
		if (goldOrSilver.equalsIgnoreCase("guld"))
			return 2000 + (500*gems);
		
		return 700 + (500*gems);
	}
}
