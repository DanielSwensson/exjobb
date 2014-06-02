 abstract public class Vardesak {
	 
	private String vardesaksNamn;
	
	//Konstruktor
	public Vardesak (String vN){
		vardesaksNamn=vN;
	
	}
	
	//Metod fšr att hŠmta namn.
	public String getVardesaksNamn() {
		return vardesaksNamn;
		
	}
	//Metod fšr att hŠmta vŠrde.
	abstract public double getVarde();
	
 	}
 