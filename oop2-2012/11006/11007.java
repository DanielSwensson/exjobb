
public class Aktie extends Pryl{

	private int antal;
	private int pris;

	public Aktie(String prylNamn, int antal, int pris){
		super(prylNamn);
		this.antal = antal;
		this.pris = pris;
	}
	public void b�rskrasch(){
		pris = 0;
	}

	public double v�rde(){
		return pris*antal;
	}
}