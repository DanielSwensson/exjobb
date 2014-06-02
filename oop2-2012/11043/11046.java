
public class Jewelry extends Item {
	private int gemstone;
	private int material;
	
	public Jewelry(String name, int material, int gemstone){
		super(name);
		
		this.gemstone = gemstone;
		this.material = material;
	}
	
	public int getValue(){
		return material + (gemstone*500);
	}

}