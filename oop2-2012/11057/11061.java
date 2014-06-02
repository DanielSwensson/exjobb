
class Gadget extends Item{

	private int wear;
	
	private int gadgetPrice;
	
	Gadget(String gO, int gP, int w) {
		super(gO);
		wear = w;
		gadgetPrice = gP;
	}
	
	public double returnValue(){
		return (double) gadgetPrice * (wear/10);	
	}
	
}
