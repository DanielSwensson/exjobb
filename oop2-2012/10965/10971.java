
public class Smycke extends Pryl {
private int antalAdelstenar;
private String guld;

	public Smycke(String �gare, String namn, String guld, int antalAdelstenar) {
		super(�gare, namn);
		this.guld = guld;
		this.antalAdelstenar = antalAdelstenar;
	}
	public int getV�rde (){
		if (guld.equalsIgnoreCase("Ja")){
			return 2000+(antalAdelstenar*500);
		}
		else {
			return 700+(antalAdelstenar*500);
		}
	}	

}

