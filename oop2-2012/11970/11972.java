
public class Apparat extends Pryl{
private int ink�pspris, slitage;
    
    public Apparat(String na, int ink�pspris, int slitage){
        super(na);
        this.ink�pspris=ink�pspris;
        this.slitage=slitage;
        setVarde();
    }
    
	


	public void setVarde(){
        v�rde=ink�pspris*slitage/10;
    }

}
