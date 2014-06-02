public class Aktie extends Pryl {

	private int _amount; 
	private int _price;
	
	Aktie(String name, int amount, int price) {
	
		this.name = name;
		this._amount = amount;
		this._price = price;
		
		this.marketValue = this.getMarketValue();
	}
	
	private int getMarketValue(){
		
		return (this._amount * this._price);
	}
	
	public void setPriceAndMarketValue(int newPrice){
		this._price = newPrice;
		this.marketValue = this.getMarketValue();
	}
	
	public String toString()
	{
		return this.name + " " + this.marketValue;
	}
}