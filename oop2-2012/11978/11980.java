
public class Apparat extends Pryl{

	private int slitage, apPris;

	public Apparat (String pNamn, int slitage, int apPris){
		super(pNamn);
		this.slitage = slitage;
		this.apPris = apPris;
	}
	
	public double getV�rde(){
		v�rde = apPris * (slitage / 10.0);
		return v�rde;
	}
	
	public String toString(){
		return super.toString();
	}
}