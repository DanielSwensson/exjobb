class Aktie extends Pryl
{
	private int antal;
	private double pris;
	private double v�rde;

	public Aktie (String namn, int antalet, double priset)
	{
		super (namn);
		antal = antalet;
		pris=priset;
	}
	
	public void setV�rde(double priset)
	{
	this.pris = priset;
	}
	
	public double getV�rde()
	{
	
	v�rde = antal * pris;
	
	return v�rde;
	}
	
	public String toString()
	{
		return prylNamn +  "\t" + getV�rde() + "\n";
	}

}
