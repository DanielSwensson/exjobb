
class Device extends Thing{
	private String name;
	private int inPrice;
	private int wear;


	public Device(String name, int wear, int inPrice){
		this.inPrice = inPrice;
		this.name = name;
		this.wear = wear;
	}

	public int worth(){
		return inPrice*wear/10;

	}

	public String name() {
		return name;
	}

}


