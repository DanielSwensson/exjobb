
public class Stock extends Item{
	private int amount;
	private int price;
	
	public Stock(String name, int amount, int price){
		super(name);
		this.amount = amount;
		this.price = price;
	}
	
	public int getValue(){
		return amount*price;
	}
	
	public void setPrice(int newPrice){
		price = newPrice;
	}

}