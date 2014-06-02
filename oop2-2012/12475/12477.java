public class Jewellery extends Thing{
	private int numberOfGems = 0;
	public Jewellery(String name, double value, int numberOfGems){
			super(name, value);
			this.numberOfGems = numberOfGems;
	}
	public double getValue(){
			return this.value + 500 * numberOfGems;
	}
}
