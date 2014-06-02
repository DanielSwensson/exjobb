public class Jewelery extends Item {

	private int _jewels = 0;
	private int _type;

	public static final int GOLD = 1;
	public static final int SILVER = 2;
	
	public static int JEWEL_VALUE = 500;
	
	Jewelery(int jewels, int type, String name){
		this._jewels = jewels;
		this._type = type;
		this.name = name;
		
		this.marketValue = this.getMarketValue();
	
	}
	
	private int getMarketValue(){
		
		int marketValue = 0;
		
		switch(this._type){
			case Jewelery.GOLD:
				marketValue = 2000+(this._jewels*Jewelery.JEWEL_VALUE);
			break;
				
			case Jewelery.SILVER: 
				marketValue = 700+(this._jewels*Jewelery.JEWEL_VALUE);
			break;

		}
		
		return marketValue;
	}
	
	
	private String getTypeString(){
		
		String typeString = "";
		
		switch(this._type){
			case 1:
				typeString = "Gold";
			break;
				
			case 2: 
				typeString = "Silver";
			break;
		}
		
		return typeString;
	}
	
	public String toString()
	{
		return this.name + " " + this.marketValue;
	}
}