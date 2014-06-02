
public class Aktie extends Pryl {
	private int v�rde;
	private int antal;
		
	public Aktie(String namn,int v�rde, int antal){
		super(namn);
		this.v�rde = v�rde;
		this.antal = antal;
		
		
	}
	
	public int kalkyleraV�rde() {
		return v�rde * antal;
	}

	public String toString() {																						
		return " Aktie: " + getNamn() + " Antal: " + antal + " V�rde per aktie: " + v�rde + " Totalt v�rde: " + String.valueOf(kalkyleraV�rde()) + "\n";
	}
	public void �ndraV�rde(int nyttV�rde){
		v�rde = nyttV�rde;
	}

	public String getTyp() {
		return "Aktie";
	}
	

}
