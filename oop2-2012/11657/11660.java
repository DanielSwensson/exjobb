
public class Jewelry extends Item {

	private int jewelryGems;
	private boolean jewelryGold;
	
	public Jewelry (String jewelryName,int jewelryGems, boolean jewelryGold ) {
		super (jewelryName);
		this.jewelryGems = jewelryGems;
		this.jewelryGold = jewelryGold;
	}
	
	public int getGems(){
		return jewelryGems;
	}
	
	public boolean getGold(){
		return jewelryGold;
	}
	
	public int getValue(){
		int value;
		if (jewelryGold){
			value = 2000;
		} else { 
			value = 700;
		}
		value = value + jewelryGems * 500;
		return value;
	}

}
