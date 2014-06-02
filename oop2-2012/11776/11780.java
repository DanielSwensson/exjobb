
public class Jewel extends Thing{

	private final int VALUE_OF_GEMS = 500;
	private int numberOfGems;
	private String metal;

	public Jewel (String name, int numberOfGems, String metal){
		super (name);
		this.numberOfGems = numberOfGems;
		this.metal = metal;
	}
	
	public double  getValue(){
		int metalValue;
		int jewelValue;

		if (metal.equalsIgnoreCase("Ja")){
			metalValue = 2000;
		}		
		else{
			metalValue = 700;
		}
		
		jewelValue = metalValue + numberOfGems * VALUE_OF_GEMS;
		return jewelValue;		
	}
}
