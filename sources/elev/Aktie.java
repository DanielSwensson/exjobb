public class Aktie extends Pryl{
	private int antal;
	private int pris;
	
	public Aktie(String prylTyp,int p, int a){
		super(prylTyp);
		pris=p;
		antal=a;
	}
	
	public int getV�rde(){
		return pris * antal;
	}
	
	public void setV�rde(){
		pris= 0;
		
	}
	
	
	
	
	
}