package inl�mning2;

abstract public class Pryl 
{	
	private String prylNamn;
	
	
	public Pryl(String prylNamn)
	{
		this.prylNamn = prylNamn;	
	}
	

	//---------
	//Pryl Namn
	//---------
	
	public String getPrylNamn()
	{
		return prylNamn;
	}
	
	
	//----------
	//Pryl V�rde
	//----------
	
	abstract public int getVarde();
	
	
	//--------
	//Utskrift
	//--------
	
	public String toString()
	{
		return "   " + getPrylNamn() + "\t" + getVarde();
	}
}
