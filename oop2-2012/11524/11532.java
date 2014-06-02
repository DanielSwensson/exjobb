//En subklass till Pryl, som beskriver en pryl av typ Smyckes
public class Smycke extends Pryl {

	private int �delstenar;
	private boolean guld;
	
	
	public Smycke (String namn, int v�rde, int �delstenar, boolean guld){
		super(namn, v�rde);
		this.�delstenar = �delstenar;
		this.guld = guld;
		r�knaV�rde();
	}
	
	public int get�delsten (){
		return �delstenar;
	}
	
	public boolean getGuld(){
		return guld;
	}
	public void setGuld (boolean guld){
		this.guld = guld;
	}
	
	public void set�delstenar (int �delstenar){
		this.�delstenar = �delstenar;
	}
	
	public int r�knaV�rde (){
		if (guld){
			this.v�rde= 2000 + (�delstenar * 500);
			return this.v�rde;
		} else {
			this.v�rde = 700 + (�delstenar * 500);
			return this.v�rde;
		}
	}	
}
