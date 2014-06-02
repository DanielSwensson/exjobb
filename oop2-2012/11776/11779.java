
public class Device extends Thing {

	private double purchasePrice;
	private int wear;

	public Device (String name, double purchasePrice, int wear){
		super (name);
		this.purchasePrice = purchasePrice;
		this.wear = wear;
	}

	public double getPurchasePrice(){
		return purchasePrice;
	}

	public int getWear(){
		return wear;
	}

	public double getValue(){
		double deviceValue;

		deviceValue = purchasePrice * (wear/10.0);
		return deviceValue;
	}
}
