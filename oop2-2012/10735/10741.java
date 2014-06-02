public class Stock extends Item{
    private int amount;
    private int stockPrice;

    public Stock (String name, int amount, int stockPrice){
        super(name);
        this.amount = amount;
        this.stockPrice = stockPrice;

    }

    public double getValue (){
        return stockPrice * amount;
    }

    public String toString(){
        return "Company: " + name + "      Value: " + getValue() + "\n";

    }

    public void setPrice(){
        stockPrice = 0;
    }
}
