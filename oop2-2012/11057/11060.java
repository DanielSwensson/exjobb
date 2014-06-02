class Accessory extends Item{

	private String material;
	private int gems;

	public Accessory (String aN, String m, int g){
		super(aN);
		material = m;
		gems = g;
	}
	public double returnValue(){
		if (material.equals("gold")) {
			return 2000 + gems * 500;
		}
		else {
			return 700 + gems * 500;
		}
	}
}
