/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inlupp2_valuables;

/**
 *
 * @author Robin Hem
 */
public class Appliance extends Item{
    private Double cost;
    private int wear;

    public Appliance(String name, Double cost, int wear){
        super(name);
        this.cost = cost;
        this.wear = wear;
    }

    @Override
    public Double getValue(){
        return this.cost * this.wear/10;
    }

    @Override
    public String toString(){
        return "Appliance: "
                + "\n type: " + this.getName()
                + "\n cost: " + this.cost
                + "\n wear: " + this.wear
                + "\n value: " + this.getValue()
                + "\n \n";
    }

}
