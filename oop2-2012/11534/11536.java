public class Jewelry extends Item {
	private int noOfGemstone;
	private String goldOrSilver;
	private int value;
		
	Jewelry(String name, String owner, int gemstone, String goldOrSilver){
		super(name, owner);
		this.noOfGemstone = gemstone;
		this.goldOrSilver = goldOrSilver;
	}
		public int getGemstone(){
			return noOfGemstone;
		}
		public String getGoldOrSilver(){
			return goldOrSilver;
		}
		public double value(){
			if(goldOrSilver.equalsIgnoreCase("guld")){
				return value = 2000 + (noOfGemstone * 500);
			}else{
				return value = 700 + (noOfGemstone * 500);
			}
		}	
}