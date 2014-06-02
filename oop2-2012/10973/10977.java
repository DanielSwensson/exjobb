/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Tor Brambeck
 */
public class Appart extends Prylar{
    private int use;
    private double price;
    
    public Appart(String name, int use, double price){
        super(name);
        this.use = use;
        this.price = price;
    }
    
    public int getUse(){
       return use;
    }
    
    public double getPrice(){
        return price;
    }
    
    public double getValue(){
        return (0.1 * use) * price;
    }
    public String toString(){
        return super.getName() + " " + getValue();
    }
    
}
