public class Gadget extends Thing {

    private double buyPrice;
    private int wear;

    Gadget(String name, double buyPrice, int wear) {
	super(name);
	this.buyPrice = buyPrice;
	this.wear = wear;
    }

    public double getValue() {
	return buyPrice * (wear / 10.0);
    }
}
