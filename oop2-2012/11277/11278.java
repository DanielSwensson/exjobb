public class Aktie extends Pryl{
    
	private int antal;
	private int pris;
    private int varde;
	
	public Aktie(String aNamn, String typ, int antal, int pris){
		super(typ,aNamn);
		this.pris=pris;
		this.antal=antal;

		}
    
    public int getValue(){
   		return varde=pris * antal;
   	}
    
    public void stockMcrash(){
    	pris=0;
    	}
	
	}