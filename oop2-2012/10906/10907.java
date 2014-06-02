public class Device extends Thing {

	private String name;
	private double cost;
	private int wear;

	public Device(String name, double cost, int wear) {
		this.name = name;
		this.cost = cost;
		this.wear = wear;

	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getValue() {
		return cost * (wear / 10.0);
	}

}
