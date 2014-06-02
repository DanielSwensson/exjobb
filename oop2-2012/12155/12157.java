public class Jewellery extends Thing {

    private double gemstones;
    private boolean gold;

    Jewellery(String name, double gemstones, boolean gold) {
	super(name);
	this.gemstones = gemstones;
	this.gold = gold;
    }

    public double getValue() {
	if(gold == true) {
	    return 2000 + (500 * gemstones);
	}

	return 700 + (500 * gemstones);
    }
}
