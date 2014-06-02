
public class Aktier extends Pryl {
private int antal;
private int pris;

	public Aktier (String ägare, String namn, int antal, int pris){
		super(ägare, namn);
		this.antal = antal;
		this.pris = pris;
	}
	public int getVärde (){
		return antal*pris;
	}
	public void setVärde (int ändring){
		pris = ändring;
	}
}

