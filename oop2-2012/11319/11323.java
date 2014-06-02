package valueables.items;

public class Stock extends Item {
	private int quantity, price;
	
	public Stock(String name, int price, int quantity){
		super(name);
		this.price=price;
		this.quantity=quantity;
	}
	
	public void setPrice(int newPrice){
		price=newPrice;
	}
	@Override
	public int getValue() {
		return price*quantity;
	}

	@Override
	public void marketCrash() {
		price=0;
		
	}

}
