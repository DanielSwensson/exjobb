package valueables.items;

public class Jewelry extends Item{
	/*
	 * Predefined set of materials
	 */
	public enum Material{
		GOLD(2000), SILVER(700);
		
		private int value;
		Material(int value){
			this.value=value;
		}
	}
	private int gems;
	private final Material material;
	
	public Jewelry(String name, int gems, Material material){
		super(name);
		this.gems=gems;
		this.material=material;
	}
	
	@Override
	public int getValue() {
		
		return gems*500 + material.value;
	}



}
