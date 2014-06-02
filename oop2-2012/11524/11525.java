//En subklass till Pryl, som beskriver en pryl av typ Aktie
public class Aktie extends Pryl {

	private int antal;
	private int pris;
	private boolean ärAktie = true;
	
	public Aktie (String namn, int värde, int antal, int pris){
		super(namn, värde);
		this.antal = antal;
		this.pris = pris;
		räknaVärde();
	}
	
	public void setAntal (int antal){
		this.antal = antal;
	}
	
	
	public void setPris (int pris){
		this.pris = pris;
	}
	
	public int getAntal (){
		return antal;
	}
	
	public int getPris (){
		return pris;
	}
	
	public void räknaVärde (){
		super.värde = this.antal * this.pris;
		
	}
	
	public boolean ärAktie (){
		return ärAktie;
	}
	
}
