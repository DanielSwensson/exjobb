
public class Aktie extends Pryl {
	private int antal;
	private double pris;
	
	public Aktie(String namn, int antal, int pris){
		super(namn);
		this.antal = antal;
		this.pris = pris;
	}
	
	public void setPris(int pris){
		this.pris = pris;
	}
	public double getVärde(){
		return antal*pris; //testa
	}

}
