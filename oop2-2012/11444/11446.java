public class Apparat extends Pryl	{
    
	
	private int ink�pspris, slitage;
    
    public Apparat(String na, int ink�pspris, int slitage)	{
        super(na);
        this.ink�pspris=ink�pspris;
        this.slitage=slitage;
        setV�rde();
    }
    
	
    public void setV�rde(){
        v�rde=ink�pspris*slitage/10;
    }
} 
