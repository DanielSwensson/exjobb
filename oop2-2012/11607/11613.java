 abstract public class Vardesak {
	 
	private String vardesaksNamn;
	
	//konstruktor nedan
	public Vardesak (String vN){
		vardesaksNamn=vN;
	
	}
	
	// metod för att hämta namn
	public String getVardesaksNamn() {
		return vardesaksNamn;
		
	}
	// metod för att hämta värde
	abstract public double getVarde();
	
 	}
 