public class Aktie extends Pryl	{
   
	private int antal;
	private int pris;
 
    public Aktie(String na, int antal, int pris)	{
        super(na);
        this.antal=antal;
        this.pris=pris;
        setVärde();
        
    }
    
    public void krasch()	{
        pris=0;
        setVärde();
    }
    public void setVärde()	{
        värde=antal*pris;
    }
} 
