
public class Aktie extends Pryl{

	private int aPris, antal;

	public Aktie (String pNamn, int aPris, int antal){
		super(pNamn);
		this.antal = antal;
		this.aPris = aPris;
	}
	public void setPris(int pris){
		aPris = pris;
	}

	public double getVärde(){
		värde = antal * aPris;
		return värde;
	}
	
	public String toString(){
		return super.toString();
	}
}