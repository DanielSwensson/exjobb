
abstract public class Pryl {

	protected String prylNamn ="";
	abstract public double getV�rde();
	
	public Pryl(String namn)
	{
		prylNamn = namn;
	}
	
	public String getNamn ()
	{
		return prylNamn;
	}
}