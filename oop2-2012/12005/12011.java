
public class Smycke extends Pryl{
	private int antal�delstenar;
	private String val�r;
	private int v�rde = 0;

	public Smycke(String na, int �del, String va){
		super (na);
		antal�delstenar=�del;
		val�r=va;
	}


	public int get�delstenar(){
		return antal�delstenar;
	}

	public String getVal�r() {
		return val�r;
	}
	public double getV�rde(){
		if (val�r.equalsIgnoreCase("Guld")) { 
			 v�rde = 2000+(500*antal�delstenar);	
		}
		else if(val�r.equalsIgnoreCase("Silver")){
			 v�rde  = 700+(500*antal�delstenar);
		}
		return v�rde;
	}
	
}


