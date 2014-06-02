public class Apparat extends Pryl {
	
	private String name;
	private int _slitage;
	
	private int _price; 
	
	Apparat(String name, int price, int slitage) {
	
		this.name = name;
		this._slitage = slitage;
		this._price = price;
		this.marketValue = this.getMarketValue();
		 
	}

	private int getMarketValue(){
			
			int marketValue = (this._price * this._slitage) / 10 ;
		
			return marketValue;
	
	}


	public String toString()
	{
		return this.name + " " + this.marketValue;
}
	}