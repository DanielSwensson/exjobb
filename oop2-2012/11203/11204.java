
public class Aktie extends Pryl {
	private int antal;
	private int pris;

	public Aktie (String prylNamn, int pris, int antal){
		super(prylNamn);
		this.pris=pris;
		this.antal=antal;
	}
	public int getPris(){
		return pris;
	}
	public int getAntal(){
		return antal;
	}

	public int getVärde (){
		return antal*pris;
	}
	public void setVärde(int newVärde){
		pris = newVärde;
	}
}

