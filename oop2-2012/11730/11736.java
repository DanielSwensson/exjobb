
class Shares extends Item{

	private int amount;
	private int eachValue;
	
	public Shares(Person owner, String name, int amount, int eachValue){
		super(name, owner);
		this.amount = amount;
		this.eachValue = eachValue;
	}
	
	public int getValue(){
		int value = amount * eachValue;
		return value;
	}
	
	public void setEachValue(int value){
		eachValue = value;
	}

}
