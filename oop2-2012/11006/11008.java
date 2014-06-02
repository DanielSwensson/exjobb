
public class Apparat extends Pryl{

	private int inköpspris;
	private int slitage;

	Apparat(String prylNamn, int inköpspris, int slitage){
		super(prylNamn);
		this.inköpspris = inköpspris;
		this.slitage = slitage;
	}

	public double värde(){
		return (inköpspris/10.0)*slitage;
	}
}