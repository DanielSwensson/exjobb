
class Jewelery extends Stuff {

	private int jewels; //antal juveler på smycket
	private String gold; // om smycket är av juld

	public Jewelery (String owner, String stuffCategory, String subStuff, String gold, int jewels){
		super(owner, stuffCategory, subStuff);
		this.gold = gold;
		this.jewels = jewels;
	}

	public double getValue(){
		int value;
		int metal;

		if (gold.equals("ja")) {
			metal = 2000;
		} else {
			metal = 700;
		}
		value = metal + jewels*500;
		return value;
	}


}



