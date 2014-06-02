
public class Jewlery extends Gadget{
	
	private String material;
	private int gems;
	private double value;
	
	public Jewlery(String name, String jewleryMaterial, int jewleryGems) {
		super(name);
		material = jewleryMaterial;
		gems = jewleryGems;
		
		if (material .equalsIgnoreCase("Guld")){
			value = 2000;
		}else 
			value = 700;
		
		 value += (gems * 500);
	}
	public double getValue(){
		return value;
	}

}
