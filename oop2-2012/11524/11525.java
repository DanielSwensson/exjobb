//En subklass till Pryl, som beskriver en pryl av typ Aktie
public class Aktie extends Pryl {

	private int antal;
	private int pris;
	private boolean �rAktie = true;
	
	public Aktie (String namn, int v�rde, int antal, int pris){
		super(namn, v�rde);
		this.antal = antal;
		this.pris = pris;
		r�knaV�rde();
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
	
	public void r�knaV�rde (){
		super.v�rde = this.antal * this.pris;
		
	}
	
	public boolean �rAktie (){
		return �rAktie;
	}
	
}
