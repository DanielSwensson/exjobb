//
// Gadget.java hanterar saker av typen apparat.
//
package myassets.domainobjects.assets;

import myassets.domainobjects.person.Person;
import myassets.helper.Money;

public class Gadget extends AbstractAsset {

    private double purchasePrice;
    private int levelOfWear;

    public Gadget(double purchasePrice, int levelOfWear, String name, Person owner) {
        super(name, owner);
        this.purchasePrice = purchasePrice;
        this.levelOfWear = levelOfWear;
    }

    public double getPurchasePrice() {
        return this.purchasePrice;
    }

    public int getLevelOfWear() {
        return this.levelOfWear;
    }

    public void setLevelOfWear(int levelOfWear) {
        this.levelOfWear = levelOfWear;
    }

    @Override
    public double getAssetValue() {
        //Apparater: värdet varierar beroende på slitaget. 
        //Om slitaget är 10 (apparaten är ny) så är värdet lika med priset, 
        //är slitaget 9 är värdet 90% av priset, är slitaget 8 är värdet 80% av priset osv.          
        
        //return (purchasePrice * ((int) levelOfWear / 10)); 
        // FEL!!! cast till int tappar precision...
        return (purchasePrice * ((double) levelOfWear / 10));        
    }

    @Override
    public Money getAssetValueAsMoney() {
        Money assetValueAsMoney = new Money(getAssetValue());        
        return assetValueAsMoney;
    }

    @Override
    public String toString() {
        return super.toString() + "Inköpt för " + this.getPurchasePrice() + ". Kondition: " + this.getLevelOfWear();
    }
}
