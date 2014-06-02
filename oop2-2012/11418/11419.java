
class Appliance extends Stuff {

	private int newPrice; //nypris p� apparat
	private double tear; //slitage p� apparat

	public Appliance (String owner, String stuffCategory, String subStuff, int newPrice, double tear){
		super(owner, stuffCategory, subStuff);
		this.newPrice = newPrice;
		this.tear = tear;
	}

	public double getValue(){
		return newPrice * (tear/10.0);
	}


}