/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vardesaksregister;

/**
 *
 * @author Krille
 */

public class Smycke extends Pryl{  
    //private static String sort;
   // private static String sortsSmycke;
    private boolean guld;
    private int adelstenar;

    public Smycke(String sort, String benamning, String guld, int adelstenar) {
        super(sort, benamning);
        
        this.adelstenar = adelstenar;
     //   System.out.println("Guld: " + guld);
        if(guld.equalsIgnoreCase("j")) {
            this.guld = true;
        }
        else if(guld.equalsIgnoreCase("n")) {
            this.guld = false;
        }
        else {
            System.out.println("FEL: EJ ANVIGET OM SMYCKET ÄR AV GULD");
        }
        
        
    }
    
    public long getVarde(){
        if(guld){
            return 2000+(500*adelstenar);
        }else if(!guld){
            return 700+(500*adelstenar);
        }else{
            return -1;
        }
    }
    public String toString(){
       return super.toString() + "guld: " + guld + " Ant. ädelstenar: " + adelstenar +" Värde: " + this.getVarde();
    }
    
}
