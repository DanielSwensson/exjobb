
public class Juwelery extends Item {
	
	private int numberOfGems;
	private boolean isGold;
	private final int GOLD_VALUE = 2000;
	private final int NON_GOLD_VALUE = 700;
	
	public Juwelery(String name, int numberOfGems, boolean isGold) {
		super(name);
		this.numberOfGems = numberOfGems >= 0 ? numberOfGems : 0;
		this.isGold = isGold;
	}
	
	public Juwelery() {
		this(null,0,false);
	}
	
	public Juwelery(String name) {
		this(name, 0, false);
	}
	
	public Juwelery(String name, int numberOfGems) {
		this(name, numberOfGems, false);
	}
	
	public int getNumberOfGems() {
		return numberOfGems;
	}
	
	public double getValue() {
		int baseValue = (isGold ? GOLD_VALUE : NON_GOLD_VALUE);
		return baseValue + (numberOfGems * 500);
	}
	
}
