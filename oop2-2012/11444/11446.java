public class Apparat extends Pryl	{
    
	
	private int inköpspris, slitage;
    
    public Apparat(String na, int inköpspris, int slitage)	{
        super(na);
        this.inköpspris=inköpspris;
        this.slitage=slitage;
        setVärde();
    }
    
	
    public void setVärde(){
        värde=inköpspris*slitage/10;
    }
} 
