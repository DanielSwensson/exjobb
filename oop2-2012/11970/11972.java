
public class Apparat extends Pryl{
private int inköpspris, slitage;
    
    public Apparat(String na, int inköpspris, int slitage){
        super(na);
        this.inköpspris=inköpspris;
        this.slitage=slitage;
        setVarde();
    }
    
	


	public void setVarde(){
        värde=inköpspris*slitage/10;
    }

}
