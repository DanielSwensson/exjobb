public class Stock extends Thing {

    private double price;
    private int number;

    Stock(String name, double price, int number) {
	super(name);
	this.price  = price;
	this.number = number;
    }

    public double getValue() {
	return number * price;
    }

    public void setPrice(double price) {
	this.price = price;
    }
}
