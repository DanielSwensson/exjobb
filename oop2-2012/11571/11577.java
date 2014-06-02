class Stock extends Item {
	private int amount;
	private int value;

	//Constructor
	public Stock(String name, int value, int amount, int svalue) {
		super(name, svalue);
		this.amount=amount;
		this.value=svalue;
	}
	public int showAmount(){
		return amount;
	}
	public void setValue(){
		super.setValue();
	}
	public int getValue(){
		return value;
	}
	public String toString(){
		return super.toString() + "		" + "Amount: " + amount + "		Price per stock: " + value/amount;
	}

}