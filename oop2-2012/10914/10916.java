
public class Device extends Item {
	
	private int wear;
	private double originalPrice;
	
	public Device(String name, int wear, double originalPrice) {
		super(name);
		this.wear = wear > 0 ? wear : 0;
		this.originalPrice = originalPrice >= 0 ? originalPrice : 0;
	}
	
	public Device(String name) {
		this(name, 0, 0);
	}
	
	public Device(String name, int wear) {
		this(name, wear, 0);
	}
	
	public int getWear() {
		return wear;
	}
	
	public double getOriginalPrice() {
		return originalPrice;
	}
	
	public double getValue() {
		return getWear() == 1 ? getOriginalPrice() : getOriginalPrice() * (getWear() / 10.0);
	}

}
