public class Equipment extends Items {
	
	private int equipmentPurchasePrice;
	private int equipmentState;
	
	Equipment(String personNameData, String itemNameData, int equipmentPurchasePriceData, int equipmentStateData) {
		super(personNameData, itemNameData);
		this.equipmentPurchasePrice = equipmentPurchasePriceData;		
		this.equipmentState = equipmentStateData;
		}	
	
	public int itemValue(){
		return (equipmentState*equipmentPurchasePrice)/10;
		}	
}
