
public class Appliance extends Thing {

	private double price;
	private int wear;

	public Appliance(String name, double price, int wear) {
		super(name);
		this.price = price;
		this.wear = wear;
	}

	public double getValue() {
		if (wear == 10) {
			return price;
		} else if (wear == 9) {
			return price * 0.9;
		} else if (wear == 8) {
			return price * 0.8;
		} else if (wear == 7) {
			return price * 0.7;
		} else if (wear == 6) {
			return price * 0.6;
		} else if (wear == 5) {
			return price * 0.5;
		} else if (wear == 4) {
			return price * 0.4;
		} else if (wear == 3) {
			return price * 0.3;
		} else if (wear == 2) {
			return price * 0.2;
		} else if (wear == 1) {
			return price * 0.1;
		} else {
			return 0;
		}
	}

}