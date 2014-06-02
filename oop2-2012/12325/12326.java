
public class Aktie extends Pryl {

	private int antal;
	private double pris;
	public double getVarde;

	public Aktie(String namn, double pris, int antal){
		super(namn);
		this.antal = antal;
		this.pris = pris;
	}

	public double getVarde(){
		return antal * pris;
	}

	public void krasch(){ //?????
		pris = 0;
	} 
}