
public class Appliance extends Gadget{
	
	private int purchasePrice;
	private int wear;
	private double value;
	
	public Appliance(String name, int appPurchasePrice, int appWear) {
		super(name);
		purchasePrice = appPurchasePrice;
		wear = appWear;
		
		if (wear == 10){
			value = purchasePrice;
		}
		if (wear != 10){
			value = purchasePrice * (wear * 0.1);
		}
	}
	public double getValue(){
		return value;
	}
}
