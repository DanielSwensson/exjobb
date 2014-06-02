
public class Aktiepost extends Pryl{
	private int antal;
	private int pris;
	
	public double getVärde(){
		return (antal*pris);
	}
	public Aktiepost(String namn,int antal, int pris){
		super(namn);
		this.antal= antal;
		this.pris= pris;
	}
	
	public void påverkaAvKrasch() {
		pris = 0;
	}
}
