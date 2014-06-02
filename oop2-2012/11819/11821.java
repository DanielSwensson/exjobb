public abstract class Items {
	
	private String itemOwner;
	private String itemName;
	
	Items(String personNameData, String itemNameData){
		this.itemOwner = personNameData;
		this.itemName = itemNameData;
		}
			
	public String getitemOwner(){
		return itemOwner;		
		}
	public int getitemValue(){
		return itemValue();
		}
			
	abstract public int itemValue();
		
	public String toString(){
		return "\t"+itemName+" ("+ itemValue() +")";
		}
}
