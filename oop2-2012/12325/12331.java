
public class Smycke extends Pryl {

	private String guld;
	private int antalAdelstenar;
	public double getVarde;


	public Smycke(String namn, String guld, int antalAdelstenar){
		super(namn);
		this.guld = guld;
		this.antalAdelstenar = antalAdelstenar;
	}



	public double getVarde(){
		if (guld.toLowerCase().equalsIgnoreCase("ja")){
			return 2000+(antalAdelstenar*500);}
		else {
			return 700+(antalAdelstenar*500);
		}
	}
}