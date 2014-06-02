public class Device extends Thing {
	private double cost;
	private double wear;

	public Device(String owner, int sort, String thingName, double value,
			double cost, double wear) {
		super(owner, sort, thingName, value);
		this.cost = cost;
		this.wear = wear;
	}

	public double getCost() {
		return cost;
	}

	public double getWear() {
		return wear;
	}

}
