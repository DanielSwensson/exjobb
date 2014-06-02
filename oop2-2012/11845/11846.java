public class Appliance extends RegisteryObject {

	private String name;
	private double buyingPrice;
	private int wear;

	public Appliance(String name, double buyingPrice, int wear) {
		this.name = name;
		this.buyingPrice = buyingPrice;
		this.wear = wear;
	}

	@Override
	public double getValue() {
		return (buyingPrice * wear) / 10;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
