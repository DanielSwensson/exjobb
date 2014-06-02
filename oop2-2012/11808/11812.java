
abstract public class Pryl {

	protected String prylNamn ="";
	abstract public double getVärde();
	
	public Pryl(String namn)
	{
		prylNamn = namn;
	}
	
	public String getNamn ()
	{
		return prylNamn;
	}
}