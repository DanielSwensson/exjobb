
public class Apparater extends Pryl {
	
	private int inköpspris;
	private int slitage;
	
	public Apparater(String tap, int slitage, int inköpspris){	
		super(tap);
	this.slitage = slitage;
	this.inköpspris = inköpspris;
	}
	
	@Override
	public double getValue() {
		return inköpspris *  0.1 * slitage;
	}

}

