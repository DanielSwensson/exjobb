/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 *
 * @author Tor Brambeck
 */
public class Aktie extends Prylar {
    private int amount;
    private double price;
    
    public Aktie(String name, double price, int amount){
        super(name);
        this.price = price;
        this.amount = amount; 
    }
    
    public int amount(){
        return amount; 
    }
    
    public double price(){
        return price;
    }
    
    public double getValue(){
        return amount * price;
    }
    
    public String toString(){
        return super.getName() + " "+ getValue();
    }
    
    public double valueIfStockCrasch(){
        return price = 0;
    } 
}
