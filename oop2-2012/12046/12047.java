
public class Aktiepost extends Pryl{
	private int antal;
	private int pris;
	
	public double getV�rde(){
		return (antal*pris);
	}
	public Aktiepost(String namn,int antal, int pris){
		super(namn);
		this.antal= antal;
		this.pris= pris;
	}
	
	public void p�verkaAvKrasch() {
		pris = 0;
	}
}
