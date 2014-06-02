
public class Smycke extends Prylar {
	
	private int antalStenar;
	private String metallSort;
	
	
public Smycke(String n, int as, String ms){
		super(n);	
		antalStenar=as;
		metallSort=ms; 
			
		
		}

public int getVŠrde(){
	for (;;)
	if (metallSort.equalsIgnoreCase ("Guld"))
		return (2000+(500*antalStenar));
	
	else if (metallSort.equalsIgnoreCase("Silver"))
		return (700+(500*antalStenar));
	else
	System.out.println("Felaktig metallsort");
	
}
public String getPrylNamn(){
	return namn;
}

}