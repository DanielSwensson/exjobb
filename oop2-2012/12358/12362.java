//
// Jewellery.java hanterar saker av typen smycke.
//

package myassets.domainobjects.assets;

import myassets.domainobjects.person.Person;
import myassets.helper.Money;

public class Jewellery extends AbstractAsset {

    private int numberOfGems;
    private String metal;

    public Jewellery(int numberOfGems, String metal, String name, Person owner) {
        super(name, owner);
        this.numberOfGems = numberOfGems;
        this.metal = metal;
    }

    public int getNumberOfGems() {
        return numberOfGems;
    }

    public String getMetal() {
        return metal;
    }

    public boolean isGold() {
        return this.metal.equalsIgnoreCase("Guld");
    }

    @Override
    public String toString() {
        return super.toString() + "Gjord av " + this.getMetal() + ". Antal ädelstenar: " + this.getNumberOfGems();
    }

    @Override
    public double getAssetValue() {
        // Smycken: om smycket är av guld så är värdet 2000, om det är av silver så är värdet 700. 
        // Dessutom ökar värdet med 500 för varje ädelsten        
        return (getNumberOfGems() * 500) + (isGold() ? 2000 : 700);
        
    }

    @Override
    public Money getAssetValueAsMoney() {
        Money assetValueAsMoney = new Money(getAssetValue());
        return assetValueAsMoney;
    }
}
