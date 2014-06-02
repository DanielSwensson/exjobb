/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inlupp2_valuables;

/**
 *
 * @author Robin Hem
 */
public class Item {
    private String name;
    private Double value;

    public Item(String name, Double value){
        this.name = name;
        this.value = value;
    }

    public Item(String name){
        this.name = name;
    }

    public Item(){

    }

    public void setValue(Double value){
        this.value = value;
    }

    public String getName(){
        return this.name;
    }

    public Double getValue(){
        return this.value;
    }
}
