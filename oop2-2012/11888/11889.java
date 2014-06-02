public class Appliance extends Item {
	
	private String name;
	private int wear;
	
	private int _price; 
	
	Appliance(String name, int price, int wear) {
	
		this.name = name;
		this.wear = wear;
		this._price = price;
		this.marketValue = this.getMarketValue();
		 
	}

	private int getMarketValue(){
			
			int marketValue = (this._price * this.wear) / 10 ;
		
			return marketValue;
	
	}


	public String toString()
	{
		return this.name + " " + this.marketValue;
}
	}