public class Jewellery extends Thing {
	private boolean isGold;
	private int numberOfStones;
	
	public Jewellery(String name, boolean isg, int ns){
		super(name);
		isGold = isg;
		numberOfStones = ns;
	}
	
	public boolean getIsGold(){
		return isGold;
	}
	
	public int getNumberOfStones(){
		return numberOfStones;
	}

	public int getValue(){
		return (isGold ? 2000 : 700) + 500*numberOfStones;
	}
}
