// Class declaration
public class Share extends Item{
	
	// Randomly generated serialVersionUID
	private static final long serialVersionUID = -1114873343159478407L;
	
	// Attributes
	private int amount;
	private double price;

	// Constructor
	Share(String name, int amount, double price){
		this.name = name;
		this.amount = amount;
		this.price = price;
		
		calcValue();
	}

	// Method that overwrites the price
	public void setPrice(double price){
		this.price = price;
		calcValue();
	}
	
	// Overridden method that calculates and sets the objects value to its 'value'-attribute
	@Override
	protected void calcValue() {
		this.value = price*amount;
	}
}
