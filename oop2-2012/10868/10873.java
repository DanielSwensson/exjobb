public class Jewellery extends Item {

	private String jewelleryMaterial;
	private int jewelleryGems;



	public Jewellery(String material, int gems, String name){
		super(name);
		jewelleryMaterial = material;
		jewelleryGems = gems;


	}

	public int getValue(){ 

		int baseValue = 700;
	
		if (jewelleryMaterial.equalsIgnoreCase("gold"))
			baseValue = 2000;
		
			return baseValue + (jewelleryGems * 500);

		}
	

}