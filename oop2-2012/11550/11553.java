

public class Appliance extends Gadget{
	
	
	private int costPrice;
	private double wear;
	private int value;
	
	public Appliance(String typeName, int costPrice, double wear) {
		super(typeName, "Apparat");
		this.costPrice = costPrice;
		this.wear = wear;
		countValue(costPrice, wear);
	}
	
	private void countValue(int costPrice, double wear) {
		double percent = wear / 10;
		double d = costPrice * percent;
		value = (int)d;
	}
	
	public int getValue() {
		return value;
	}
	
	public int costPrice() {
		return costPrice;
	}
	
	public double wear() {
		return wear;
	}
	
	public String toString() {
		return super.toString() + "och har ett värde av " + getValue();
	}
	
	
}
