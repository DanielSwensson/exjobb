/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vardesaksregister;

/**
 *
 * @author Krille
 */
public class Apparat extends Pryl{
    private double inkopspris;
    private int slitage;
    public Apparat( String sort, String benamning, double inkopspris, int slitage) {
        super(sort, benamning);
        this.inkopspris = inkopspris;
        this.slitage = slitage;
    }
    
    
    
    
    @Override
    public long getVarde(){
        return Math.round(inkopspris * ((double)slitage/10));
    }
    
    @Override
        public String toString(){
       return super.toString() + "Slitage: " + slitage + " Inköpspris: " + inkopspris +" Värde: " + this.getVarde();
    }
}
