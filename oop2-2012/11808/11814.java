class Smycke extends Pryl

{
	private boolean ärDetGuld;
	private int antalStenar;
	private int värde;
	
	public Smycke (String namn, boolean Guld, int stones)
	{
		super(namn);
		ärDetGuld = Guld;
		antalStenar = stones;
	}
	
	public boolean getGuld()
	{
		return ärDetGuld;
	}
	
	public int getAntalStenar()
	{
	return antalStenar;
	}		
	
	public double getVärde()
	{
		
		if (ärDetGuld)
			värde = 2000;
		else
			värde = 700;
		
		värde+= antalStenar * 500;
		
		
		return värde;
	}
	public String toString()
	{
		return prylNamn + "\t" + getVärde() + "\n"; 
	}


}
