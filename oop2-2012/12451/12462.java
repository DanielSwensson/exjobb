
public class Smycke extends Pryl {


	private String material;
	private int ädelsten;



	public String getmaterial(){
		return material;
	}
	public int getädelstenar(){
		return ädelsten;
	}
	public Smycke( String prylNamn, String prylTyp, String material, int ädelsten){
		super (prylNamn, prylTyp);
		this.material=material;
		this.ädelsten=ädelsten;



	}
	public int getVärde (){

		if (material.equalsIgnoreCase("guld")){
			return 2000+ädelsten*500;

		}

		return 700+ädelsten*500;

	}

}


