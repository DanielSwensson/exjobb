package valueables.items;

public class Device extends Item {

	
	private int wear, price;
	
	public Device(String name, int price, int wear){
		super(name);
		this.price=price;
		this.wear=wear;
	}
	@Override
	public int getValue() {
		
		return (int)(wear/10.0*price);
	}
}
