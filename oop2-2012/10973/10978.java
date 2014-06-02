/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.


/**
 *
 * @author Tor Brambeck
 */
import java.util.*;
public class Personer {
    private String name;
    private ArrayList<Prylar> allaPrylar = new ArrayList<Prylar> ();
    

    public Personer(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public void addPryl(Prylar p){
        this.allaPrylar.add(p);
    }
    
    public double getValue(){
        return getValue();
    }
    
    public double remove(){
        return remove();
    }
    
    public String toString(){
        return name;
    }
    
    public void printAllStuff(){
        for (int x = 0; x<allaPrylar.size(); x++){
            System.out.println(allaPrylar.get(x) + " ");
        }
    }   
    

    
    public double totalAssets(){
        double totalAssets = 0;
        for (int x = 0; x<allaPrylar.size(); x++){
            totalAssets = totalAssets + allaPrylar.get(x).getValue();
        }
        return totalAssets;
    }
    
    public String toStringAssets(){
        return name + " " + totalAssets() + " ";
    }

    
    public String toStringRichest(){
        return "Rikaste är " + name + " som har prylar till ett värde av sammanlagt: " + totalAssets();
    }
    
    public void setStocksZero(){
        for (int x = 0; x<allaPrylar.size(); x++){
            if (allaPrylar.get(x) instanceof Aktie){
                Aktie a = (Aktie)allaPrylar.get(x);
                a.valueIfStockCrasch();
            }
        }
    }
}