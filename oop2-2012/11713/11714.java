/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vardesaksregister;

/**
 *
 * @author Krille
 */
public class Aktie extends Pryl{
    private int antal;
    private double index;
    private int valid;
    
    public Aktie(String sort, String benamning, int antal, double index){
        super(sort, benamning);
        this.antal=antal;
        this.index=index;
        valid = 1;
    }
    
    @Override
    public void borskrasch(){
        valid = 0;
    }
    
    @Override
    public long getVarde(){
        return Math.round((double)antal*index*valid);
    }
    
    @Override
     public String toString(){
       return super.toString() + "Antal: " + antal + " Index: " + index +" Värde: " + getVarde();
    }
}
