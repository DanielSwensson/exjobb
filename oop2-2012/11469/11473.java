
public class Juveler extends Pryl {
	
	private String SmyckesTyp;
	private String Guld;
	private int Stenar;
	
	
	
	Juveler(String �, String t, String st, String g, int s){
		super(�, t);
		SmyckesTyp = st;
		Guld = g;
		Stenar = s;
	}
	
	public String toString(){
		return "Juveler: " + SmyckesTyp + " Gjort av guld: " + Guld + " Antal �delstenar: " + Stenar + " V�rde: " + getV�rde();
	}
	
	public double getV�rde(){
		if(Guld.equalsIgnoreCase("ja")){
			return 2000 + (Stenar * 500 ); 
		} else {
			return 700 + (Stenar * 500);
		}
	}
	
	public void nollV�rd(){
	}

}
