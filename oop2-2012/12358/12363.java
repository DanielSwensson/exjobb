// 
// Stock.java hanterar saker av typen aktiepost.
//

package myassets.domainobjects.assets;

import myassets.domainobjects.person.Person;
import myassets.helper.Money;

public class Stock extends AbstractAsset {

    private int quantity;
    private double price;

    public Stock(int quantity, double price, String name, Person owner) {
        super(name, owner);
        this.quantity = quantity;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setStockPrice(int price) {
        this.price = price;
    }

    @Override
    public double getAssetValue() {
        return this.price * this.quantity;
    }

    @Override
    public Money getAssetValueAsMoney() {
        Money assetValueAsMoney = new Money(getAssetValue());
        return assetValueAsMoney;
    }

    @Override
    public String toString() {
        Money stockPrice = new Money(getPrice());
        return super.toString() + "(Aktieposten innehåller " + this.quantity + " st aktier à " + stockPrice;
    }
}
