
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
	
	public int v�rde(){
		return antal*pris;
	}
	
	public void b�rskrasch(){
		pris = 0;
	}
}
