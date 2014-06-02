
public class Apparat extends Pryl {
	private double grundPris;
	private int slitage; //1-10
	
	public Apparat(String namn, double grundpris, int slitage){
		super(namn);
		this.grundPris = grundpris;
		this.slitage = slitage;
		if(slitage < 1 || slitage > 10)
			throw new IllegalArgumentException("slitage="+slitage);
	}
	
	public double getV�rde(){
		return grundPris*slitage/10.0;
	}
	
}
