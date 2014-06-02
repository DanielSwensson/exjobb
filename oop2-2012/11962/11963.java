public class Stock extends Item {

    private int quantity;
    private int stockPrice;

    public int getQuantity() {
        return quantity;
    }

    public Stock(String name, int quantity, int stockPrice) {
        super(name);
        this.quantity = quantity;
        this.stockPrice = stockPrice; // super kallar p� items konstruktor.
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getValue() { //en pryl typen aktie och ber om v�rdet d�g�r den utr�kningen.
        return quantity * getStockPrice();
    }

    public void setStockPrice(int stockPrice) {
        this.stockPrice = stockPrice;
    }

    public int getStockPrice() {
        return stockPrice;
    }
}
