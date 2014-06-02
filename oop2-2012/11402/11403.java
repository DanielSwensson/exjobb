package inlupp2;

public class Device extends Gadget {
	protected int purchasePrice;
	protected int wear;
	
	public Device(String name, int price, int wear){
		super(name);
		purchasePrice = price;
		this.wear = wear;
	}
	protected int value(){
		return purchasePrice*(wear/10);
	}

	public String toString(){
		return getName() + "	" + value();
	}
}
