public class Stock extends Possession {
	private int price;
	private int ammount;

	public Stock(String poNa, int pri, int amm) {
		super(poNa);
		price = pri;
		ammount = amm;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getAmmount() {
		return ammount;
	}
	
	public void resetStock() {
		price = 0;
	}
	
	public int getWorth(){
		return price*ammount;
	}
	
}
