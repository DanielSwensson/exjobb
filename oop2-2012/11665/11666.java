public class Device extends Thing {
	private int originalPrice, wear;
	
	public Device(String name, int o, int w){
		super(name);
		originalPrice = o;
		wear = w;
	}
	
	public int getOriginalPrice(){
		return originalPrice;
	}
	
	public int getWear(){
		return wear;
	}

	public int getValue(){
		return originalPrice*wear/10;
	}
	
	public void setWear(int w){
		wear = w;
		return;
	}

}
