
class Stock extends Stuff{

	private int quantity; // antal aktier
	private int price; //pris på aktier


	public Stock (String owner, String stuffCategory, String subStuff,int quantity, int price){
		super(owner, stuffCategory, subStuff);
		this.quantity = quantity;
		this.price = price;
	}


	public double getValue(){
		return quantity * price;
	}

	public void setPrice(int priceStockCrash){
		price = priceStockCrash;
	}


}
