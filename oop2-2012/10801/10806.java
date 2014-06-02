
public class Apparat extends Pryl {


	private int slitage;
	private int ink�pspris;

	public Apparat(String namn, int slitage, int ink�pspris) {
		super(namn);
		this.slitage = slitage;
		this.ink�pspris = ink�pspris;
	}
	
	public int kalkyleraV�rde() {
		return (int)((double)ink�pspris*((double)slitage/10) +0.5); // +0.5 "s� att den avrundar upp�t" som normala m�nniskor(ok, datorn kanske inte �r en m�nniska men �nd�) 
	}
	
	
	public String toString() {
		return getNamn() +  ": " +  String.valueOf(kalkyleraV�rde());
	}
	
	
	
	public String getTyp() {
		return "Apparat";
	}
	   
}
