
public class Aktier extends Pryl {
private int antal;
private int pris;

	public Aktier (String �gare, String namn, int antal, int pris){
		super(�gare, namn);
		this.antal = antal;
		this.pris = pris;
	}
	public int getV�rde (){
		return antal*pris;
	}
	public void setV�rde (int �ndring){
		pris = �ndring;
	}
}

