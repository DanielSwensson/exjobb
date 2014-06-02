public class Object extends Item{
	private int purchasePrice;
	private int wear;
	private double value;
	
	Object(String name, String owner, int price, int wear){
		super(name, owner);
		purchasePrice = price;
		this.wear = wear;	
	}
	public double value(){
		return value = purchasePrice * (this.wear / 10.0);
	}
	public void setWear(int newWear){
		this.wear = newWear;
	}
}