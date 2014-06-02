/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inlupp2_valuables;

import java.util.ArrayList;

/**
 *
 * @author Robin Hem
 */
public class Person{
    private ArrayList <Item> itemArray = new ArrayList<Item> ();
    private String name;
    
    public Person(String name){
        this.name = name;
    }

    public void addItem(Item item){
        this.itemArray.add(item);
    }

    public String getName(){
        return this.name;
    }

    public ArrayList <Item> getItems(){
        return this.itemArray;
    }

    public Double getTotalValue(){
        Double value = 0.0;
        for(Item i: itemArray){
            value += i.getValue();
        }
        return value;
    }

    @Override
    public String toString(){
        return this.getName() + "   " + this.getTotalValue().toString() + "\n";
    }
}
