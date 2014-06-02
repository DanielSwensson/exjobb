// Class declaration
public class Device extends Item{
	
	// Randomly generated serialVersionUID
	private static final long serialVersionUID = 5095113328174473233L;

	// Attributes
	private double purchasePrice;
	private int wearIndex;

	// Constructor
	Device(String name, double purchasePrice, int wearIndex){
		this.name = name;
		this.purchasePrice = purchasePrice;
		this.wearIndex = wearIndex;
		
		calcValue();
	}

	// Overridden method that calculates and sets the objects value to its 'value'-attribute
	@Override
	protected void calcValue(){
		this.value = purchasePrice*wearIndex/10;
	}
}