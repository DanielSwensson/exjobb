public class Smycke extends Pryl{

	private int antalÄdelstenar;
	private String material; 

	public Smycke(String prylNamn, int antalÄdelstenar,String material){
		super (prylNamn);
		this.antalÄdelstenar=antalÄdelstenar;
		this.material=material;
	}

	public int getAntalÄdelstenar (){
		return antalÄdelstenar;
	}
	public String getMaterial(){
		return material;
	}

	public int getVärde(){
		if (material.equalsIgnoreCase("Guld")) {
			return 2000+500*antalÄdelstenar;

		}else if (material.equalsIgnoreCase("Silver")) {
			return 700+500*antalÄdelstenar;
		}else{
			return -1;
		}
	}

}
