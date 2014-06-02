
public class Aktie extends Pryl{
	private int antal;
	private int pris;

	public Aktie(String na, int an, int p){
		super (na);
		antal=an;
		pris=p;
	}
	public int getAntal(){
		return antal;
	}
	public int getPris(){
		return pris;
	}
	public double getVärde(){
		return antal*pris;
	}

	public void börskrasch(){
		pris=0;
	}
	

}
