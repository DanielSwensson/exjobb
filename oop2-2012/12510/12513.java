// Class declaration
public class Jewelry extends Item{
	
	// Randomly generated serialVersionUID
	private static final long serialVersionUID = -8856360732396909032L;
	
	// Attributes
	private boolean isGold;
	private int numberOfGems;

	// Constructor
	Jewelry(String name, int numOfGems, boolean isGold){
		this.name = name;
		this.numberOfGems = numOfGems;
		this.isGold = isGold;
		
		calcValue();
	}
	
	// Overridden method that calculates and sets the objects value to its 'value'-attribute
	@Override
	protected void calcValue() {
		if(isGold){
			this.value = numberOfGems*500 + 2000;
		}else{
			this.value = numberOfGems*500 + 700;
		}
	}
}
