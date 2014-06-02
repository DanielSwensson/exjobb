
public class Apparatus extends Item{
	private int deterioration;
	private int retailPrice;
	
	public Apparatus(String name, int deterioration, int retailPrice){
		super(name);
		this.deterioration = deterioration;
		this.retailPrice = retailPrice;
	}
	
	public int getValue(){
		return retailPrice*(deterioration/10);
	}

}