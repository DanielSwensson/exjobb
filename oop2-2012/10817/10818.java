
public class Aktie extends Pryl {

	private int antal;
	private double pris;
	
	public Aktie(String str1, int nr1, double nr2){
		super(str1);
		antal=nr1;
		pris=nr2;
	}
	public double getVärde(){
		return antal*pris;
	}
	
	public void prisNoll(){
		pris=0;
	}
}
