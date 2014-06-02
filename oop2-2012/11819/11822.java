public class Jewelry extends Items{
	
	private int jewelryMaterial; 
	private int jewelryNumberOfGems;
	
	Jewelry(String personNameData, String itemNameData, int jewelryMaterialData, int jewelryNumberOfGemsData) {
		super(personNameData, itemNameData);
		this.jewelryMaterial = jewelryMaterialData;
		this.jewelryNumberOfGems = jewelryNumberOfGemsData;
			}
	
	public int itemValue(){
	if(jewelryMaterial == 1){
		return 2000+(500*jewelryNumberOfGems);
		}
	else{
		return 700+(500*jewelryNumberOfGems);
		}
	}	
		
}


