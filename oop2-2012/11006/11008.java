
public class Apparat extends Pryl{

	private int ink�pspris;
	private int slitage;

	Apparat(String prylNamn, int ink�pspris, int slitage){
		super(prylNamn);
		this.ink�pspris = ink�pspris;
		this.slitage = slitage;
	}

	public double v�rde(){
		return (ink�pspris/10.0)*slitage;
	}
}