
public class Stuff {

	private String owner;				// �garens namn
	private String stuffCategory; 		// vad det �r f�r kategori, dvs. smycke, aktie eller apparat
	private String subStuff;			// vad f�r typ av smycke eller apparat eller namnet p� bolaget som aktien kommer fr�n

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

