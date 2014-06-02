public class Aktie extends Pryl {
	private int antal;
	private int pris;

	public Aktie(String name, int a, int p) {
		super(name);
		antal=a;
		pris=p;
	
}
	
	public double getValue() {
		return (antal * pris);
	}
	
	public void		setPris(int nyttPris) {
		pris = nyttPris;	
	}
	public String toString(){
		return namn + " " + getValue()  ;
	}	
}