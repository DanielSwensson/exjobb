
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

	public double getV�rde(){
		v�rde = antal * aPris;
		return v�rde;
	}
	
	public String toString(){
		return super.toString();
	}
}