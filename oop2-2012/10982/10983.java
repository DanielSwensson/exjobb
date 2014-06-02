
class Aktie extends Pryl {

	private String pNamn;
	private int antal;
	private int pris;
	
	
	public Aktie(String pNamn, int antal, int pris){
		this.pNamn = pNamn;
		this.antal = antal;
		this.pris = pris;
	}
	
	public String getpNamn(){
		return pNamn;
	}
	
	public void setPris(int pris){
		this.pris = pris;
	}
	
	public int värde(){
		return antal*pris;
	}
	
	public void börskrasch(){
		pris = 0;
	}
}
