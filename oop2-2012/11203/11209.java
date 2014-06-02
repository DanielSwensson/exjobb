public class Smycke extends Pryl{

	private int antal�delstenar;
	private String material; 

	public Smycke(String prylNamn, int antal�delstenar,String material){
		super (prylNamn);
		this.antal�delstenar=antal�delstenar;
		this.material=material;
	}

	public int getAntal�delstenar (){
		return antal�delstenar;
	}
	public String getMaterial(){
		return material;
	}

	public int getV�rde(){
		if (material.equalsIgnoreCase("Guld")) {
			return 2000+500*antal�delstenar;

		}else if (material.equalsIgnoreCase("Silver")) {
			return 700+500*antal�delstenar;
		}else{
			return -1;
		}
	}

}
