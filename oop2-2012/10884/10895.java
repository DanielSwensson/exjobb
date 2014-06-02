public class Smycke extends Pryl {

	private int _jewels = 0;
	private int _type;

	public static final int GOLD = 1;
	public static final int SILVER = 2;
	
	public static int JEWEL_VALUE = 500;
	
	Smycke(String name, int jewels, int type){
		this.name = name;
		this._jewels = jewels;
		this._type = type;
		
		this.marketValue = this.getMarketValue();
	
	}
	
	private int getMarketValue(){
		
		int marketValue = 0;
		
		switch(this._type){
			case Smycke.GOLD:
				marketValue = 2000+(this._jewels*Smycke.JEWEL_VALUE);
			break;
				
			case Smycke.SILVER: 
				marketValue = 700+(this._jewels*Smycke.JEWEL_VALUE);
			break;

		}
		
		return marketValue;
	}
	
	
	private String getTypeString(){
		
		String typeString = "";
		
		switch(this._type){
			case 1:
				typeString = "Guld";
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