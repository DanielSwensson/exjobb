class Device extends Item {
	private int wear;

	//Constructor
	public Device(String name, int price, int wear, int dvalue) {
		super(name,dvalue);
		this.wear=wear;
	}
	public int showWear(){
		return wear;
	}
	public String toString(){
		return super.toString() + "		" + "Quality: " + wear;
	}

}
