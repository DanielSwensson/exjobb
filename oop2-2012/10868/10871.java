public class Electronics extends Item {

	private int electronicsPurchasePrice;
	private int electronicsWear;


	public Electronics(int wear, int price, String name){
		super(name);
		electronicsPurchasePrice = price;
		electronicsWear = wear;
	}


	public int getValue(){
		return	(electronicsPurchasePrice * electronicsWear) /10;

		
	}

}