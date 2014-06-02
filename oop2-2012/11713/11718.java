/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vardesaksregister;

/**
 *
 * @author Krille
 */
public abstract class Pryl {
    private String benamning;
    private String sort;
    public Pryl(String sort, String benamning) {
        this.benamning = benamning;
        this.sort = sort;
    }
    public long getVarde(){
        return 0;
    }
    
    public void borskrasch(){
        
    }
    
    
    public String toString() {
        return "benamning: " + benamning + " sort: " + sort + " värde: ";
    }
    
    
}
