
public class Apparater extends Pryl {
	
	private int ink�pspris;
	private int slitage;
	
	public Apparater(String tap, int slitage, int ink�pspris){	
		super(tap);
	this.slitage = slitage;
	this.ink�pspris = ink�pspris;
	}
	
	@Override
	public double getValue() {
		return ink�pspris *  0.1 * slitage;
	}

}

