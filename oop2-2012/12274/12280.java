 abstract public class Vardesak {
	 
	private String vardesaksNamn;
	
	//Konstruktor
	public Vardesak (String vN){
		vardesaksNamn=vN;
	
	}
	
	//Metod f�r att h�mta namn.
	public String getVardesaksNamn() {
		return vardesaksNamn;
		
	}
	//Metod f�r att h�mta v�rde.
	abstract public double getVarde();
	
 	}
 