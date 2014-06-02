
public class Aktie extends Pryl {
	private int värde;
	private int antal;
		
	public Aktie(String namn,int värde, int antal){
		super(namn);
		this.värde = värde;
		this.antal = antal;
		
		
	}
	
	public int kalkyleraVärde() {
		return värde * antal;
	}

	public String toString() {																						
		return " Aktie: " + getNamn() + " Antal: " + antal + " Värde per aktie: " + värde + " Totalt värde: " + String.valueOf(kalkyleraVärde()) + "\n";
	}
	public void ändraVärde(int nyttVärde){
		värde = nyttVärde;
	}

	public String getTyp() {
		return "Aktie";
	}
	

}
