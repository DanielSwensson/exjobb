class Apparat extends Pryl
{
	private double inköpsPris;
	private int slitage;
	
	
	public Apparat (String namn, double priset, int slitaget)
	{
		super (namn);
		inköpsPris=priset;
		slitage=slitaget;
	}
	
	public double getVärde()
	{
		double value;
		value = inköpsPris * slitage * 0.1;		
		return value;
				
	}
	public String toString()
	{
		return prylNamn  + "\t"+ getVärde();
	}



}
