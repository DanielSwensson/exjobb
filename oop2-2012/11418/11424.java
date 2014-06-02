
public class Stuff {

	private String owner;				// ägarens namn
	private String stuffCategory; 		// vad det är för kategori, dvs. smycke, aktie eller apparat
	private String subStuff;			// vad för typ av smycke eller apparat eller namnet på bolaget som aktien kommer från

	public Stuff (String owner, String stuffCategory, String subStuff){
		this.owner = owner;
		this.stuffCategory = stuffCategory;
		this.subStuff = subStuff;
	}

	public String getOwner(){
		return owner;
	}

	public String getStuff(){
		return stuffCategory;
	}

	public String getSubStuff(){
		return subStuff;
	}
	
	public double getValue(){	
		return 0;
	}

	public void setPrice(int priceStockCrash){
	}

}

