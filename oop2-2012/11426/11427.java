
public class Appliance extends Valuable{
	
	//attributes:
	private double purchasePrice;
	private int wear;

	//constructor:
	public Appliance(String typeOfValuable, String name, double purchasePrice, int wear){
		super(typeOfValuable, name);
		this.purchasePrice = purchasePrice;
		this.wear = wear;
	}
	
	//methods:
	
	public double calculateValue(){
		return purchasePrice * (wear / 10.0);
	}
}
