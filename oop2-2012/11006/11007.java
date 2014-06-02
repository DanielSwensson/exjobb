
public class Aktie extends Pryl{

	private int antal;
	private int pris;

	public Aktie(String prylNamn, int antal, int pris){
		super(prylNamn);
		this.antal = antal;
		this.pris = pris;
	}
	public void börskrasch(){
		pris = 0;
	}

	public double värde(){
		return pris*antal;
	}
}