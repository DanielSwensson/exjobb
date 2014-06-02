
public class Smycke extends Pryl{
	private int antalÄdelstenar;
	private String valör;
	private int värde = 0;

	public Smycke(String na, int ädel, String va){
		super (na);
		antalÄdelstenar=ädel;
		valör=va;
	}


	public int getÄdelstenar(){
		return antalÄdelstenar;
	}

	public String getValör() {
		return valör;
	}
	public double getVärde(){
		if (valör.equalsIgnoreCase("Guld")) { 
			 värde = 2000+(500*antalÄdelstenar);	
		}
		else if(valör.equalsIgnoreCase("Silver")){
			 värde  = 700+(500*antalÄdelstenar);
		}
		return värde;
	}
	
}


