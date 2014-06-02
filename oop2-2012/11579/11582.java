
class Jewelry extends Thing{
	private String name;
	private int stones;
	private String material;
	
	public Jewelry(String name, String material, int stones) {
		this.stones = stones;
		this.name = name;
		this.material = material;
	
	}
	public String getName() {
		return name;
	}	
		
	public int worth(){
		if (material.equalsIgnoreCase("guld"))
			return (2000+(stones*500));
		
		else return (700+(stones*500));
		
	}

	public String name() {
		return name;
	}
}

