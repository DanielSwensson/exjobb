public class Device extends Belongings {
	
	private int originalPrice, wear; 
	
	Device(String name, int originalPrice, int wear) {
		super(name, (originalPrice * wear/10));
		this.originalPrice = originalPrice;
		this.wear = wear;
	}
	
	public String toString() {
		return getName() +", Inköpspris: " + originalPrice + ", Slitage: " +wear + ", Värde: " + getValue();
	}
}
