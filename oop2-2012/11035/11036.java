
public class Aktie extends Pryl {

	private int antal;
	private int pris;


	public Aktie (int a, int p, String pt, String n){
		super (pt, n);
		antal = a;
		pris = p;

	}

	public int getPris(){
		return pris;
	}

	public int getAntal(){
		return antal;
	}

	public double getVärde(){
		return (antal * pris);
	}

	public void setPrisNoll(){
		pris = 0;
	}
}
