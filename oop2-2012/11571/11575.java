class Jewellery extends Item {

	private int nog;
	private String material;

	//Constructor
	public Jewellery(String name, int nog, String material, int jvalue) {
		super(name, jvalue);
		this.nog=nog;
		this.material=material;
	}

	public int showGems(){
		return nog;
	}
	public String showMaterial(){
		return material;
	}
	public String toString(){
		return super.toString() + "		" + "Gems: " + nog + "		" + "Material: " + material;
	}

}