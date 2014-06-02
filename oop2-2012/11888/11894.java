public class Stock extends Item {

	private int amount; 
	private int price;
	
	Stock(String name, int amount, int price) {
	
		this.name = name;
		this.amount = amount;
		this.price = price;
		
		this.marketValue = this.getMarketValue();
	}
	
	private int getMarketValue(){
		
		return (this.amount * this.price);
	}
	
	public void setPriceAndMarketValue(int newPrice){
		this.price = newPrice;
		this.marketValue = this.getMarketValue();
	}
	
	public String toString()
	{
		return "Name: "+this.name +" \nPrice: "+this.price+" \nValue: "+this.marketValue;
	}
}