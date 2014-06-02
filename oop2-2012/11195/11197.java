public class Apparat extends Pryl	{
    
	
	private int inkšpspris, slitage;
    
    public Apparat(String na, int inkšpspris, int slitage)	{
        super(na);
        this.inkšpspris=inkšpspris;
        this.slitage=slitage;
        setVŠrde();
    }
    
	
    public void setVŠrde(){
        vŠrde=inkšpspris*slitage/10;
    }
} 
