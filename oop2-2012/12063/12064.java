package inlämning2;

public class Smycke extends Pryl
{
	private final int GULD = 2000;
	private final int SILVER = 700;
	private final int ADELSTEN = 500;
	private int varde;
	private int antalAdelsten;
	private int adelstenSumma;
	private int valorVarde;
	
	
	public Smycke(String prylNamn, String valor, int antalAdelsten)
	{
		super(prylNamn);
		this.antalAdelsten = antalAdelsten;
		
		adelstenSumma =  ADELSTEN * antalAdelsten;
		
		if (valor.equalsIgnoreCase("ja"))
		{
			valorVarde = GULD;
		} //if
		
		
		else if (valor.equalsIgnoreCase("nej"))
		{
			valorVarde = SILVER;
		} //else if		
		
		
		else
		{
			valorVarde = SILVER;
		} //else		
	}
	
	
	public int getVarde()
	{
		return varde = adelstenSumma + valorVarde;
	}
}
