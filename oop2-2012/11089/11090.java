
public class Device extends Item {

	private double value;
	private int wear;
	
	Device(String name, double value, int wear) {
		super(name);
		this.value = value;
		this.wear = wear;
	}
	
	public double getValue() {
		return wear*value/10;
	}
}
