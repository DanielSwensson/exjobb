 abstract public class Vardesak {
	 
	private String vardesaksNamn;
	
	//konstruktor nedan
	public Vardesak (String vN){
		vardesaksNamn=vN;
	
	}
	
	// metod f�r att h�mta namn
	public String getVardesaksNamn() {
		return vardesaksNamn;
		
	}
	// metod f�r att h�mta v�rde
	abstract public double getVarde();
	
 	}
 