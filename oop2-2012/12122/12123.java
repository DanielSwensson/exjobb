
public class Appliance extends Item{
	
	private double purchasePrice;
	private int wear;
	private String wearPrecentage;
	private double value;
	
	Appliance(Object owner, String name, double purchasePrice, int wear) {
		super(owner, name);
		this.purchasePrice = purchasePrice;
		this.wear = wear;
	}
	
	public double getValue() {
		this.wearPrecentage = this.wear + "0";
		this.value = (this.purchasePrice * Integer.parseInt(getWearPrecentage())) / 100;
		return this.value;
	}
	
	private String getWearPrecentage() {
		String precentage = this.wear + "0";
		return precentage;
	}
	
	
	
}
