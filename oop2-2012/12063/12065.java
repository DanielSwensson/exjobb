package inlämning2;

public class Aktie extends Pryl
{
	private int antalAktie;
	private double prisAktie;
	private int varde;
	
	
	public Aktie(String prylNamn,int antalAktie, double prisAktie) {
		super(prylNamn);
		this.antalAktie = antalAktie;
		this.prisAktie = prisAktie;
	}

	
	public int getVarde()
	{
		return varde = (int) (antalAktie * prisAktie);
	}

	
	public void getBorsKrasch()
	{
		prisAktie = 0;
	}
}
