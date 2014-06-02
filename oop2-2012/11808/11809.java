class Aktie extends Pryl
{
	private int antal;
	private double pris;
	private double värde;

	public Aktie (String namn, int antalet, double priset)
	{
		super (namn);
		antal = antalet;
		pris=priset;
	}
	
	public void setVärde(double priset)
	{
	this.pris = priset;
	}
	
	public double getVärde()
	{
	
	värde = antal * pris;
	
	return värde;
	}
	
	public String toString()
	{
		return prylNamn +  "\t" + getVärde() + "\n";
	}

}
