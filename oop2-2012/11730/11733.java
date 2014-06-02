class Jewel extends Item{

	private int gems;
	private String gold;
	
	public Jewel(Person owner, String name, int gems, String gold){
		super(name, owner);
		this.gems = gems;
		this.gold = gold.toLowerCase();
	}

	public int getValue(){
		int value;
		if (gold.equals("y")){
			value = 2000;
		}else{
			value = 700;
		}
		value += gems * 500;
		return value;
	}
	
	public void setEachValue(int value){
	}
}
