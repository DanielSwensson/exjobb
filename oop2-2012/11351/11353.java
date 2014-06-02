package prylregister;
 
public class Apparat extends Pryl {
    private int inköpspris;
    private int slitage;
 
    public Apparat(String na, int inPr, int sli){
       super(na);
       inköpspris = inPr;
       slitage = sli;
   }
 
    public int värde(){
        double slitageVärde = slitage/10.0;
        return (int)(inköpspris * slitageVärde);
    }
 
    public String toString(){
        String str = namn+" (apparat, "+värde()+" kr)"; 
        return str;
    }
}