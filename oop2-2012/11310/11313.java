/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inlupp2_valuables;

/**
 *
 * @author Robin Hem
 */
public class Valuable extends Item{
    private int gemCount;
    private String itemMaterial;

    public Valuable(String name, int gCount, String mat){
        super(name);
        this.gemCount = gCount;
        this.itemMaterial = mat;
    }

    @Override
    public Double getValue(){
        Double value = 0.0;
        if(this.itemMaterial.equalsIgnoreCase("gold")){
            return value = (double)(2000 + (this.gemCount * 500));
        }else if(this.itemMaterial.equalsIgnoreCase("silver")){
            return value = (double)(700 + (this.gemCount * 500));
        }
        else{
            System.out.println("material error");
        }
        return value;
    }

    @Override
    public String toString(){
        return "Valuable: "
                + "\n type: " + this.getName()
                + "\n gem count: " + this.gemCount
                + "\n item material: " + this.itemMaterial
                + "\n \n";
    }

}
