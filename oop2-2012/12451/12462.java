
public class Smycke extends Pryl {


	private String material;
	private int �delsten;



	public String getmaterial(){
		return material;
	}
	public int get�delstenar(){
		return �delsten;
	}
	public Smycke( String prylNamn, String prylTyp, String material, int �delsten){
		super (prylNamn, prylTyp);
		this.material=material;
		this.�delsten=�delsten;



	}
	public int getV�rde (){

		if (material.equalsIgnoreCase("guld")){
			return 2000+�delsten*500;

		}

		return 700+�delsten*500;

	}

}


