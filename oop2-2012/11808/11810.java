class Apparat extends Pryl
{
	private double ink�psPris;
	private int slitage;
	
	
	public Apparat (String namn, double priset, int slitaget)
	{
		super (namn);
		ink�psPris=priset;
		slitage=slitaget;
	}
	
	public double getV�rde()
	{
		double value;
		value = ink�psPris * slitage * 0.1;		
		return value;
				
	}
	public String toString()
	{
		return prylNamn  + "\t"+ getV�rde();
	}



}
