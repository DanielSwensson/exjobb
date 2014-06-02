
public class Apparat extends Pryl {


	private int slitage;
	private int inköpspris;

	public Apparat(String namn, int slitage, int inköpspris) {
		super(namn);
		this.slitage = slitage;
		this.inköpspris = inköpspris;
	}
	
	public int kalkyleraVärde() {
		return (int)((double)inköpspris*((double)slitage/10) +0.5); // +0.5 "så att den avrundar uppåt" som normala människor(ok, datorn kanske inte är en människa men ändå) 
	}
	
	
	public String toString() {
		return getNamn() +  ": " +  String.valueOf(kalkyleraVärde());
	}
	
	
	
	public String getTyp() {
		return "Apparat";
	}
	   
}
