//
// AbstractAsset.java är basklassen för alla saker (assets).
//

package myassets.domainobjects.assets;

import java.io.Serializable;
import myassets.domainobjects.person.Person;
import myassets.helper.Money;

public abstract class AbstractAsset implements Serializable {

    private String assetName;
    private Person assetOwner;

    public abstract double getAssetValue();
    public abstract Money getAssetValueAsMoney();

    public AbstractAsset(String assetName, Person assetOwner) {
        this.assetName = assetName;
        this.assetOwner = assetOwner;
    }

    public Person getAssetOwner() {
        return assetOwner;
    }

    public void setAssetOwner(Person p) {
        this.assetOwner = p;
    }

    public String getAssetName() {
        return assetName;
    }

    @Override
    public String toString() {
        return "Sak: " + this.getAssetName() + ". Värde: " + this.getAssetValueAsMoney() + ". ";
    }
}
