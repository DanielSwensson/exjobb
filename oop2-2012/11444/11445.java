public class Aktier extends Pryl	{
   
	private int antal;
	private int pris;
 
    public Aktier(String na, int antal, int pris)	{
        super(na);
        this.antal=antal;
        this.pris=pris;
        setV�rde();
        
    }
    
    public void krasch()	{
        pris=0;
        setV�rde();
    }
    public void setV�rde()	{
        v�rde=antal*pris;
    }
} 
