
public class Aktie extends Pryl{
	private int antal;
	private int pris;
 
    public Aktie(String na, int antal, int pris){
        super(na);
        this.antal=antal;
        this.pris=pris;
        setVarde();
    }
	
    public void krasch(){
        pris=0;
        setVarde();
    }
    public void setVarde(){
        värde=antal*pris;
    }

}
