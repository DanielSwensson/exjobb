class Stock extends Valuable{



	private int price, amount;


	public Stock(String nameOfStock, int price, int amount){

		super(nameOfStock);

		this.price = price;

		this.amount = amount;

	}


	public int getValue(){

		return amount*price;

	}


	public void stockExchangeCrash(){

		price = 0;

	}

}

