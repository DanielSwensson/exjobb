
public class Smycke extends Pryl {
private int antalAdelstenar;
private String guld;

	public Smycke(String ägare, String namn, String guld, int antalAdelstenar) {
		super(ägare, namn);
		this.guld = guld;
		this.antalAdelstenar = antalAdelstenar;
	}
	public int getVärde (){
		if (guld.equalsIgnoreCase("Ja")){
			return 2000+(antalAdelstenar*500);
		}
		else {
			return 700+(antalAdelstenar*500);
		}
	}	

}

