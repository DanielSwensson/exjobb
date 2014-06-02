package inlämning2;

public class Apparat extends Pryl
{
	private int inkopspris;
	private int slitage;
	private int varde;
	
	
	public Apparat(String prylNamn, int inkopspris, int slitage) {
		super(prylNamn);
		this.inkopspris = inkopspris;
		this.slitage = slitage;
	}

	
	public int getVarde()
	{
		return varde = inkopspris * slitage / 10;
	}
}
