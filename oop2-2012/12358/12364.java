//
// Person.java innehåller person-klassen
//

package myassets.domainobjects.person;

import java.io.Serializable;
import java.util.ArrayList;
import myassets.domainobjects.assets.AbstractAsset;
import myassets.helper.Money;

public final class Person implements Serializable {

    private String name;
    private double wealth;
    private ArrayList<AbstractAsset> holdings = new ArrayList<>();

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<AbstractAsset> getHoldings() {
        return holdings;
    }

    public void setWealth(double wealth) {
        this.wealth = wealth;
    }

    public void addAssetToHoldings(AbstractAsset a) {
        this.holdings.add(a);
        this.setWealth(wealth += a.getAssetValue());
    }

    public double getWealth() {
        return wealth;
    }

    public Money getWealthAsMoney() {
        Money wealthAsMoney = new Money(this.wealth);
        return wealthAsMoney;
    }

    @Override
    public String toString() {
        return this.getName() + "\t" + this.getWealthAsMoney();
    }
}
