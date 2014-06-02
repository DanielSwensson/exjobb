class Smycke extends Pryl

{
	private boolean �rDetGuld;
	private int antalStenar;
	private int v�rde;
	
	public Smycke (String namn, boolean Guld, int stones)
	{
		super(namn);
		�rDetGuld = Guld;
		antalStenar = stones;
	}
	
	public boolean getGuld()
	{
		return �rDetGuld;
	}
	
	public int getAntalStenar()
	{
	return antalStenar;
	}		
	
	public double getV�rde()
	{
		
		if (�rDetGuld)
			v�rde = 2000;
		else
			v�rde = 700;
		
		v�rde+= antalStenar * 500;
		
		
		return v�rde;
	}
	public String toString()
	{
		return prylNamn + "\t" + getV�rde() + "\n"; 
	}


}
