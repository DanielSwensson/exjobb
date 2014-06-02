/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inlupp2_valuables;

/**
 *
 * @author Robin Hem
 */
public class Stock extends Item{
    private Double sValue;
    private int sCount;

    public Stock(String name, Double sValue, int sCount){
        super(name);
        this.sValue = sValue;
        this.sCount = sCount;
    }

    public Stock(){
        
    }

    @Override
    public Double getValue(){
        return (double)(this.sCount * this.sValue);
    }

    public void setValue(Double value){
        this.sValue = value;
    }

    public String toString() {
        return "Stock: "
                + "\n company: " + this.getName()
                + "\n amount: " + this.sCount
                + "\n value per stock: " + this.sValue
                + "\n \n";
    }

}
