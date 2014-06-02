
class Device extends Item{

	private int price;
	private Double wear;
	
	public Device(Person owner, String name, int price, int wear){
		super(name, owner);
		this.price = price;
		this.wear = wear * 0.1;
	}
	
	public int getValue(){
		Double temp = price * wear;
		int value = temp.intValue();
		return value;
	}
	
	public void setEachValue(int value){
	}
}
