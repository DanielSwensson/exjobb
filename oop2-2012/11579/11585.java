class Stock extends Thing{
	private String name;
	private int amount;
	private int price;


	public Stock (String name, int amount, int price){
		this.amount = amount;
		this.name = name;
		this.price = price;

	}

	public String getName() {
		return name;
	}	

	public int worth(){
		return amount*price;

	}
	public void setPrice(int price){
		this.price = price;
	}
	public void stockCrash(){
		price=0;

	}

	public String name() {
		return name;
	}

}