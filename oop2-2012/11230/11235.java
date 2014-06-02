package assetmanagement;

import java.util.ArrayList;

public class Person {//klass

    private ArrayList<Asset> assets = new ArrayList<Asset>(); //arraylist-variabel på klassen Asset
    private String name;//variabel

    Person(String name) { //Konstruktor
        this.name = name;
    }

    public String getName() {//metod för att hämta namn på person
        return name;
    }

    public void addAsset(Asset a) {// Metod som lägger in i array
        assets.add(a);
    }

    public int getValue() {//metod för att hämta värde på samlade tillgångarna
        if (assets.isEmpty()) {
            return 0;
        }
        int sum = 0;
        for (Asset a : assets) {//loopa igenom arraylisten assets
            sum += a.getValue();
        }
        return sum;
    }

    public void doCrash() {//metod för att utföra börskrasch på persons aktietillgångar
        for (Asset a : assets) {
            if(a instanceof Stocks)
                ((Stocks)a).Crash();// polymorfism 
        }
    }

    public void showAssets() {//metod för att visa persons tillgångar
        if (assets.isEmpty()) {
            return;
        }
        for (Asset a : assets) {
            System.out.println(a);
        }
    }
}
